package _010_CSharpBasicsExam_22_August_2014;

//19:27 - 20:09 --> 80/100
import java.util.Scanner;

public class _01_Tables {

	public static void main(String[] args) {
		// input
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		long packet1 = Long.parseLong(input.nextLine());
		long packet2 = Long.parseLong(input.nextLine());
		long packet3 = Long.parseLong(input.nextLine());
		long packet4 = Long.parseLong(input.nextLine());
		long tops_T = Long.parseLong(input.nextLine());
		long tablesToMake_N = Integer.parseInt(input.nextLine());

		long totalLegsCount = packet1 * 1 + packet2 * 2 + packet3 * 3 + packet4* 4;
		long maxTablesCount = 0;
		
		if (tops_T >= totalLegsCount/4) {
			maxTablesCount = totalLegsCount/4;
		} else {
			maxTablesCount =  tops_T;
		}
		
		if (maxTablesCount > tablesToMake_N) {
			long topsLeft = tops_T - tablesToMake_N;
			long legsLeft = totalLegsCount - 4*tablesToMake_N;
			System.out.printf("more: %s%n", maxTablesCount - tablesToMake_N);
			System.out.printf("tops left: %s, legs left: %s", topsLeft,legsLeft);
		} else if (maxTablesCount < tablesToMake_N) {
			long topsNeeded = tablesToMake_N - tops_T;
			long legsNeeded =  4*tablesToMake_N - totalLegsCount;
			
			if (legsNeeded <= 0) {
				legsNeeded = 0;
			}
			System.out.printf("less: %s%n", maxTablesCount - tablesToMake_N);
			System.out.printf("tops needed: %s, legs needed: %s", topsNeeded, legsNeeded);
			
		} else {
			System.out.printf("Just enough tables made: %s", tablesToMake_N);
		}
	}
}
