package be.pxl.paj.servlets;

import be.pxl.paj.servlets.service.BeerExpert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/SelectBeer.do")
public class SelectBeerServlet extends HttpServlet {

	private final BeerExpert beerExpert;

	public SelectBeerServlet(BeerExpert beerExpert) {
		this.beerExpert = beerExpert;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String color = req.getParameter("color");

		List<String> result = beerExpert.getBrands(color);
		PrintWriter writer = resp.getWriter();
		int activeSessions = BeerSessionCounter.getActiveSessions();

		writer.println("<html>" +
				"<body>" +
				"<h1 style=\"text-align:center\">Try these beers:</h1><p>" +
				String.join(", ", result) +
				"</p></body>" +
				"</html>");
	}
}
