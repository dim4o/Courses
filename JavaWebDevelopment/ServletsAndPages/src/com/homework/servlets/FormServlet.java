package com.homework.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _04_FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = -3038410925032167824L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		.append("<html>")
		.append("<body>")
			.append("<form>")
				.append("ID:<br>")
				.append("<input type=\"text\" name=\"ID\" placeholder=\"ID\">")
					.append("<br><br>")
				.append("Topic:<br>")
				.append("<input type=\"text\" name=\"topic\" placeholder=\"Topic\">")
					.append("<br><br>")
				.append("Date:<br>")
				.append("<input type=\"date\" name=\"date\">")
					.append("<br><br>")
				.append("<button type=\"submit\" value=\"submit\">Submit</button>")
				.append("<button type=\"cancel\" value=\"cancel\">Cancel</button>")
			.append("</form>")
		.append("</body>")
		.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
