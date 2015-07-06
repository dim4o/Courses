import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _09_ListOfProducts {

	private static Scanner fileReader;
	private static PrintStream fileOutput;
	private static _09_ListOfProducts inHouse = new _09_ListOfProducts();

	public static void main(String[] args) {

		File inputFile = new File("./src/09_Input.txt");
		File outputFile = new File("./src/09_Output.txt");
		ArrayList<Product> products = new ArrayList<Product>();

		try {
			fileReader = new Scanner(inputFile);
			fileOutput = new PrintStream(outputFile);
			while (fileReader.hasNextLine()) {
				String currRow = fileReader.nextLine();
				String[] currLine = currRow.split(" ");
				String name = currLine[0];
				double price = Double.parseDouble(currLine[1]);
				Product currProduct = inHouse.new Product(name, price);
				products.add(currProduct);
			}
			// sorts and prints result to file
			Collections.sort(products);
			for (Product product : products) {
				fileOutput.printf("%.2f %s", product.getPrice(),
						product.getName());
				fileOutput.println();
			}

		} catch (FileNotFoundException fnf) {
			System.out.println("Error: missing file");
			fnf.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
			if (fileOutput != null) {
				fileOutput.close();
			}
		}
	}

	// inner class
	private class Product implements Comparable<Product> {
		private String name;
		private double price;

		public Product(String name, double price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		@Override
		public int compareTo(Product product) {
			if (this.price - product.price > 0) {
				return 1;
			} else if (this.price - product.price < 0) {
				return -1;
			}
			return 0;
		}
	}
}
