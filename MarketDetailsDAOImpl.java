import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MarketDetailsDAOImpl implements MarketDetailsDAO {

	@Override
	public boolean save(MarketDetailsDTO dto) {
		Connection connection=null;
		PreparedStatement statement=null;
		boolean result=false;
		
		 try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken", "root", "Babylokesh@123");
			 statement=connection.prepareStatement("insert into market_details value(?,?,?,?)");
			 statement.setInt(1, dto.getId());
			 statement.setString(2, dto.getName());
			 statement.setString(3, dto.getLocation());
			 statement.setInt(4, dto.getNoOfshop());
			 
			
			 statement.execute();	
				if(result)
					return false;
				else
					return true;
			} catch( SQLException e) {
				System.err.println(e.getMessage());
			}
			finally {
				try {
					connection.close();
					statement.close();
				}
				catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return false;
		}

		@Override
		public boolean update(MarketDetailsDTO dto)  {
			boolean result=false;
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken", "root", "pratheeka@123");
				statement=connection.prepareStatement("update marketDetails set noOfShops=? where name=?");
				statement.setInt(1, dto.getNoOfshop());
				statement.setString(2,dto.getName());
				statement.execute();
				if(result)
					return false;
				else
					return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			finally {
				try {
					connection.close();
					statement.close();
				}
				catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return false;
		}

		

		@Override
		public boolean getAll(MarketDetailsDTO dto) {
			boolean result=false;
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken", "root", "pratheeka@123");
			statement=connection.prepareStatement("select * from marketDetails");
			ResultSet set=statement.executeQuery();
			
			while(set.next())
			{
				int id=set.getInt(1);
				String name=set.getString(2);
				String location=set.getString(3);
				int noOfShops=set.getInt(4);
				
				System.out.println(id+"\t"+name+"\t"+location+"\t"+noOfShops);
			}
			if(result)
				return false;
			else
				return true;
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				connection.close();
				statement.close();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
			return false;
		}

		@Override
		public boolean deleteByName(MarketDetailsDTO dto) {
			Connection connection=null;
			PreparedStatement statement=null;
			boolean result=false;
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken", "root", "pratheeka@123");
				statement=connection.prepareStatement("delete from marketDetails where name=?");
				statement.setString(1, dto.getName());
				result=statement.execute();
				
				if(result)
					return false;
				else
					return true;
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			finally {
				try {
					connection.close();
					statement.close();
				}
				catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return false;
		}

		@Override
		public boolean getByLocation(MarketDetailsDTO dto) {
			
			return false;
		}
}