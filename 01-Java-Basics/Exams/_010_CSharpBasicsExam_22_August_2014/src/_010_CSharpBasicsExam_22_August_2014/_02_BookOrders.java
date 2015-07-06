package _010_CSharpBasicsExam_22_August_2014;
import java.util.Scanner;

public class _02_BookOrders {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfOrders = Integer.parseInt(input.nextLine());
		int totalBooks = 0;
		double totalBooksCoas = 0;
		for (int i = 0; i < numOfOrders; i++) {
			int numOfPackets = Integer.parseInt(input.nextLine());
			int numOfBooksPerPacket = Integer.parseInt(input.nextLine());
			double bookPrice = Double.parseDouble(input.nextLine());
			totalBooks += numOfPackets * numOfBooksPerPacket;
			double discount = 0;
			double allBookCoast = 0;
			if (numOfPackets < 10) {
				discount = 0;
			} else if (numOfPackets >= 10 && numOfPackets <= 19) {
				discount = 0.05d;
			} else if(numOfPackets >= 20 && numOfPackets <= 29){
				discount = 0.06d;
			} else if (numOfPackets >= 30 && numOfPackets <= 39) {
				discount = 0.07d;
			} else if (numOfPackets >= 40 && numOfPackets <= 49) {
				discount = 0.08d;
			} else if (numOfPackets >= 50 && numOfPackets <= 59) {
				discount = 0.09d;
			} else if (numOfPackets >= 60 && numOfPackets <= 69) {
				discount = 0.10d;
			} else if (numOfPackets >= 70 && numOfPackets <= 79) {
				discount = 0.11d;
			} else if (numOfPackets >= 80 && numOfPackets <= 89) {
				discount = 0.12d;
			} else if (numOfPackets >= 90 && numOfPackets <= 99) {
				discount = 0.13d;
			} else if (numOfPackets >= 100 && numOfPackets <= 109) {
				discount = 0.14d;
			} else {
				discount = 0.15d;
			}
			bookPrice = bookPrice - bookPrice*discount;
			allBookCoast = bookPrice*numOfPackets * numOfBooksPerPacket;
			totalBooksCoas += allBookCoast;			
		}
		System.out.println(totalBooks);
		System.out.printf("%.2f",totalBooksCoas);
	}
}
