package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ClientApp {

	public static void main(String[] args) {
		String mensaje;
		try {
			DatagramSocket dgs = new DatagramSocket(1233);
			dgs.connect(InetAddress.getLoopbackAddress(), 1234);

			do {
				byte[] bytes = new byte[1024];
				DatagramPacket dgpRecibido = new DatagramPacket(bytes, bytes.length);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				mensaje = br.readLine();
				DatagramPacket dgp = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length);
				dgs.setSendBufferSize(0);
				dgs.send(dgp);
				if (!mensaje.isEmpty()) {
					dgs.receive(dgpRecibido);
					System.out.println(new String(dgpRecibido.getData(), StandardCharsets.UTF_8));
				}
			} while (!mensaje.isEmpty());

			dgs.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
