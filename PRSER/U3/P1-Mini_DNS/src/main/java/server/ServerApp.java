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
import java.util.Iterator;
import java.util.Properties;

public class ServerApp {

	public static void main(String[] args) {
		Properties props = new Properties();
		String mensaje = "", respuesta = "No se ha encontrado", prop;

		try {
			byte[] buffer, dataReceived;
			DatagramPacket dgpSend;
			DatagramSocket dgs = new DatagramSocket(1234);
			dgs.connect(InetAddress.getLoopbackAddress(), 1233);

			props.load(new BufferedReader(new FileReader(new File("dns.properties"))));
			System.out.println(props.getProperty("server"));

			do {
				String localMessage="";
				int bufferSize = dgs.getReceiveBufferSize();
				buffer = new byte[bufferSize];
				dgpSend = new DatagramPacket(buffer, buffer.length);
				dgs.receive(dgpSend);
				dataReceived = dgpSend.getData();
				mensaje = new String(dataReceived, StandardCharsets.UTF_8);
				mensaje = mensaje.replaceAll("/n","");
				System.out.println(mensaje);
				for (int i = 0; i < mensaje.length(); i++) {
					System.out.println(mensaje.charAt(i));
				}
				System.out.println(props.getProperty(mensaje));
				if (!mensaje.isEmpty()) {
					props.forEach((t, u) -> System.out.println(t+": "+ u));
					System.out.println(props.getProperty(mensaje));
					if ((prop = props.getProperty(mensaje)) != null)
						respuesta = prop;

					dgs.send(new DatagramPacket(respuesta.getBytes(), respuesta.getBytes().length));
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
