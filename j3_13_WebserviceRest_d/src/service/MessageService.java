package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("message")
public class MessageService {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String message(){
		return "Hallo Restservice";
	}
	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("user/{user}")
	public String message(String user){
		return user.toLowerCase();
	}

}
