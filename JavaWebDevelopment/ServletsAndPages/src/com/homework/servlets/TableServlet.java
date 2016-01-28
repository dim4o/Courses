package com.homework.servlets;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _03_TableServlet
 */
@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = -7789331121242820890L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public TableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, java.util.Date> map = new LinkedHashMap <String, java.util.Date>();
		map.put("Web Development Basics", new GregorianCalendar(2016, Calendar.JANUARY, 14, 18, 0, 0).getTime());
		map.put("Servlets and Pages", new GregorianCalendar(2016, Calendar.JANUARY, 21, 18, 0, 0).getTime());
		map.put("Containers, Filters and Sessions", new GregorianCalendar(2016, Calendar.JANUARY, 28, 18, 0, 0).getTime());
		map.put("Java Beans", new GregorianCalendar(2016, Calendar.FEBRUARY, 4, 18, 0, 0).getTime());
		map.put("Spring Core", new GregorianCalendar(2016, Calendar.FEBRUARY, 11, 18, 0, 0).getTime());
		map.put("Spring MVC", new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 18, 0, 0).getTime());
		map.put("Spring Security", new GregorianCalendar(2016, Calendar.FEBRUARY, 25, 18, 0, 0).getTime());
		map.put("Oracle Database", new GregorianCalendar(2016, Calendar.MARCH, 10, 18, 0, 0).getTime());
		map.put("Java Persistence", new GregorianCalendar(2016, Calendar.MARCH, 17, 18, 0, 0).getTime());
		map.put("Final Test", new GregorianCalendar(2016, Calendar.MARCH, 24).getTime());
		map.put("Workshop - Building Web Application from Scratch", new GregorianCalendar(2016, Calendar.MARCH, 31, 18, 0, 0).getTime());
		map.put("Project Presentations", new GregorianCalendar(2016, Calendar.APRIL, 10, 10, 0, 0).getTime());
		
		response.getWriter().append("<table border=\"1\">");
		for (Map.Entry<String, Date> entry : map.entrySet()) {
			response.getWriter()
			.append("<tr>")
				.append("<td>")
					.append(entry.getKey())
				.append("</td>")
				.append("<td>")
					.append(entry.getValue().toString())
				.append("</td>")
			.append("</tr>");
		}
		response.getWriter().append("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
