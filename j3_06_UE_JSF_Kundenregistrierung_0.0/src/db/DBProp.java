package db;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class DBProp {
	
	public final static String PROPERTY_PATH = "/properties/db.properties";
	
	private static Properties props;
	
	private DBProp(){}
		
	static{//statischer "Konstruktor" (wird beim Laden der Klasse aufegrufen)
		props = new Properties();
		
		
		try {
			props.load(new BufferedInputStream  ( DBProp.class.getResourceAsStream(PROPERTY_PATH))   );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key){
		return props.getProperty(key);
	}

}
