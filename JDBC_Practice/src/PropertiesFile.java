import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesFile {
    public static void main(String[] args) {
        // Load properties from the DB.properties file
        Properties dbProperties = new Properties();
        
        try {
            // Method 1: Load from classpath (recommended)
            // This works when DB.properties is in src/ folder
            InputStream inputStream = PropertiesFile.class.getClassLoader()
                    .getResourceAsStream("DB.properties");
            
            if (inputStream != null) {
                dbProperties.load(inputStream);
                System.out.println("Properties loaded from classpath");
            } else {
                // Method 2: Try loading from current directory
                System.out.println("Properties file not found in classpath, trying current directory...");
                dbProperties.load(new FileInputStream("DB.properties"));
                System.out.println("Properties loaded from current directory");
            }
            
            // Get database connection properties
            String dbURL = dbProperties.getProperty("connection.url");
            String dbUser = dbProperties.getProperty("connection.username");
            String dbPassword = dbProperties.getProperty("connection.password");
            
            // Validate properties
            if (dbURL == null || dbUser == null || dbPassword == null) {
                System.err.println("Error: Missing required database properties!");
                System.err.println("Required properties: connection.url, connection.username, connection.password");
                return;
            }
            
            System.out.println("Connecting to database: " + dbURL);
            
            // Establish database connection
            try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                
                System.out.println("Database connection successful!");
                
                // Get database metadata
                DatabaseMetaData dmd = connection.getMetaData();
                
                // Display table information
                System.out.println("\n=== Database Tables ===");
                try (ResultSet resultTable = dmd.getTables(null, "mydb", null, new String[] { "TABLE" })) {
                    while (resultTable.next()) {
                        System.out.println("Catalog: " + resultTable.getString(1));
                        System.out.println("Schema: " + resultTable.getString(2));
                        System.out.println("Table Name: " + resultTable.getString(3));
                        System.out.println("Table Type: " + resultTable.getString(4));
                        System.out.println("---");
                    }
                }
                
                // Display column information for students table
                System.out.println("\n=== Students Table Columns ===");
                try (ResultSet resultColumn = dmd.getColumns(null, "mydb", "students", null)) {
                    while (resultColumn.next()) {
                        System.out.println("Catalog: " + resultColumn.getString(1));
                        System.out.println("Schema: " + resultColumn.getString(2));
                        System.out.println("Table: " + resultColumn.getString(3));
                        System.out.println("Column: " + resultColumn.getString(4));
                        System.out.println("---");
                    }
                }
                
                // Execute the original query
                System.out.println("\n=== Students Data ===");
                try (PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM students");
                     ResultSet result = psSelect.executeQuery()) {
                    
                    // Get column count for dynamic display
                    int columnCount = result.getMetaData().getColumnCount();
                    
                    while (result.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(result.getMetaData().getColumnName(i) + ": " + 
                                           result.getString(i) + " | ");
                        }
                        System.out.println();
                    }
                }
                
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Properties file 'DB.properties' not found!");
            System.err.println("Make sure the file exists in:");
            System.err.println("1. src/ folder (will be copied to classpath)");
            System.err.println("2. Project root directory");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}