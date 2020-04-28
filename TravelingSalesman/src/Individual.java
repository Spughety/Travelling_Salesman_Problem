import java.util.ArrayList;

public class Individual {
	
	int routeSize = 30;
	Integer travelDistance = 0;
	String individualID;
	boolean hasRun = false;
	
	ArrayList<Integer> pathList = new ArrayList<Integer>();

	public Individual(Integer IDNumber) {
		
		individualID = IDNumber.toString();
		
		// Generates a random path for the individual
		while(pathList.size() < routeSize) {
			int path = (int) (Math.random() * routeSize);
			
			// Makes sure the path choice does not already exist
			if(!pathList.contains(path)) {
				pathList.add(path);
			}
		}		
	}
	
	public Individual(Individual parent1, Individual parent2, Integer IDNumber) {	
		
		individualID = IDNumber.toString();		
		
		// Generates a swap point between 9 and 20
		int swapPoint = (int) (Math.random() * 12 + 9);
		
		// Taking all indexes up to the swap point from parent1
		for(int i = 0; i < swapPoint; i++) {
			pathList.add(parent1.pathList.get(i));
		}
		
		// Taking all indexes after the swap point from parent2
		for(int i = swapPoint; i < routeSize; i++) {
			pathList.add(parent2.pathList.get(i));
		}
	}
	
	public void mutate() {
		// Generates random index numbers
		int index1 = (int) (Math.random() * routeSize);
		int index2 = index1;
		
		// Makes index2 not equal to index1 ever
		while(index2 == index1) {
			index2 = (int) (Math.random() * routeSize);
		}
		
		// Stores the values at the indexes to be swapped
		int indexValue1 = pathList.get(index1);
		int indexValue2 = pathList.get(index2);
		
		// Swaps the indexes
		pathList.set(index1, indexValue2);
		pathList.set(index2, indexValue1);
	}
	
	public void travel(Map map) {
		
		if(!hasRun) {
			// Run the path along the map
			for(int i = 0; i < routeSize; i++) {
				
				// Checks if it is at the last location so it can run back
				if(i == routeSize - 1) {
					
					// Get the distance between the two locations
					travelDistance += map.distanceArray[pathList.get(i)][pathList.get(0)];
				}
				else {
					
					// Get the distance between the two locations
					travelDistance += map.distanceArray[pathList.get(i)][pathList.get(i + 1)];
				}			
			}
			hasRun = true;
		}	
	}
	
	@Override
	public String toString() {
		return individualID + "," + travelDistance + ",";
	}
}
