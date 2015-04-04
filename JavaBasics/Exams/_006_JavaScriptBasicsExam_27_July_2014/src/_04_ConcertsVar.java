import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class _04_ConcertsVar {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLInes = Integer.parseInt(input.nextLine());

		Map<String, Map<String, TreeSet<String>>> concertsMap = new TreeMap<String, Map<String, TreeSet<String>>>();

		for (int i = 0; i < numOfLInes; i++) {
			String currLine = input.nextLine();
			String[] currLineArr = currLine.split(" \\| ");
			String band = "\"" + currLineArr[0] + "\"";
			String city = "\"" + currLineArr[1] + "\"";
			String venue = "\"" + currLineArr[3] + "\"";
			Map<String, TreeSet<String>> venuesMap = concertsMap.get(city);
			if (venuesMap != null) {
				TreeSet<String> bandsList = venuesMap.get(venue);
				if (bandsList != null) {
					bandsList.add(band);
					venuesMap.put(venue, bandsList);
				} else {
					bandsList = new TreeSet<String>();
					bandsList.add(band);
					venuesMap.put(venue, bandsList);
				}
				
			} else {
				venuesMap = new TreeMap<String, TreeSet<String>>();
				TreeSet<String> bandsList = new TreeSet<String>();
				bandsList.add(band);
				venuesMap.put(venue, bandsList);
				concertsMap.put(city, venuesMap);			
			}
		}
		String concertMapString = concertsMap.toString();
		concertMapString = concertMapString.replaceAll("\\=", ":");
		concertMapString = concertMapString.replaceAll(", ", ",");
		System.out.println(concertMapString);
	}
}
