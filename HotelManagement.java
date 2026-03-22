package hotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class HotelManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter guest name: ");
        String guestName = sc.nextLine();

        System.out.print("Enter room number: ");
        int roomNumber = sc.nextInt();
        sc.nextLine(); // consume leftover new line

        System.out.print("Enter check-in date (yyyy-mm-dd): ");
        String checkIn = sc.nextLine();

        System.out.print("Enter check-out date (yyyy-mm-dd): ");
        String checkOut = sc.nextLine();

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel_management", "root", "akshata@7619");

            // 3. Prepare SQL
            String sql = "INSERT INTO bookings2 (guest_name, room_number, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            // 4. Set Values
            ps.setString(1, guestName);
            ps.setInt(2, roomNumber);
            ps.setDate(3, Date.valueOf(checkIn));
            ps.setDate(4, Date.valueOf(checkOut));

            // 5. Execute
            ps.executeUpdate();

            System.out.println("✅ Booking Successful!");

            con.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

		

	}

}
