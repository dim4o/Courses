import java.util.Scanner;

public class _08_ExtractEmails {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		String text = input.nextLine();
		text = text.replaceAll(",", " ");

		String[] words = text.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (words[i].charAt(words[i].length() - 1) == '.') {
				words[i] = words[i].substring(0, words[i].length() - 1);
			}
			if (isValidEmail(words[i])) {
				System.out.println(words[i]);
			}
		}
	}

	public static boolean isValidEmail(String word) {
		String[] email = word.split("@");
		if (email.length == 2) {

			String userName = email[0];
			String hostName = email[1];

			String regexUserName1 = "[[^a-zA-Z_0-9]&&[^.]&&[^-]&&[^_]]";
			String regexUserName2 = "[[.][-][_]]";

			String regexHostName1 = "[[^a-zA-Z]&&[^.]&&[^-]]";
			String regexHostName2 = "[[.][-]]";

			if (isValidName(userName, regexUserName1, regexUserName2)
					&& isValidName(hostName, regexHostName1, regexHostName2)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidName(String userName, String regex1,
			String regex2) {

		String userName1 = userName + "a";
		if (userName1.split(regex1).length > 1) {
			return false;
		}

		String userName2 = userName + " ";
		String[] userNameArr = userName2.split(regex2);
		for (int j = 0; j < userNameArr.length; j++) {
			if (userNameArr[j].equals("") || userNameArr[j].equals(" ")) {
				return false;
			}
		}
		return true;
	}
}
