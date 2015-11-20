package db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Kunde;
import exception.DBConnectException;

public class KundenDao {
	
	private  Connection con;
	
	public KundenDao() throws DBConnectException {
		con = DBConnect.getInstance().getConnection();
	}
	
	public  Kunde findKunde(String usr, String pwd){
		String sql = "SELECT * FROM kunde WHERE username = ? AND passwort = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			Kunde kunde = new Kunde();
			if(rs.next()) {
				kunde.setKundenNummer(rs.getInt("id"));
				kunde.setVorname(rs.getString("vorname"));
				kunde.setNachname(rs.getString("nachname"));
				kunde.setEmail(rs.getString("email"));
				kunde.setUsername(rs.getString("username"));
				kunde.setPasswort(rs.getString("passwort"));
			}
			return kunde;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return new Kunde();
	}
	
	public boolean storeNewKunde(Kunde newKunde){
		return false;
	}

	public static void main(String args []) {
		try {
			KundenDao dao = new KundenDao();
			System.out.println(dao.findKunde("max","123"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
