import java.util.Scanner;
//15:36 -- 16:04 --> 28 minutes, 100/100 от първия път. 
//Ако бях обърнал внимание на факта, че се търсят кратни на 360 
//щях да я направя за под 10мин сигурно. И ако не ми висяха колегите на главата...

public class _02_AddingAngles {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner inpuScanner = new Scanner(System.in);
		int num = Integer.parseInt(inpuScanner.nextLine());
		String lineString = inpuScanner.nextLine();
		String[] numberStrings = lineString.split(" ");
		boolean exist = false;
		
		for (int i1 = 0; i1 < num; i1++) {
			for (int i2 = i1 + 1; i2 < num; i2++) {
				for (int i3 = i2 + 1; i3 < num; i3++) {
					
					int a = Integer.parseInt(numberStrings[i1]);
					int b = Integer.parseInt(numberStrings[i2]);
					int c = Integer.parseInt(numberStrings[i3]);
					if ((a+b+c) % 360 == 0) {//i1 != i2 && i1 != i3 && i2 != i3 && 
						System.out.printf("%s + %s + %s = %s degrees%n", a, b, c, a+b+c);
						exist = true;
					}
				}
			}
		}
		if (exist == false) {
			System.out.println("No");
		}
	}
}
