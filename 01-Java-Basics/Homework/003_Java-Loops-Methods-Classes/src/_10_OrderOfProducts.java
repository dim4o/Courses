import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _10_OrderOfProducts {

	private static Scanner fileReader = null;
	private static PrintStream fileWriter = null;

	public static void main(String[] args) {

		File inputProducts = new File("./src/10_Products.txt");
		File inputOrder = new File("./src/10_Order.txt");
		File outputFile = new File("./src/10_Output.txt");
		ArrayList<Product> productsList = new ArrayList<Product>();
		Map<String, Double> orderMap = new TreeMap<String, Double>();

		try {
			fileReader = new Scanner(inputProducts);
			while (fileReader.hasNextLine()) {

				String lineString = fileReader.nextLine();
				String[] lineStrings = lineString.split(" ");
				String name = lineStrings[0];
				double price = Double.parseDouble(lineStrings[1]);

				Product currProduct = new Product(name, price);
				productsList.add(currProduct);
			}

			fileReader = new Scanner(inputOrder);
			while (fileReader.hasNextLine()) {
				String lineString = fileReader.nextLine();
				String[] lineStrings = lineString.split(" ");
				Double quantity = Double.parseDouble(lineStrings[0]);
				String name = lineStrings[1];

				if (orderMap.containsKey(name)) {
					Double count = orderMap.get(name);
					orderMap.put(name, count + quantity);
				} else {
					orderMap.put(name, quantity);
				}
			}   
			double sum = 0.0d;
			for (Product product : productsList) {
				if(orderMap.containsKey(product.getName())){
					sum += (orderMap.get(product.getName()))*product.getPrice();
				}
			}
			fileWriter = new PrintStream(outputFile);
			fileWriter.printf("%.1f", sum);

		} catch (FileNotFoundException fnf) {

			System.out.println("Error");

		} finally {

			if (fileReader != null) {
				fileReader.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
		}
	}
}
class Product{
	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}
}
