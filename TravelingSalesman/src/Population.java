import java.util.*;

public class Population {

	int popSize = 100;
	int IDCounter;
	double topPercent = 0.6;
	double randPercent = 0.1;
	double mutPercent = 0.1;
	Map map;
	
	ArrayList<Individual> topPerformers = new ArrayList<Individual>();	
	ArrayList<Individual> upperPerformers = new ArrayList<Individual>();
	ArrayList<Individual> midPerformers = new ArrayList<Individual>();
	ArrayList<Individual> lowerPerformers = new ArrayList<Individual>();
	ArrayList<Individual> bottomPerformers = new ArrayList<Individual>();
	
	ArrayList<Individual> popArray = new ArrayList<Individual>();
	ArrayList<Individual> childArray = new ArrayList<Individual>();
	
	public Population() {
		
		IDCounter = 0;
		
		map = new Map();
		
		// Fills up the popArray with 100 individuals
		for(int i = 0; i < popSize; i++) {
			
			// Create an individual and generates his path
			Individual guy = new Individual(IDCounter++);
			
			// Add the individual to the array
			popArray.add(guy);
		}		
	}
	
	// Transfer all necessary data out of old pop into new pop
	public Population(Population pop) {
		
		IDCounter = pop.IDCounter;
		
		int topNumber = (int)(popSize * topPercent);
		int randNumber = (int)(popSize * randPercent);
		int childNumber = popSize - topNumber - randNumber;
		int mutChild = (int)(childNumber * mutPercent);
		
		ArrayList<Integer> mutChildIndex = new ArrayList<Integer>();
		
		map = pop.map;
		
		for(int i = 0; i < topNumber; i++) {
			this.popArray.add(pop.popArray.get(i));
		}
		
		// Add all random individuals
		for(int i = 0; i < randNumber; i++) {
			this.popArray.add(new Individual(IDCounter++));
		}
		
		for(int i = 0; i < childNumber; i++) {
			this.childArray.add(new Individual(this.popArray.get(i*2), this.popArray.get(i*2+1), IDCounter++));
		}
		
		for(int i = 0; i < mutChild; i++) {
			int number = (int) (Math.random() * this.childArray.size());
			
			if(!mutChildIndex.contains(number)) {
				mutChildIndex.add(number);
				Individual child = this.childArray.get(number);
				child.mutate();
				this.childArray.set(number, child);
			}			
		}
		
		for(Individual child : childArray) {
			this.popArray.add(child);
		}
		
		this.topPerformers = pop.topPerformers;
		this.upperPerformers = pop.upperPerformers;
		this.midPerformers = pop.midPerformers;
		this.lowerPerformers = pop.lowerPerformers;
		this.bottomPerformers = pop.bottomPerformers;
	}
	
	public void travel() {
		
		// Calculates distance of path for individuals
		for(Individual guy : popArray) {
			guy.travel(map);
		}
		
		// Sort the travel distances in ascending order
		popArray.sort(new DistanceSorter());
		
		topPerformers.add(popArray.get(0));
		upperPerformers.add(popArray.get((int)(popSize * .25 - 1)));
		midPerformers.add(popArray.get((int)(popSize * .50 - 1)));
		lowerPerformers.add(popArray.get((int)(popSize * .75 - 1)));
		bottomPerformers.add(popArray.get(popSize - 1));
	}
}
