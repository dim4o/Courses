import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _11_Excel {
	
	public static void main(String[] args) {
		
		@SuppressWarnings({ "resource", "unused" })
		Scanner input = new Scanner(System.in);
		String inputPath = "./src/3. Incomes-Report.xlsx";//input.nextLine();
		Map<String, Double> incomesMap = new TreeMap<String, Double>();
		try {
			FileInputStream file = new FileInputStream(new File(inputPath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int rowCounter = 1; rowCounter < sheet.getPhysicalNumberOfRows(); rowCounter++) {
				Row currRow = sheet.getRow(rowCounter);
				Cell officeCell = currRow.getCell(0);
				Cell totalIncomesCell = currRow.getCell(5);
				
				String office = officeCell.toString();
				Double total = totalIncomesCell.getNumericCellValue();
				
				if (incomesMap.containsKey(office)) {
					Double oldValue = incomesMap.get(office);
					incomesMap.put(office, oldValue + total);
				} else {
					incomesMap.put(office, total);
				}
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		double grandTotal = 0;
		for (Entry<String, Double> entrySet: incomesMap.entrySet()) {
			System.out.printf("%s Total -> %.2f%n", entrySet.getKey(), entrySet.getValue());
			grandTotal+=entrySet.getValue();
		}
		System.out.printf("Grand Total -> %.2f%n", grandTotal);
	}
}
