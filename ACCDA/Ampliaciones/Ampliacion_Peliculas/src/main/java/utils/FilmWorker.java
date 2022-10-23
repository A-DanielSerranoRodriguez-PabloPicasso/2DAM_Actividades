package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Designed to work with a root films folder and get the pertinent data
 * 
 * @author Daniel Serrano Rodríguez
 *
 */
public class FilmWorker {
	/**
	 * Obtains the path of the films in the folder, using a root folder to parse the
	 * data
	 * 
	 * @param folderPath String
	 * @param root       String
	 * @return FilmList
	 */
	public static FilmList getFilms(String folderPath, String root) {
		List<String> films = processFolders(folderPath);
		FilmList curatedFilms = new FilmList();

		for (String cosa : films) {
			curatedFilms.add(cosa, root);
		}

		return curatedFilms;
	}

	/**
	 * Generates a List<String> with the path of the films
	 * 
	 * @param folderPath String
	 * @return List<String>
	 */
	private static List<String> processFolders(String folderPath) {
		File folder = new File(folderPath);
		// Array of files inside of folder
		String[] insides = folder.list();
		List<String> list = new ArrayList<>();

		/*
		 * Goes through the array. If the file is a folder, calls back the function.
		 * Else, it's added to the list
		 */
		for (int i = 0, l = insides.length; i < l; i++) {
			String things = folderPath + "/" + insides[i];
			File thingf = new File(things);
			if (thingf.isDirectory())
				list.addAll(processFolders(things));
			else
				list.add(things);
		}
		return list;
	}
}