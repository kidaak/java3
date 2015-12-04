package client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class ServiceClient {

	public static void main(String[] args) {
		WebResource ws = Client.create().resource("http://localhost:8081/rest");
		
		System.out.println(ws.path("message").
				accept(MediaType.TEXT_PLAIN).get(String.class));
		
		
		
		WebResource ws2 = Client.create().resource("http://localhost:8081/rest");
		Builder builder = ws2.path("message/user/max").
				queryParam("user", "Max").accept(MediaType.TEXT_PLAIN);
		
		
		System.out.println(builder.get(String.class));

	}

}
