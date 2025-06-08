import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class practice {
	// we don't want any one to access this properties so we made this private and
	// no obj creation because of static
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";

	private static final String username = "root";

	private static final String password = "12345";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection dbconnection = DriverManager.getConnection(URL, username, password);
//			Statement statement = dbconnection.createStatement();
			// Select query :
//			String query = "select * from students";
			// Resultset is only used while retrieving data
//			ResultSet result = statement.executeQuery(query);
//			// it points on row, and returns boolean value
//			while(result.next()) {
//				int id = result.getInt("id");
//				String name = result.getString("name");
//				int age = result.getInt("age");
//				double marks = result.getDouble("marks");
//				System.out.println("ID : "+ id);
//				System.out.println("Name : "+name );
//				System.out.println("Age : "+ age);
//				System.out.println("Marks : "+ marks);
//			}

			// Insert Query:
//			String query = String.format("Insert into students(name,age,marks) VALUES('%s',%o,%d)","Rahul",23,78);
			// Update Query:
//			String query = String.format("Update students set marks = %d where id = %o",92,2);
			// delete query:
//			String query = String.format("Delete from students where id = %o",2);

			// prepared statements: they need query as argument and ? below is a placeholder
			// Insert with prepared:
//			String query = "INSERT into students(name,age,marks) VALUES(?,?,?)";
			// Select with prepared:
//			String query = "SELECT marks from students where id = ?";
			// Update with prepared:
			String query = "Update students set marks = ? where id = ?";
			PreparedStatement psstat = dbconnection.prepareStatement(query);
			// for select:
			psstat.setDouble(1, 87.44);
			psstat.setInt(2, 1);
			// for insert:
//			psstat.setString(1, "Pratik");
//			psstat.setInt(2,24);
//			psstat.setDouble(3, 91);
			// when we wany to insert,update and delete we use executeUpdate and we get
			// result as how many rows affected which is integer
			int rowsAffected = psstat.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Data inserted successfully");
			}else {
				System.out.println("Data not Inserted");
			}

			// we'll be using Resultset for retriveing data with preparedstatement
//			ResultSet result = psstat.executeQuery();
//			if (result.next()) {
//				double marks = result.getDouble("marks");
//				System.out.println("Marks :" + marks);
//			} else {
//				System.out.println("Marks not found");
//			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
