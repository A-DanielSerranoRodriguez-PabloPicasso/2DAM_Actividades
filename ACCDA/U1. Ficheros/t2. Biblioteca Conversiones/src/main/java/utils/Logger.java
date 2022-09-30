package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
	/**
	 * Logs the operations to a TXT
	 * 
	 * @param metodo   Method used
	 * @param fEntrada Path of the file used
	 * @param fSalida  Path of the file generated
	 * @param exito    Boolean to show if it succeeded or not
	 */
	public static void Log(String metodo, String fEntrada, String fSalida, boolean exito) {
		// LocalDateTime takes the date and time: YYYY-MM-DDThh-mm-ss
		LocalDateTime ldt = LocalDateTime.now();
		// Path to the log file
		String logPath = "src/main/resources/log_csv.txt";
		File logFile = new File(logPath);
		BufferedWriter bw = null;
		try {
			// If log file doesn't exists, it's created
			if (!logFile.exists())
				logFile.createNewFile();
			// We create a writer for the log file, enabling the appending capability, and
			// write to it
			bw = new BufferedWriter(new FileWriter(logFile, true));
			bw.write("Fecha y hora: " + ldt.toString() + ", Metodo: " + metodo + ", Entrada: " + fEntrada + ", Salida: "
					+ fSalida + ", Exito: " + exito + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
