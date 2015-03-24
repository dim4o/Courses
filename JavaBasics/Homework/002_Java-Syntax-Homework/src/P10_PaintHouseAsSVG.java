import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.*;
import java.util.Scanner;
import org.apache.batik.svggen.*;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.*;
import org.w3c.dom.svg.*;

public class P10_PaintHouseAsSVG {
	static float dash1[] = { 2.0f };
	static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
			BasicStroke.JOIN_MITER, 1.0f, dash1, 0.0f);
	static BasicStroke bold = new BasicStroke(3.0f);
	static BasicStroke normal = new BasicStroke(1.0f);
	private static Scanner inputInt;
	private static Scanner input;

	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException, SVGGraphics2DIOException {
		// Create an SVG document.
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		SVGDocument document = (SVGDocument) impl.createDocument(svgNS, "svg",
				null);

		// Create a converter for this document.
		SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
		Element svgRoot = document.getDocumentElement();

		int[] xCoordinates = { 125, 175, 225, 225, 200, 200, 175, 175, 125,
				125, 225 };
		int[] yCoordinates = { 85, 35, 85, 135, 135, 85, 85, 135, 135, 85, 85 };

		Shape polygon = new Polygon(setScale(xCoordinates, 4), setScale(
				yCoordinates, 4), 10);
		svgGenerator.setPaint(Color.gray);
		svgGenerator.fill(polygon);
		svgGenerator.setPaint(Color.black);
		svgGenerator.setStroke(bold);
		svgGenerator.drawPolygon((Polygon) polygon);
		svgGenerator.drawLine(125 * 4, 85 * 4, 225 * 4, 85 * 4);
		// svgGenerator.drawOval( ((20)*40),
		// (6*40), 10, 10);
		// draw coordinates axis
		svgGenerator.setStroke(dashed);
		for (int i = 0; i < 6; i++) {
			svgGenerator.drawLine((100 + i * 25) * 4, 165 * 4,
					(100 + i * 25) * 4, 20 * 4);
			svgGenerator.drawLine(94 * 4, (35 + i * 25) * 4, 235 * 4,
					(35 + i * 25) * 4);
		}
		// draw strings
		svgGenerator.setFont(new Font("Arial", Font.PLAIN, 35));
		float startX = 10f;
		float startY = 3.5f;
		for (int i = 0; i < 6; i++) {
			String textX = Float.toString(startX).replaceAll("\\.?0*$", "");
			String textY = Float.toString(startY).replaceAll("\\.?0*$", "");
			svgGenerator.drawString(textX, (95f + i * 25f) * 4, 20 * 4);
			svgGenerator.drawString(String.format("%1$" + 4 + "s", textY),
					75 * 4, (38 + i * 25f) * 4);
			startX += 2.5f;
			startY += 2.5f;
		}

		svgGenerator.setSVGCanvasSize(new Dimension(1500, 1500));

		inputInt = new Scanner(System.in);
		int count = inputInt.nextInt();
		input = new Scanner(System.in);
		svgGenerator.setStroke(normal);
		for (int i = 0; i < count; i++) {
			String row = input.nextLine();
			System.out.println();
			String[] arrCoord = row.split(" ");
			Point point = new Point(Float.parseFloat(arrCoord[0]),
					Float.parseFloat(arrCoord[1]));

			if (isInsideRoof(point)
					|| isInsideRectangle(new Point(12.5f, 13.5f), new Point(
							17.5f, 8.5f), point)
					|| isInsideRectangle(new Point(20.5f, 13.5f), new Point(
							22.5f, 8.5f), point)) {
				Shape circle = new Ellipse2D.Float(
						(Float.parseFloat(arrCoord[0]) * 40 - 5),
						(Float.parseFloat(arrCoord[1]) * 40 - 5), 10, 10);
				svgGenerator.setPaint(Color.black);
				svgGenerator.fill(circle);
			} else {
				Shape circle1 = new Ellipse2D.Float(
						(Float.parseFloat(arrCoord[0]) * 40 - 5),
						(Float.parseFloat(arrCoord[1]) * 40 - 5), 10, 10);
				
				svgGenerator.setPaint(Color.gray);
				svgGenerator.fill(circle1);
				//svgGenerator.setStroke(bold);
				svgGenerator.setPaint(Color.black);
				svgGenerator.draw(circle1);
			}
		}

		// Populate the document root with the generated SVG content.
		svgGenerator.getRoot(svgRoot);
		FileOutputStream outStream = new FileOutputStream(
				"c:/Users/Dimcho/Desktop/house.html");
		Writer out = new OutputStreamWriter(outStream, "UTF-8");
		svgGenerator.stream(svgRoot, out);
	}

	static int[] setScale(int[] coordinates, int scaleFactor) {
		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i] *= scaleFactor;
		}
		return coordinates;
	}

	public static boolean isInsideRoof(Point point) {
		int sign1 = getSign(new Point(12.5f, 8.5f), new Point(17.5f, 3.5f),
				point);
		int sign2 = getSign(new Point(17.5f, 3.5f), new Point(22.5f, 8.5f),
				point);
		int sign3 = getSign(new Point(22.5f, 8.5f), new Point(12.5f, 8.5f),
				point);
		if (sign1 == 0 || sign2 == 0 || sign3 == 0) {
			return true;
		} else if (sign1 == sign2 && sign2 == sign3) {
			return true;
		}
		return false;
	}

	//
	public static boolean isInsideRectangle(Point firstPoint,
			Point secondPoint, Point pointM) {
		if (pointM.x >= firstPoint.x && pointM.x <= secondPoint.x
				&& pointM.y <= firstPoint.y && pointM.y >= secondPoint.y) {
			return true;
		}
		return false;
	}

	// determines the sign of determinant
	public static int getSign(Point pointA, Point pointB, Point pointM) {
		float expression = (pointB.x - pointA.x) * (pointM.y - pointA.y)
				- (pointB.y - pointA.y) * (pointM.x - pointA.x);
		if (expression > 0) {
			return 1;
		} else if (expression < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}

// defines point object
class Point {
	float x;
	float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
}