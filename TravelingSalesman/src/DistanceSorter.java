import java.util.Comparator;

public class DistanceSorter implements Comparator<Individual>{
	@Override
	public int compare(Individual guy1, Individual guy2) {
		return guy1.travelDistance.compareTo(guy2.travelDistance);
	}
}