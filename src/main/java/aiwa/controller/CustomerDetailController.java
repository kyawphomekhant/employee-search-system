package aiwa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiwa.entity.Customer;
import aiwa.model.CustomerModel;

@WebServlet("/CustomerDetailController")
public class CustomerDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.PARAMETER
		String id = request.getParameter("customerid");

		//2.MODEL

		CustomerModel cm = new CustomerModel();
		Customer customer = cm.findById(getServletContext(), Integer.parseInt(id));

		//3.VIEW
		request.setAttribute("customer", customer);

		request.getRequestDispatcher("/customerDetailView.jsp").forward(request, response);

	}

}