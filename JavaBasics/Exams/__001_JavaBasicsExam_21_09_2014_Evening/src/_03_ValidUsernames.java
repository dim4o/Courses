import java.util.ArrayList;
import java.util.Scanner;

public class _03_ValidUsernames {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String usernamesInput = input.nextLine();
		String[] username = usernamesInput.split("[/\\\\() ]+");
		ArrayList<String> validUsernames = new ArrayList<String>();
		for (String user : username) {
			if (isValid(user)) {
				validUsernames.add(user);
			}
		}
		int maxSum = 0;
		int bestIndex = 0;
		for (int i = 0; i < validUsernames.size() - 1; i++) {
			if (validUsernames.get(i).length() + validUsernames.get(i + 1).length() > maxSum) {
				maxSum = validUsernames.get(i).length() + validUsernames.get(i + 1).length();
				bestIndex = i;
			}
		}
		System.out.println(validUsernames.get(bestIndex));
		System.out.println(validUsernames.get(bestIndex + 1));

	}
	private static boolean isValid(String username){
		
		if (username.length() < 3 || username.length() > 25) {
			return false;
		}
		if (!username.replaceAll("[^a-zA-z_0-9_]", "").equals(username)) {
			return false;
		}
		if (!Character.isLetter(username.charAt(0))) {
			return false;
		}
		return true;
	}
}
