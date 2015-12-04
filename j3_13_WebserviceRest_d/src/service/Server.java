package service;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class Server {
	
	public static void main(String[] args) {
		try {
			  HttpServer server = HttpServerFactory.create("http://localhost:8081/rest");
			  server.start();
			  JOptionPane.showMessageDialog(null, "Ende...");
			  server.stop(0);
			
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
