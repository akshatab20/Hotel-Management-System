package hotel;

import java.sql.*;
public class ViewBookings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/hotel_management", "root", "akshata@7619");

	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM bookings2");

	            System.out.println("\n--- All Bookings ---");
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id") +
	                                   ", Name: " + rs.getString("guest_name") +
	                                   ", Room: " + rs.getInt("room_number") +
	                                   ", Check-in: " + rs.getDate("check_in_date") +
	                                   ", Check-out: " + rs.getDate("check_out_date"));
	            }

	            con.close();
	        } catch (Exception e) {
	            System.out.println("❌ Error: " + e.getMessage());
	        }
	}

}
