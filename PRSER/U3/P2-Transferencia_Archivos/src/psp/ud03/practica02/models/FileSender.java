package psp.ud03.practica02.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileSender extends Thread {

	private Socket socket;

	public FileSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream dis;
		DataOutputStream dos;
		String ruta = "", respuesta;
		File archivo;
		byte[] buffer = new byte[0];

		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			try {
				ruta = dis.readUTF();
			} catch (EOFException e) {
			}
			archivo = new File(ruta);

			if (archivo.exists()) {
				List<byte[]> lista = new ArrayList<>();
				long size = Files.size(archivo.toPath());
				int maxSize = Integer.MAX_VALUE;
				dis = new DataInputStream(new FileInputStream(archivo));
				respuesta = "EXISTE";
				
				dos.writeUTF(respuesta);
				dos.flush();


				if (size > maxSize) {
					long times = (size / maxSize) + 1;
					long limit = size / times;
					while (lista.size() < times) {
						if (size % 2 != 0 && lista.size() % 2 == 0)
							buffer = new byte[1 + (int) limit];
						else
							buffer = new byte[(int) limit];
						lista.add(buffer);
					}
				} else {
					buffer = dis.readAllBytes();
					lista.add(buffer);
				}

				dos.writeInt(lista.size());

				for (int i = 0; i < lista.size(); i++) {
					dos.writeInt(lista.get(i).length);
					dos.write(lista.get(i));
				}
				
				dos.flush();
			} else {
				respuesta = "ERR";

				dos.writeUTF(respuesta);
			}

			dos.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
