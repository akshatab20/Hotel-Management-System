package hotel;

import java.sql.*;
import java.util.Scanner;
public class DeleteBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter booking ID to delete: ");
	        int id = sc.nextInt();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/hotel_management", "root", "your_password");

	            String sql = "DELETE FROM bookings2 WHERE id = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);

	            int rows = ps.executeUpdate();
	            if (rows > 0) {
	                System.out.println("✅ Booking deleted successfully!");
	            } else {
	                System.out.println("❌ No booking found with this ID.");
	            }

	            con.close();
	        } catch (Exception e) {
	            System.out.println("❌ Error: " + e.getMessage());
	        }
	}

}
