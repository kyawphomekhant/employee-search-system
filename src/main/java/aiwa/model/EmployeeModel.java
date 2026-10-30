
package aiwa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import aiwa.entity.Employee;

public class EmployeeModel {

	public ArrayList<Employee> findByKeyboard(
			ServletContext context, String word) {

		ArrayList<Employee> employees = new ArrayList<Employee>();

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:"
							+ context.getRealPath("WEB-INF/sample.db"));

			String sql = "SELECT * FROM employees "
					+ "WHERE employeename LIKE ? OR email LIKE ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			if (word == null) {
				word = "";
			}

			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();

				e.setEmployeeId(rs.getInt("employeeid"));
				e.setEmployeeName(rs.getString("employeename"));
				e.setHeight(rs.getInt("height"));
				e.setEmail(rs.getString("email"));
				e.setWeight(rs.getInt("weight"));
				e.setHirefiscalyear(rs.getInt("hirefiscalyear"));
				e.setBirthday(rs.getString("birthday"));
				e.setBloodtype(rs.getString("bloodtype"));

				employees.add(e);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}
}
