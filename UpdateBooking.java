package hotel;

import java.sql.*;
import java.util.*;
public class UpdateBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter booking ID to update: ");
	        int id = sc.nextInt();

	        System.out.print("Enter new room number: ");
	        int newRoom = sc.nextInt();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/hotel_management", "root", "your_password");

	            String sql = "UPDATE bookings2 SET room_number = ? WHERE id = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, newRoom);
	            ps.setInt(2, id);

	            int rows = ps.executeUpdate();
	            if (rows > 0) {
	                System.out.println("✅ Booking updated successfully!");
	            } else {
	                System.out.println("❌ No booking found with this ID.");
	            }

	            con.close();
	        } catch (Exception e) {
	            System.out.println("❌ Error: " + e.getMessage());
	        }
	  
	}

}
