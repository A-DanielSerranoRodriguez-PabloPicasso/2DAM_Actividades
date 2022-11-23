package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWorker {
	public static Image resizeImage(BufferedImage imagen, int width, int height) throws IOException {
		Image result = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage output = new BufferedImage(width, height, imagen.getType());
		Graphics2D g2d = output.createGraphics();
		g2d.drawImage(result, 0, 0, null);
		g2d.dispose();
		ImageIO.write(output, "jpg", new File("src/main/resources/output/amogus.jpg"));
		return output;
	}

}
