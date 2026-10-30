package aiwa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiwa.entity.Customer;
import aiwa.model.CustomerModel;

@WebServlet("/CustomerListController")
public class CustomerListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.PARAMETER

		String word = request.getParameter("keyboard");

		if (word == null) {
			word = "";
		}

		//2.MODEL

		CustomerModel cm = new CustomerModel();
		ArrayList<Customer> customers = cm.findByKeyboard(getServletContext(), word);

		//3.VIEW

		request.setAttribute("customers", customers);
		request.setAttribute("word", word);

		request.getRequestDispatcher("/customerListView.jsp")
				.forward(request, response);

	}

}
