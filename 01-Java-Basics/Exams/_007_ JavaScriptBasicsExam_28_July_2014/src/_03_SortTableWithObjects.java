import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _03_SortTableWithObjects {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.nextLine();
		List<Product> productsList = new ArrayList<Product>();
		String curString = input.nextLine();

		while (!curString.equals("</table>")) {

			String[] inputInfo = curString
					.split("(<tr><td>)|(</td><td>)|(</td></tr>)");
			String productName = inputInfo[1];
			Double productPrice = Double.parseDouble(inputInfo[2]);
			Product currProduct = new Product(productName, productPrice,curString);
			productsList.add(currProduct);
			curString = input.nextLine();
		}
		Collections.sort(productsList);
		System.out.println("<table>");
		System.out.println("<tr><th>Product</th><th>Price</th><th>Votes</th></tr>");
		for (Product product : productsList) {
			System.out.println(product.value);
		}
		System.out.println("</table>");
	}
}

class Product implements Comparable<Product>{
	public String name;
	public double price;
	public String value;
	public Product(String name, double price, String value){
		this.name = name;
		this.price = price;
		this.value = value;
	}
	@Override
	public int compareTo(Product product) {
		if (this.price > product.price) {
			return 1;
		} else if (this.price < product.price) {
			return -1;
		} else {
			return this.name.compareTo(product.name);
		}
	}
}
