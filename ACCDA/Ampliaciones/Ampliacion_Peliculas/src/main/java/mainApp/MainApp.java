package mainApp;

import java.io.IOException;

import utils.FileWorker;
import utils.FilmWorker;

public class MainApp {
	public static void main(String[] args) {
		String root = "Peliculas/", filmsPath = "src/main/resources/Peliculas";
		try {
			FileWorker.writeFilms(FilmWorker.getFilms(filmsPath, root).getFilms());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}