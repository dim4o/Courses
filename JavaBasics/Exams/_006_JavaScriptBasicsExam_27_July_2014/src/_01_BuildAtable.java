import java.util.Scanner;
//Бях улисан в други подробности, но не забелязах доста съществен момент - резултата може да прехвърли int, 
//затова трябва да се ползва long. Само един тест гърми с int, но е достатъчно...
public class _01_BuildAtable {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int start = Integer.parseInt(input.nextLine());
		int end = Integer.parseInt(input.nextLine());
		System.out.println("<table>");
		System.out.println("<tr><th>Num</th><th>Square</th><th>Fib</th></tr>");
		for (int i = start; i <= end; i++) {
			long num = i;
			long square = num*num;
			String fib = isFib(num);
			System.out.printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>%n", num, square, fib);
		}
		System.out.println("</table>");
	}

	public static String isFib(long num) {
		long first = 0;
		long second = 1;
		long fib = 1;
		while (fib < num) {
			first = second;
			second = fib;
			fib = first + second;
		}
		if (fib == num) {
			return "yes";
		}
		return "no";
	}
}
