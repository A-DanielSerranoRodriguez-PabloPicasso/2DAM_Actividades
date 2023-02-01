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

			List<byte[]> lista = new ArrayList<>();
			if (archivo.exists()) {
				long size = Files.size(archivo.toPath());
				int maxSize = Integer.MAX_VALUE;
				long times = (size / maxSize) + 1;
				long limit = size / times;
				dis = new DataInputStream(new FileInputStream(archivo));
				respuesta = "OK\n\r";
				byte[] bRespuesta = respuesta.getBytes();
				int respuestaLenght = bRespuesta.length;

//				dos.writeUTF(respuesta);
//				dos.flush();

				if (size > maxSize) {
					while (lista.size() < times) {
						if (lista.size() == 0) {
							limit += respuestaLenght;

							if (size % 2 != 0 && lista.size() % 2 == 0)
								buffer = new byte[1 + (int) limit];
							else
								buffer = new byte[(int) limit];

							for (int i = 0; i < respuesta.length(); i++)
								buffer[i] = bRespuesta[i];

							for (int i = respuestaLenght; i < buffer.length; i++)
								buffer[i] = (byte) dis.read();

							limit -= respuestaLenght;
						} else {
							if (size % 2 != 0 && lista.size() % 2 == 0)
								buffer = new byte[1 + (int) limit];
							else
								buffer = new byte[(int) limit];

							for (int i = 0; i < buffer.length; i++)
								buffer[i] = (byte) dis.read();
						}

						lista.add(buffer);
					}
				} else {
					buffer = new byte[(int) (size) + respuestaLenght];
					for (int i = 0; i < respuestaLenght; i++)
						buffer[i] = bRespuesta[i];

					for (int i = respuestaLenght; i < buffer.length; i++)
						buffer[i] = (byte) dis.read();

					lista.add(buffer);
				}

				dos.writeInt(respuestaLenght);
				dos.writeInt(lista.size());

				for (int i = 0; i < lista.size(); i++) {
					dos.writeInt(lista.get(i).length);
					dos.write(lista.get(i));
				}

				dos.flush();
			} else {
				respuesta = "ERR\n\r";
				buffer = respuesta.getBytes();
				lista.add(buffer);
				dos.writeInt(buffer.length);
				dos.writeInt(lista.size());
				dos.writeInt(buffer.length);
				dos.write(buffer);
//				dos.writeUTF(respuesta);
			}

			dos.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
