package serverApp.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;

public class ServerThread extends Thread {
	private Socket socket;
	private final String RESPUESTA_OK = "OK", RESPUESTA_NOK = "KO";

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream dis;
		DataOutputStream dos;

		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			String linea = "";
			String[] partes;

			while (!socket.isClosed()) {
				linea = dis.readUTF();
				partes = linea.split(" ");

				switch (partes[0]) {

				case "quit":
					dos.writeUTF(RESPUESTA_OK);
					socket.close();
					break;

				case "ls":
					ls(dos, partes);
					break;

				default:
					dos.writeUTF(RESPUESTA_NOK);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void ls(DataOutputStream dos, String[] partes) throws IOException {
		String linea;
		File directorio;

		if (partes.length > 2)
			dos.writeUTF(RESPUESTA_NOK);
		else {
			directorio = new File(partes[1]);

			if (!directorio.exists() || !directorio.isDirectory())
				dos.writeUTF(RESPUESTA_NOK);
			else {
				dos.writeUTF(RESPUESTA_OK);
				partes = directorio.list();

				for (int i = 0, l = partes.length; i < l; i++) {
					File temp = new File(directorio.getAbsolutePath() + "/" + partes[i]);
					double size = 0;

					if (!temp.isDirectory())
						size = (double) Files.size(temp.toPath()) / 1024;

					linea = partes[i] + " " + size;
					dos.writeUTF(linea);
				}

				dos.writeUTF("\n");
			}
		}
	}

}
