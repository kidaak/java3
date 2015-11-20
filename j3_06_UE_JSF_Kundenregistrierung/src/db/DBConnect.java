package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DBConnectException;



//TODO verbessern
public final class DBConnect {
	
	

	
	private static DBConnect instance = null;
	private Connection con;
	private DBConnect() throws DBConnectException{ //TODO kann man Verbessern
		try {
			
			try {
				Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(
					DBProp.get("url")+
					DBProp.get("db"),
					DBProp.get("usr"),
					DBProp.get("pwd")
			);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new DBConnectException();
		}
	}
	
	public synchronized static DBConnect getInstance() throws DBConnectException{
		if(instance==null){
			instance= new DBConnect();
		}
		
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}

}
