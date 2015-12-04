package service;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import json.GenresSerializer;
import model.Artists;
import model.Genres;

public final class JSONServiceHandler {
	public static final String API_KEY = "GJXTDB6QSTDCUQ6U3";
	private static JSONServiceHandler instance = null;

	private JSONServiceHandler() {
		System.setProperty("java.net.useSystemProxies", "true");
	}

	public synchronized static JSONServiceHandler getInstance() {

		if (instance == null) {
			instance = new JSONServiceHandler();
		}

		return instance;
	}

	/**
	 * Rest Client
	 * @return
	 */
	private String getGenresJSON() {
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/list_genres");
		
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				accept(MediaType.APPLICATION_JSON);
		
		return b.get(String.class);		
	}

	/*
	 * json -> Object (gson.jar)
	 */
	public Genres createGengres() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Genres.class, new GenresSerializer());
		Gson gson = gsonBuilder.create();
		Genres genres = gson.fromJson(getGenresJSON(), Genres.class);
		return genres;
	}

	private String getArtistsJSON(String genre, String results) {
		return null;
	}

	
	public Artists createArtists(String genre, int maxresults) {
		return null;
	}
	
	public static void main(String[] args) {
		JSONServiceHandler service = new JSONServiceHandler();
		System.out.println("-->"+service.createGengres());
	}

}
