package _010_CSharpBasicsExam_22_August_2014;

import java.util.Scanner;

public class _01_TablesVar {

	public static void main(String[] args) {
		// input
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		long packet1 = Long.parseLong(input.nextLine());
		long packet2 = Long.parseLong(input.nextLine());
		long packet3 = Long.parseLong(input.nextLine());
		long packet4 = Long.parseLong(input.nextLine());
		long topsT = Long.parseLong(input.nextLine());
		long topsN = Long.parseLong(input.nextLine());

		long totalLegsCount = packet1 * 1 + packet2 * 2 + packet3 * 3 + packet4* 4;
		long legsNeeded = topsN * 4 - totalLegsCount;
		
		//nedostaty4no plotove i nedostat4no kraka
		if (topsT < topsN && totalLegsCount < topsN * 4) {
			System.out.printf("less: %s%n", topsT - topsN);
			System.out.printf("tops needed: %s, legs needed: %s", topsN - topsT, legsNeeded);
		} else 
		//nedostaty4no plotove, no dostat4no kraka
		if (topsT < topsN && totalLegsCount >= topsN * 4) {
			System.out.printf("less: %s%n", topsT - topsN);
			System.out.printf("tops needed: %s, legs needed: 0", topsN - topsT);
		} else
		//dostaty4no plotove no nedostaty4no kraka
		if (topsT > topsN && totalLegsCount < topsN * 4) {
			System.out.printf("less: %s%n", totalLegsCount%4 - topsN);
			System.out.printf("tops needed: 0, legs needed: %s", topsN * 4 - totalLegsCount);
		} else 
		//dostaty4no plotove i dostaty4no kraka
		if	(topsT > topsN && totalLegsCount > topsN * 4){
			System.out.printf("more: %s%n", topsT - topsN);
			System.out.printf("tops left: %s, legs left: %s", topsT - topsN,
					totalLegsCount - topsN * 4);
		} else {
			System.out.printf("Just enough tables made: %s", topsN);
		}	
	}
}
