/**
 * 
 */
package models;

import java.io.IOException;

/**
 * @author Daniel Serrano Rodríguez
 *
 */
public interface HacerMedia_Archivo {
	public static int hacerMedia(String file) throws IOException {
		return HM_Archivo.hacerMedia(file);
	}
}
