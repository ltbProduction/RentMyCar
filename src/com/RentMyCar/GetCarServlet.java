package com.RentMyCar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewcar")
public class GetCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public GetCarServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int carId = Integer.parseInt(request.getParameter("id"));
        //CarDAO dao = new CarDAO();
         
        try {
        	// get carelement with photo
            //CarElement car = dao.get(carId);
            ArrayList<CarElement> cars = DatabaseConnection.checkandreadfromDatabase();
             
            //request.setAttribute("car", car);
            request.setAttribute("cars", cars);
             
            String page = "/car_overview.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);              
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }
}
