package aiwa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import aiwa.entity.Customer;

public class CustomerModel {

	public Customer findById(ServletContext context, int id) {

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:" + context.getRealPath("WEB-INF/sample.db"));

			String sql = "SELECT * FROM customers WHERE customerid = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Customer c = new Customer();

				c.setCustomerId(rs.getInt("customerid"));
				c.setCustomerName(rs.getString("customername"));
				c.setAddress(rs.getString("address"));

				rs.close();
				stmt.close();
				conn.close();

				return c;
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Customer> findByKeyboard(ServletContext context, String word) {

		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {

			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + context.getRealPath("WEB-INF/sample.db"));

			String sql = "SELECT * FROM customers WHERE customername like ? or address like? ";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Customer c = new Customer();
				c.setCustomerId(rs.getInt("customerid"));
				c.setCustomerName(rs.getString("customername"));
				c.setAddress(rs.getString("address"));
				customers.add(c);

			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customers;

	}

}
