package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWorker {
	public static Image resizeImage(String fileName, BufferedImage imagen, int width, int height, File outputFolder)
			throws IOException {
		if (imagen.getWidth() <= width && imagen.getHeight() <= height) {
			width = imagen.getWidth();
			height = imagen.getHeight();
		} else {
			if (imagen.getWidth() > imagen.getHeight()) {
				height = (int) (imagen.getHeight() / ((double) imagen.getWidth() / width));
			} else if (imagen.getHeight() > imagen.getWidth()) {
				width = (int) (imagen.getWidth() / ((double) imagen.getHeight() / height));
			}
		}

		BufferedImage output = new BufferedImage(width, height, imagen.getType());
		Image result = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		Graphics2D g2d = output.createGraphics();
		g2d.drawImage(result, 0, 0, null);
		g2d.dispose();
		ImageIO.write(output, "jpg", new File(outputFolder.getAbsolutePath() + "/" + fileName));
		
		return output;
	}

}
