package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import utils.ArrayUtils;
import utils.StringUtils;

public class ClientApp {
	private static int PUERTO_LOCAL = 3333, PUERTO_REMOTO = 2222;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramPacket dgpEnviar, dgpRecibido;
		String pregunta, respuesta;
		byte[] buffer, bPregunta;

		try (DatagramSocket dgs = new DatagramSocket(PUERTO_LOCAL)) {
			dgs.connect(InetAddress.getLoopbackAddress(), PUERTO_REMOTO);

			do {
				pregunta = br.readLine();
				bPregunta = pregunta.getBytes();
				dgpEnviar = new DatagramPacket(bPregunta, bPregunta.length);

				buffer = new byte[254];
				dgpRecibido = new DatagramPacket(buffer, buffer.length);

				if (!pregunta.isEmpty()) {
					dgs.send(dgpEnviar);
					dgs.receive(dgpRecibido);

					buffer = ArrayUtils.truncar(dgpRecibido.getData());
					respuesta = StringUtils.standardUtf8(buffer);

					System.out.println(respuesta);
				}
			} while (!pregunta.isEmpty());

			dgs.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
