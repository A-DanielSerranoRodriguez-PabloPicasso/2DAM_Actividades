package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

import utils.FolderWorker;

public class Dispatcher {

	public static void main(String[] args) {
		String defaultFolder = "input", defaultOutputFolder = "output";
		int defaultWidth = 100, defaultHeight = 100;

		Properties props = new Properties();
		try {
			props.load(new BufferedReader(new FileReader(new File("config.properties"))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String carpetaString = props.getProperty("inputFolder"), ofString = props.getProperty("outputFolder");
		if (carpetaString == null) {
			carpetaString = defaultFolder;
		}
		if (ofString == null) {
			ofString = defaultOutputFolder;
		}

		File carpeta = new File(carpetaString);
		File outputFolder = new File(ofString);
		if (!carpeta.exists()) {
			carpeta = new File(carpetaString);
			carpeta.mkdirs();
		}
		if (!outputFolder.exists()) {
			outputFolder = new File(ofString);
			outputFolder.mkdirs();
		}

		String width = props.getProperty("maxWidth"), height = props.getProperty("maxHeight");
		int maxWidth, maxHeight;
		if (width == null) {
			maxWidth = defaultWidth;
		} else {
			maxWidth = Integer.parseInt(width);
		}
		if (height == null) {
			maxHeight = defaultHeight;
		} else {
			maxHeight = Integer.parseInt(height);
		}

		Path carpetaPath = Paths.get(carpeta.getAbsolutePath());
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
					th = new FolderWorker(carpeta.getAbsolutePath() + "/" + event.context(), maxWidth, maxHeight,
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
