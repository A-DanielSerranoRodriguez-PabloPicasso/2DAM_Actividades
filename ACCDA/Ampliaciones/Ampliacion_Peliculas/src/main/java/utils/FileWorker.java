package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Designed to work with files
 * 
 * @author Daniel Serrano Rodríguez
 *
 */
public class FileWorker {
	/**
	 * Writes the content of an ArrayList<String> in a file.
	 * 
	 * @param films ArrayList<String>
	 * @throws IOException - if there is a problem related to the file
	 */
	public static void writeFilms(ArrayList<String> films) throws IOException {
		File csv = new File("src/main/resources/CSV/films.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

		// The file header is written, and then the content under it
		bw.write("titulo_pelicula_sin_extension;año;calidad;formato_mkv_o_mp4\n");
		for (String film : films) {
			bw.write(film + "\n");
		}

		bw.close();
	}
}