package engineeringStudents;
import java.sql.*;
import java.util.List;

public class CRUD {

	  // Method to create a new record
    public static void createRecord(List<Integer>Teacher_id, List<String>First_Name, List<String>Last_Name, List<String> Department, List<String> Subject) {
        String sql = "INSERT INTO teachers (Teacher_id, First_Name, Last_Name, Department, Subject) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = MySQLAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for(int i=0; i<Teacher_id.size(); i++) {
        	statement.setInt(1, Teacher_id.get(i));
            statement.setString(2, First_Name.get(i));
            statement.setString(3, Last_Name.get(i));
            statement.setString(4, Department.get(i));
            statement.setString(5, Subject.get(i));
            statement.addBatch();

            }
            int[] result = statement.executeBatch();
            System.out.println("Record created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to read records
    public static void readRecords() {
        String sql = "SELECT * FROM teachers";
        try (Connection connection = MySQLAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Teacher_id: " + resultSet.getInt("Teacher_id"));
                System.out.println("First_Name: " + resultSet.getString("First_Name"));
                System.out.println("Last_Name: " + resultSet.getString("Last_Name"));
                System.out.println("Department: " + resultSet.getString("Department"));
                System.out.println("Subject: " + resultSet.getString("Subject"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a record
    public static void updateRecord(int Teacher_id, String First_Name, String Last_Name, String Department, String Subject) {
        String sql = "UPDATE teachers SET First_Name = ?, Last_Name = ?, Department= ?, Subject = ? WHERE Teacher_id = ?";
        try (Connection connection = MySQLAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, First_Name);
            statement.setString(2, Last_Name);
            statement.setString(3, Department);
            statement.setString(4, Subject);
            statement.setInt(5, Teacher_id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a record
    public static void deleteRecord(int Teacher_id) {
        String sql = "DELETE FROM teachers WHERE Teacher_id = ?";
        try (Connection connection = MySQLAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Teacher_id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}	
	

