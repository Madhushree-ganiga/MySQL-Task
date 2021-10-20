import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MarketTester {
public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/air","root","Babylokesh@123");
		statement=connection.createStatement();
		ResultSet set=statement.executeQuery("select * from airport_details");
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String location=set.getString(3);
			int noOfAirlines=set.getInt(4);
			
			System.out.println(id + "\t" +  name  +  "\t"  +  location  +  "\t"  +  noOfAirlines);
			
		}
	}
	catch(ClassNotFoundException | SQLException e)
	{
		System.err.println(e.getMessage());
	}
	finally {
		try {
			statement.close();
			connection.close();
			
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
}
