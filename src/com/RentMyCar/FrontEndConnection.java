package com.RentMyCar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HalloServlet
 */
@WebServlet("/HalloServlet")
public class FrontEndConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontEndConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<html>");
        out.println("<head>" +"<link rel=\"icon\" type=\"image/vnd.microsoft.icon\" href=\"img\\car_logo.jpg\">\r\n" + 
        		"  <meta charset=\"utf-8\">\r\n" + 
        		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
        		"  <meta name=\"description\" content=\"\">\r\n" + 
        		"  <meta name=\"author\" content=\"\">"
        		+ "<title>RentMyCar</title>" + "  <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
        				"  <link href=\"css/the-big-picture.css\" rel=\"stylesheet\">\r\n" + 
        		        		
        		"</head>");
 
        out.println("<body>");
        out.println(" <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\r\n" + 
        		"    <div class=\"container\">\r\n" + 
        		"      <a class=\"navbar-brand\" href=\"#\">Rent My Car</a>\r\n" + 
        		"      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
        		"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
        		"      </button>\r\n" + 
        		"      <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n" + 
        		"        <ul class=\"navbar-nav ml-auto\">\r\n" + 
        		"          <li class=\"nav-item\">\r\n" + 
        		"            <a class=\"nav-link\" href=\"index.html\">Home\r\n" + 
        		"              <span class=\"sr-only\">(current)</span>\r\n" + 
        		"            </a>\r\n" + 
        		"          </li>\r\n" + 
        		"          <li class=\"nav-item active\">\r\n" + 
        		"            <a class=\"nav-link\" href=\"car_overview.html\">Unsere Autos</a>\r\n" + 
        		"          </li>\r\n" + 
        		"          <li class=\"nav-item\">\r\n" + 
        		"            <a class=\"nav-link\" href=\"contacts.html\">Stellen Sie ihr Auto online</a>\r\n" + 
        		"          </li>\r\n" + 
        		"          <li class=\"nav-item\">\r\n" + 
        		"            <a class=\"nav-link\" href=\"legal_notice.html\">Impressum</a>\r\n" + 
        		"          </li>\r\n" + 
        		"        </ul>\r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"  </nav>");
        out.println("<section>\r\n" + 
        		"    <div class=\"container\">\r\n" + 
        		"      <div class=\"row\">\r\n" + 
        		"        <div class=\"col-lg-6\">\r\n" + 
        		"          <h1 class=\"mt-5\">Autos</h1>\r\n" + 
        		"          <section>\r\n" + 
        		"            <h2>Uebersicht ueber die Autos</h2>\r\n" + 
        		"        </section>");
		ArrayList<CarElement> cars = DatabaseConnection.readfromDatabase();
        
        for (CarElement c : cars  ) {
            
            out.println("<div class=\"card\" style=\"width: 18rem;\">\r\n" + 
            		"  <img src=\"img\\1559835101_mst.jpg\" class=\"card-img-top\" alt=\"...\">\r\n" + 
            		"  <div class=\"card-body\">\r\n" + 
            		"    <h5 class=\"card-title\">"+c.getBrand()+" "+c.getType()+"</h5>\r\n" + 
            		"    <p class=\"card-text\">\r\n" + 
            		"		<strong>Name:</strong>"+c.getName() +"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>Ort:</strong>"+c.getOrt()+"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>Telefon:</strong> "+c.getPhonenumber()+"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>E-Mail:</strong> "+c.getMail()+"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>Automarke:</strong>"+c.getBrand()+"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>Autotyp:</strong> "+c.getType()+"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>Kraftstoff:</strong> "+c.getFuel()+"\r\n" + 
            		"            <br>\r\n" + 
            		"            <strong>Preis pro Stunde:</strong> "+c.getPrice()+" EUR\r\n" + 
            		"            <br>	\r\n" + 
            		"	</p>\r\n" + 
            		"    <a href=\"#\" class=\"btn btn-primary\">Mieten</a>\r\n" + 
            		"  </div>\r\n" + 
            		"</div>");
		}
        


        out.println("       </div>\r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"  </section>");
        out.println(" <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n" + 
        		"  <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n" + 
        		"\r\n" + 
        		"</body>\r\n" + 
        		"\r\n" + 
        		"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarElement car1 = new CarElement(
				request.getParameter("name"), 
				request.getParameter("city"), 
				request.getParameter("email"),
				request.getParameter("phone"), 
				request.getParameter("brand"),
				request.getParameter("type"),
				request.getParameter("fuel"),
				request.getParameter("description"),
				Double.parseDouble(request.getParameter("price")));
		
		try {
			DatabaseConnection.writeToDatabase(car1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
