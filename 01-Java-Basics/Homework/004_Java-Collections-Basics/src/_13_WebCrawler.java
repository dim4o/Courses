import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class _13_WebCrawler {
 
	public static List<String> extractLinks(String url){

		ArrayList<String> result = new ArrayList<String>();
		Document doc = Jsoup.parse(url);
		try {
			doc = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.referrer("http://www.google.com").get();
		} catch (NullPointerException e) {
			// e.printStackTrace();
		} catch (HttpStatusException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
		}
		Elements links = doc.select("a[href]");

		// href ...
		for (Element link : links) {
			if (!link.toString().toLowerCase().matches("(.jpg$)|(.gif$)|(.png$)(.bmp$)(.tiff$)")) {
				result.add(link.attr("abs:href"));
			}		
		}
		return result;
	}

	public static HashSet<String> set = new HashSet<String>();
	public static PrintStream fileWriter = null;

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please, input level:");
		fileWriter = new PrintStream("output.txt");
		String site = "https://about.pinterest.com/en";
		int level = Integer.parseInt(input.nextLine());
		System.out.println("Please, wait...");
		BFS(site, level);
		System.out.println("Done! You can view the result at output.txt");
	}

	public static void BFS(String currSite, int level) throws IOException {
		
		if (level == 0) {
			return;
		}
		if (!set.contains(currSite)) {
			fileWriter.println(currSite);
		}
		//System.out.println(currSite);
		set.add(currSite);
		List<String> links = _13_WebCrawler.extractLinks(currSite);

		for (String link : links) {

			BFS(link, level - 1);
		}
	}
}