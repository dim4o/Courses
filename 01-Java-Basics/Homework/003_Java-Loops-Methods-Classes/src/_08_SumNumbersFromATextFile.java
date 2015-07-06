import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _08_SumNumbersFromATextFile {

	public static void main(String[] args) {
		File file = new File(
				"./src/08_input.txt");
		Scanner fileReader = null;

		try {
			fileReader = new Scanner(file);
			int sum = 0;

			if (!fileReader.hasNextLine()) {
				System.out.println("the file is empty");
			} else {
				while (fileReader.hasNextLine()) {
					int currNum = Integer.parseInt(fileReader.nextLine());
					sum += currNum;

				}
				System.out.println(sum);
			}
		} catch (FileNotFoundException e) {

			System.out.println("Error: missing file");
		} finally {
			if (fileReader != null) {
				fileReader.close();
				//System.out.println("Scanner closed.");
			}
		}
	}
}
