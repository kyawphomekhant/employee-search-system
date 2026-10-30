
package aiwa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiwa.entity.Employee;
import aiwa.model.EmployeeModel;

@WebServlet("/EmployeeListController")
public class EmployeeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String word = request.getParameter("keyboard");

		EmployeeModel em = new EmployeeModel();

		ArrayList<Employee> employees = em.findByKeyboard(getServletContext(), word);

		request.setAttribute("employees", employees);

		request.getRequestDispatcher("/employeeListView.jsp")
				.forward(request, response);
	}
}
