package psp.ud03.practica02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import psp.ud03.practica02.models.FileSender;
import psp.ud03.practica02.utils.ArrayUtils;
import psp.ud03.practica02.utils.StringUtils;

public class MainFileServerApp {
	private static final int PUERTO_LOCAL = 4321;
	private static int PUERTO_REMOTO;

	public static void main(String[] args) {
		DatagramPacket dgpPeticion;
		byte[] buffer = new byte[1024];

		try (DatagramSocket dgs = new DatagramSocket(PUERTO_LOCAL)) {
			while (true) {
				dgpPeticion = new DatagramPacket(buffer, buffer.length);
				dgs.receive(dgpPeticion);
				PUERTO_REMOTO = dgpPeticion.getPort();
				String ruta = StringUtils.standardUtf8(ArrayUtils.truncar(dgpPeticion.getData()));

				FileSender fs = new FileSender(dgs, PUERTO_REMOTO, ruta);
				
				fs.start();
				
				try {
					fs.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
