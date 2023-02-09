package clientApp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ExamenFicherosClienteApp {

	public static void main(String[] args) {

		try {
			int puertoRemoto = 2121;
			String comando = "", host, puerto;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Host: ");
			host = br.readLine();

			if (host.isBlank())
				host = "127.0.0.1";

			System.out.print("Puerto: ");
			puerto = br.readLine();

			if (!puerto.isBlank()) {
				boolean done = false;
				while (!puerto.matches("[0-9]*") || done) {
					System.out.print("Introduce un puerto valido: ");
					puerto = br.readLine();

					if (puerto.isBlank())
						done = true;
				}

				if (!puerto.isBlank())
					puertoRemoto = Integer.parseInt(puerto);
			}

			Socket socket = new Socket(InetAddress.getByName(host), puertoRemoto);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());

			while (!comando.equals("quit")) {
				System.out.print(host + "@" + puerto + ": ");
				comando = br.readLine();
				dos.writeUTF(comando);

				if (dis.readUTF().equals("KO")) {
					System.out.println("Error con el comando");
				} else if (!comando.equals("quit")) {
					System.out.println("OK");
					String linea = "info";

					while (!linea.isBlank()) {
						linea = dis.readUTF();
						if (!linea.isBlank())
							System.out.println(linea);
					}
					System.out.println();
				}
			}

			dos.writeUTF("quit");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
