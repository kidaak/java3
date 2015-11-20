package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnect;
import exception.DBConnectException;
import model.Kunde;

public class KundeDAO {

	private Connection con;

	
	public KundeDAO() throws DBConnectException {
		con = DBConnect.getInstance().getConnection();
	}

	public Kunde findKunde(String usr, String pwd) {
		String sql = "SELECT * FROM kunde WHERE username =? AND passwort =?";
		try (PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, usr);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Kunde kunde = new Kunde();
				kunde.setKundenNummer(rs.getInt("id"));
				kunde.setVorname(rs.getString("vorname"));
				kunde.setNachname(rs.getString("nachname"));
				kunde.setEmail(rs.getString("email"));
				kunde.setUsername(rs.getString("username"));
				kunde.setPasswort(rs.getString("passwort"));
				return kunde;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Kunde();
	}

	public boolean storeNewKunde(Kunde newKunde) {
		String sql = "INSERT INTO kunde "
				+ "(vorname, nachname,username,passwort,email) "
				+ "values (?,?,?,?,?)";
		try (PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, newKunde.getVorname());
			ps.setString(2, newKunde.getNachname());
			ps.setString(3, newKunde.getUsername());
			ps.setString(4, newKunde.getPasswort());
			ps.setString(5, newKunde.getEmail());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			KundeDAO dao = new KundeDAO();
			System.out.println(dao.findKunde("max", "123"));
		} catch (DBConnectException e) {
			e.printStackTrace();
		}

	}

}
