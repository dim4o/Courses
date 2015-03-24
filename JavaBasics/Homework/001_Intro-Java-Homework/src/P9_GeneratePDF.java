//import java.util.Arrays;
//import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("serial")
class MyCanvas extends JComponent {

	public void paint(Graphics g) {
		int x1 = 10;
		int y1 = 10;
		int x2 = 35;
		int y2 = 50;
		String[] cards = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5",
				"4", "3", "2" };
		String[] suits = { "♠", "♦", "♣", "♥" };
int count = 0;
		for (int i = 0; i < cards.length; i++) {

			for (int j = 0; j < suits.length; j++) {
				g.setColor(Color.black);
                g.drawRect(x1, y1, x2, y2);
                g.setColor(Color.RED);
                if (suits[j] == "♠" || suits[j] == "♣") {
                	g.setColor(Color.black);
				}
        		g.drawString(cards[i] + suits[j], x1 + 10, (y2 + y1)- 20);
        		x1 += 50;
        		x2 = 35;
        		count++;
        		if (count == 6) {
					count = 0;
					x1 = 10;
					x2 = 35;
					y1 += 60;
					y2 = 50;
				}
			}
		}
		
	}
}

public class P9_GeneratePDF {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(0, 0, 350, 500);
		window.getContentPane().add(new MyCanvas());
		window.setCursor(null);
		window.setVisible(true);
		//new ObjectOutputStream("file.pdf").writeObject(window);
		//PrintFrameToPDF(window);
		
	}
	public static void PrintFrameToPDF(JFrame bill)  {
	    try {
	        Document d = new Document();
	        PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream ("sample.pdf"));
	        d.open ();

	        PdfContentByte cb = writer.getDirectContent( );
	        PdfTemplate template = cb.createTemplate(600, 800);
	        @SuppressWarnings("deprecation")
			Graphics2D g2d = template.createGraphics(600, 800);
	        bill.print(g2d);
	        bill.addNotify();
	        bill.validate();
	        g2d.dispose();

	        d.close ();
	    }
	    catch(Exception e)  {
	        //
	    }
	}

}
