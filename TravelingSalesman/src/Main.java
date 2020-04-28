
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Starting Program");
		
		int counter = 200;
		
		Population pop = new Population();
		
		for(int i = 0; i < counter; i++) {
			pop.travel();
			
			pop = new Population(pop);
		}
		
		System.out.println("Iteration ID,Top Performer ID,Top Performer Distance,Upper Performer ID,Upper Performer Distance,Mid Performer ID,Mid Performer Distance, Lower Performer ID,Lower Performer Distance,Bottom Performer ID,Bottom Performer Distance");
		
		for(int i = 0; i < counter; i++) {
			System.out.print((i+1) + ",");
			System.out.print(pop.topPerformers.get(i).toString());
			System.out.print(pop.upperPerformers.get(i).toString());
			System.out.print(pop.midPerformers.get(i).toString());
			System.out.print(pop.lowerPerformers.get(i).toString());
			System.out.print(pop.bottomPerformers.get(i).toString());
			System.out.println();
		}
		
		/*
		System.out.println();
		
		for(Individual guy : pop.topPerformers) {
			System.out.print(guy.toString());
		}
		
		System.out.println();
		
		for(Individual guy : pop.upperPerformers) {
			System.out.print(guy);
		}
		
		System.out.println();
		
		for(Individual guy : pop.midPerformers) {
			System.out.print(guy);
		}
		
		System.out.println();
		
		for(Individual guy : pop.lowerPerformers) {
			System.out.print(guy);
		}
		
		System.out.println();
		
		for(Individual guy : pop.bottomPerformers) {
			System.out.print(guy);
		}
		*/
	}
}
