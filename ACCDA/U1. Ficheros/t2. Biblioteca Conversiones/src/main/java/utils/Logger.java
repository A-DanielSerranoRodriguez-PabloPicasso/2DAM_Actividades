package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
	public static void Log(String metodo, String fEntrada, String fSalida, boolean exito) {
		LocalDateTime ldt = LocalDateTime.now();
		String logPath = "src/main/resources/log_csv.txt";
		File logFile = new File(logPath);
		BufferedWriter bw = null;
		try {
			if (!logFile.exists())
				logFile.createNewFile();
			bw = new BufferedWriter(new FileWriter(logFile, true));

			bw.write("Fecha y hora: " + ldt.toString() + ", Metodo: " + metodo + ", Entrada: " + fEntrada + ", Salida: "
					+ fSalida + ", Exito: " + exito + "\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
