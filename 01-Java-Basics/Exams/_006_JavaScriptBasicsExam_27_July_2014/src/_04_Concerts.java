import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Concerts {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLInes = Integer.parseInt(input.nextLine());

		Map<String, Map<String, ArrayList<String>>> concertsMap = new TreeMap<String, Map<String, ArrayList<String>>>();

		for (int i = 0; i < numOfLInes; i++) {
			String currLine = input.nextLine();
			String[] currLineArr = currLine.split(" \\| ");
			//System.out.println(Arrays.toString(currLineArr));
			String band = "\"" + currLineArr[0] + "\"";
			String city = "\"" + currLineArr[1] + "\"";
			String venue = "\"" + currLineArr[3] + "\"";
			Map<String, ArrayList<String>> venuesMap = concertsMap.get(city);
			if (venuesMap != null) {
				ArrayList<String> bandsList = venuesMap.get(venue);
				if (bandsList != null) {
					bandsList.add(band);
					venuesMap.put(venue, bandsList);
				} else {
					bandsList = new ArrayList<String>();
					bandsList.add(band);
					venuesMap.put(venue, bandsList);
				}
				//начин за премахване на повторенията в лист.
				//правя HashSet и бутам листа вътре
				HashSet<String> hs = new HashSet<String>();
				hs.addAll(bandsList);
				//чистя листа и добавям към него хеш сета
				bandsList.clear();
				bandsList.addAll(hs);
				//сортирам листа
				Collections.sort(bandsList);
				
			} else {
				venuesMap = new TreeMap<String, ArrayList<String>>();
				ArrayList<String> bandsList = new ArrayList<String>();
				bandsList.add(band);
				venuesMap.put(venue, bandsList);
				concertsMap.put(city, venuesMap);
				HashSet<String> hss = new HashSet<String>();
				hss.addAll(bandsList);
				bandsList.clear();
				bandsList.addAll(hss);
				Collections.sort(bandsList);
				
			}
		}
		String concertMapString = concertsMap.toString();
		concertMapString = concertMapString.replaceAll("\\=", ":");
		concertMapString = concertMapString.replaceAll(", ", ",");
		System.out.println(concertMapString);
	}

}
