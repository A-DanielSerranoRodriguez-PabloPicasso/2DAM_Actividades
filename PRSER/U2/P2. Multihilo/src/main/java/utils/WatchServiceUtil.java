package utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceUtil {

	public static void monitorizarCarpeta(String rutaCarpeta) {
		Path carpetaPath = Paths.get(rutaCarpeta);
		WatchService ws = null;
		WatchKey wk = null;
		Thread th = null;

		try {
			ws = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			carpetaPath.register(ws, StandardWatchEventKinds.ENTRY_CREATE);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			while ((wk = ws.take()) != null) {
				for (WatchEvent<?> event : wk.pollEvents()) {
					th = new FolderWorker(rutaCarpeta + "/" + event.context(), maxWidth, maxHeight,
							outputFolder);
					th.start();
				}
				wk.reset();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
