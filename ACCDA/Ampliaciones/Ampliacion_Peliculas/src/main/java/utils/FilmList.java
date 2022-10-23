package utils;

import java.util.ArrayList;

/**
 * Storage for films with a predefine format
 * 
 * @author Daniel Serrano Rodríguez
 *
 */
public class FilmList {
	/**
	 * ArrayList<String> of the films with the correct format
	 */
	private ArrayList<String> films;

	/**
	 * Creates an empty ArrayList<String>
	 */
	public FilmList() {
		films = new ArrayList<>();
	}

	/**
	 * Obtains the ArrayList<String>
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getFilms() {
		return films;
	}

	/**
	 * Adds a film, using a root folder for parsing.
	 * 
	 * @param path String
	 * @param root String
	 */
	public void add(String path, String root) {
		// Removes the extra path behind the root folder, including it.
		String film = path.substring(path.lastIndexOf(root) + root.length());

		films.add(format(film));
	}

	/**
	 * Formats the text to save it in CSV style. Format is:
	 * titulo_pelicula_sin_extension;año;calidad;formato_mkv_o_mp4
	 * 
	 * @param film String
	 * @return String
	 */
	private String format(String film) {
		/*
		 * Necessary parts for the format. quality_film splits the film string, which
		 * starts from the designated root folder (not included).
		 */
		String name, extension, quality = "", year = film.substring(film.lastIndexOf("(") + 1, film.lastIndexOf(")"));
		String[] quality_film = film.split("/"), film_extension;

		/*
		 * If quality_film is 1, the film is in the root folder, so it doesn't have a
		 * quality.
		 * 
		 * Else, the quality of the film is in the first part of the array and the film
		 * itself is in the last.
		 */
		if (quality_film.length == 1) {
			film_extension = quality_film[0].split("\\.");
		} else {
			quality = quality_film[0];
			/*
			 * Name and file extension are separated
			 */
			film_extension = quality_film[quality_film.length - 1].split("\\.");
		}

		/*
		 * The name is obtained, and the year is removed from it
		 */
		name = film_extension[0];
		name = name.replaceAll("\\(" + year + "\\)", "");

		// The file extension is obtained
		extension = film_extension[1];

		return name + ";" + year + ";" + quality + ";" + extension;
	}
}
