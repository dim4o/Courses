import java.util.Scanner;
import java.util.TreeSet;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String inputLine = input.nextLine();
		String[] numbersStrings = inputLine.split("[ ()]+");
		//System.out.println(Arrays.toString(numbersStrings));
		int[] numbers = new int[numbersStrings.length - 1];
		TreeSet<Integer> primeSet = new TreeSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numbersStrings[i+1]);
			if (isPrime(numbers[i])) {
				primeSet.add(numbers[i]);
			}
		}
		if (primeSet.size() < 3) {
			System.out.println("No");
		} else {
			int a = primeSet.pollLast();
			int b = primeSet.pollLast();
			int c = primeSet.pollLast();
			System.out.println(a+b+c);
		}
		//Integer[] result = primeSet.toArray(new Integer[primeSet.size()]);
	}

	private static boolean isPrime(int n) {
		 //check if n is a multiple of 2
		if (n == 2) {
			return true;
		}
	    if (n%2==0 || n <= 1) {
	    	return false;
	    }
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}
