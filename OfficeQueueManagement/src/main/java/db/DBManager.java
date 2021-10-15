package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Date;
import office.Ticket;
import office.ServiceType;
public class DBManager {
	
	public Connection connection;
	
	//Nothing inside for now...
	
	public DBManager() {
        try
        {
		  this.connection = null;
		  String url = "jdbc:sqlite:se2.db";
          this.connection = DriverManager.getConnection(url);
		  System.out.println("Connection estabilished!");
		} catch (SQLException e) {
        	throw new Error("Error, connection failed.", e);
    	}
	}

	

	/*
	* The function returns the HashMap between Type of Services and its IDs.
	 * 
	 * @return HashMap <Integer, String> of all the Type of Services
	public static HashMap<Integer, String> getTypeOfServiceHashMap(){
		HashMap<Integer,String> typeofservice = new HashMap<Integer, String>()
		Statement stmt = null;
		String query = "SELECT * FROM TypeOfService";
		try{	
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				String name = rs.getString("NAME")
				int id = rs.getInt("ID");
				typeofservice.put(id,name);
			}
			return typeofservice;
		}
		catch(SQLException e){
			throw new Error("Problem on querying the database", e);
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}
	*/

	private static String getDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return formatter.format(date);
		
	}


	/** The function add to the database the last ticked processed 
	 * @return 			....
	 * */
	
	 public void addTicket(Ticket t, int counter){
		int id = t.getId();
		ServiceType st = t.getServiceType();
		String date = getDate();
		Statement stmt = null;
		String sql = "INSERT INTO Tickets VALUES(?,?,?,?)";
		try{	
			PreparedStatement prepState =
				this.connection.prepareStatement(sql);
			prepState.setInt(1, id);
			prepState.setInt(2, st.getId());
			prepState.setInt(3, counter);
			prepState.setString(4, date);
			int rowsAffected = prepState.executeUpdate();
		}
		catch(SQLException e){
			throw new Error("Problem on querying the database", e);
		}
	}

	 
}
