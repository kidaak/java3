package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import service.JSONServiceHandler;


@ManagedBean
@SessionScoped
public class MusicServiceBean {
	private JSONServiceHandler sh;
	private String currentGenre;
	private List<String> genreList;
	
	// Stelle zum initialisieren
	@PostConstruct
	public void init(){
		sh = JSONServiceHandler.getInstance();
		genreList = sh.createGengres().getGenreList();
	}


	public String getCurrentGenre() {
		return currentGenre;
	}


	public void setCurrentGenre(String currentGenre) {
		this.currentGenre = currentGenre;
	}
	
	public List<String> loadGenresList(String query){
		List<String> completeList = new ArrayList<>();
		for (String genre :genreList) {
			if(genre.toLowerCase().startsWith(query.toLowerCase())){
				completeList.add(genre);
			}
		}
		return completeList;
	}

}
