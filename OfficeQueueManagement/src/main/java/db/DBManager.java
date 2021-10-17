package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import office.Ticket;
import office.ServiceType;

public class DBManager {

	/**Create a connection with the database.
	 * 
	 * @return The connection
	 * @throws SQLException
	 */
    public static Connection getConnection() throws SQLException {
		Connection conn=null;
		try {
            Class.forName("org.sqlite.JDBC");
			conn= DriverManager.getConnection("jdbc:sqlite:se2.db");
			System.out.println("Connection with the db estabilished");	
        }
        catch (ClassNotFoundException e) {
			System.out.println(e);
        }
		return conn;
    }


	//Useless?

	
	/** The function returns the list of Type of Services with all its informations.
	 * @return ArrayList<ServiceType> 
	*/

	public ArrayList<ServiceType> getServiceType(){
		ArrayList<ServiceType> STList  = new ArrayList<ServiceType>();
		Statement stmt = null;
		Connection connection = null;
		String query = "SELECT * FROM servicetype";
		try{
			connection = getConnection();
		}
		catch(SQLException e){ 
			System.out.println(e);
		}
		
		try{	
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				String name = rs.getString("NAME");
				int id = rs.getInt("ID");
				double time = rs.getDouble("TIME");
				STList.add(new ServiceType(id, name, time));
			}
			return STList;
		}
		catch(SQLException e){
			throw new Error("Problem on querying the database", e);
		} finally {
			if (stmt != null) {
				try{
					stmt.close();
				}
				catch(SQLException e){
					System.out.println(e);
				} 
			}
		}
	}
	

	private static String getDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return formatter.format(date);
		
	}


	/** The function add to the database the last ticked processed 
	 * @throws SQLException
	 * @param t the new ticket
	 * @param counter the counter who processed the ticket	 
	 * **/
	
	 public void addTicket(Ticket t, int counter) throws SQLException{
		ServiceType st = t.getServiceType();
		String date = getDate();
		Connection connection = getConnection();
		PreparedStatement prepState = null;
		String sql = "INSERT INTO tickets VALUES(NULL,?,?,?)";
		try{	
			prepState =	connection.prepareStatement(sql);
			prepState.setInt(1, st.getId());
			prepState.setInt(2, counter);
			prepState.setString(3, date);
			prepState.executeUpdate();
		}
		catch(SQLException e){
			throw new Error("Problem on querying the database", e);
		}
		finally {
			if (prepState != null) {
				try{
					prepState.close();
				}
				catch(SQLException e){
					System.out.println(e);
				} 
			}
		}
	}

}
