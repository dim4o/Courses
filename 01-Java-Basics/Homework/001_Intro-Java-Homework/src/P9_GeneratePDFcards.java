import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class P9_GeneratePDFcards {

	private static String file = "C:/Users/Dimcho/Desktop/FirstPdf.pdf";

	public static void main(String[] args) throws DocumentException,
			IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();

		PdfPTable table = new PdfPTable(7);
		String[] cards = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5",
				"4", "3", "2" };
		String[] suits = { "♠", "♦", "♣", "♥" };

		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				PdfPCell cell = new PdfPCell();
				cell.setBorderWidth(0f);
				cell.setPaddingTop(10);
				String text = cards[i] + suits[j];
				if (suits[j] == "♦" || suits[j] == "♥") {
					cell.addElement(createTable(text, "red"));
				} else {
					cell.addElement(createTable(text, "black"));
				}
				table.addCell(cell);
			}
		}
		PdfPCell cell = new PdfPCell();
		cell.setBorderWidth(0f);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		document.add(table);
		document.close();
	}

	public static PdfPTable createTable(String str, String color)
			throws DocumentException, IOException {
		BaseFont unicode = BaseFont.createFont("c:/windows/fonts/arial.ttf",
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font redFont = new Font(unicode, 18);
		redFont.setColor(250, 0, 0);
		Font blackFont = new Font(unicode, 18);

		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(85 / 1f);
		PdfPCell cell;
		if (color == "red") {
			cell = new PdfPCell(new Paragraph(str, redFont));
		} else {
			cell = new PdfPCell(new Paragraph(str, blackFont));
		}

		cell.setFixedHeight(65);
		cell.setPaddingTop(20f);
		cell.setPaddingLeft(12f);
		table.addCell(cell);

		return table;
	}
}
