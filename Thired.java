import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Thired {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/firstdatabase";
		String user = "root";
		String password = "type Password";
		String CreateTable = "Create Table person1(" + 
		                       "id Int Primary Key ," +
				                "name Varchar(50), " + 
		                        "city Varchar(50)" + 
				                ")";
		String insertQuery = "INSERT INTO person1 (id, name, city) VALUES(1, 'jone', 'Rajahmundry')";
		String readQuery = "SELECT * FROM person1";
		String updateQuery = "UPDATE person1 SET city = 'Chemudulanka' WHERE id = 1";
		String delectQuery = "DELECT FROM person1 WHERE id =1";
		try(Connection con = DriverManager.getConnection(url,user,password);
				Statement smt = con.createStatement()){
			smt.executeUpdate(CreateTable);
			System.out.println("Table 'person1' created successfully");
			smt.executeUpdate(insertQuery);
			System.out.println("Data inserted successfully");
			ResultSet rs = smt.executeQuery(readQuery);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("City: " + rs.getString("City"));
			}
			smt.executeUpdate(updateQuery);
			System.out.println("Data updated successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}


}
	}
