
public class Map {
	
	int cityCount = 30;
	
	// Array that hold the distances between cities
	int[][] distanceArray = new int[cityCount][cityCount];
	
	public Map() {		
		
		int distanceRange = 500;
		
		// Runs through all 30 cities
		for(int i = 0; i < cityCount; i++) {
			
			for(int j = i + 1; j < cityCount; j++) {
				int map = (int) (Math.random() * distanceRange + 1);
				if(j != i) {
					distanceArray[i][j] = map;
					distanceArray[j][i] = map;
				}
			}
		}		
	}	
}
