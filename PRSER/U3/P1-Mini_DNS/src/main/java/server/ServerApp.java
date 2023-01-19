package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import utils.ArrayUtils;

public class ServerApp {
	private static int PUERTO_LOCAL = 2222, PUERTO_REMOTO = 3333;

	public static void main(String[] args) {
		Properties props = new Properties();
		DatagramPacket dgpRecibido;
		String mensaje, respuesta = "El nombre no se encuentra", prop;
		byte[] buffer, bRespuesta;

		try (DatagramSocket dgs = new DatagramSocket(PUERTO_LOCAL)) {
			dgs.connect(InetAddress.getLoopbackAddress(), PUERTO_REMOTO);
			props.load(new BufferedReader(new FileReader(new File("dns.properties"))));

			do {
				buffer = new byte[254];
				dgpRecibido = new DatagramPacket(buffer, buffer.length);

				dgs.receive(dgpRecibido);
				buffer = dgpRecibido.getData();
				buffer = ArrayUtils.truncar(buffer);

				mensaje = new String(buffer, StandardCharsets.UTF_8);
				if ((prop = props.getProperty(mensaje)) != null)
					respuesta = prop;

				bRespuesta = respuesta.getBytes();
				dgs.send(new DatagramPacket(bRespuesta, bRespuesta.length));
			} while (true);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
