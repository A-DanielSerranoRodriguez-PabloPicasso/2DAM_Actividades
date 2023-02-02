package psp.ud03.practica02.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
		List<byte[]> lista = new ArrayList<>();

		/*
		 * El proceso comienza una vez que el servidor recibe un mensaje.
		 * 
		 * Primero recibimos un entero que representa el tamanyo del mensaje, y luego el
		 * mensaje como tal.
		 * 
		 * Tenemos una lista en la que introduciremos los datos a enviar.
		 * 
		 * Si el archivo existe, averiguamos su tamanyo y enviamos el tamanyo del
		 * mensaje, con el tamanyo de la lista y el tamanyo de cada paquete.
		 */
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			buffer = new byte[dis.readInt()];
			for (int i = 0; i < buffer.length; i++)
				buffer[i] = (byte) dis.read();

			ruta = new String(buffer);
			ruta = ruta.trim();
			archivo = new File(ruta);

			if (archivo.exists()) {
				long size = Files.size(archivo.toPath());
				int maxSize = Integer.MAX_VALUE;
				dis = new DataInputStream(new FileInputStream(archivo));
				respuesta = "OK\n\r";
				byte[] bRespuesta = respuesta.getBytes();
				int respuestaLenght = bRespuesta.length;

				/*
				 * Si el tamanyo del archivo es superior al de un array, averiguamos en cuantos
				 * paquetes tenemos que divir el archivo (+1 si la division entre estos no da
				 * resto 0) y el tamanyo de cada paquete.
				 */
				if (size > maxSize) {
					long times = (size / maxSize);
					if (size % maxSize != 0)
						times++;
					long limit = size / times;

					while (lista.size() < times) {
						/*
						 * En la primera iteracion, anyadimos el mensaje.
						 */
						if (lista.size() == 0) {
							limit += respuestaLenght;

							/*
							 * Comprobamos si el tamanyo es par o impar. Si es impar, hay que anyadir 1 al
							 * tamanyo cada 2 rotaciones (1 si, 1 no).
							 */
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
							/*
							 * Comprobacion par/impar
							 */
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
					/*
					 * Si el tamanyo del archivo es menor, lo ponemos todo en un unico paquete.
					 */
					buffer = new byte[(int) (size) + respuestaLenght];
					for (int i = 0; i < respuestaLenght; i++)
						buffer[i] = bRespuesta[i];

					for (int i = respuestaLenght; i < buffer.length; i++) {
						buffer[i] = (byte) dis.read();
					}

					lista.add(buffer);
				}

				/*
				 * Escribimos los tamanyos y los paqutes.
				 */
				dos.writeInt(respuestaLenght);
				dos.writeInt(lista.size());

				for (int i = 0; i < lista.size(); i++) {
					dos.writeInt(lista.get(i).length);
					dos.write(lista.get(i));
				}

			} else {
				/*
				 * Si no existe, escribimos el error y lo enviamos, especificando el tamanyo del
				 * mensaje, el tamanyo de la lista y el tamanyo del paquete total (que en este
				 * caso, es el mismo que el del mensaje).
				 */
				respuesta = "ERR\n\r";
				buffer = respuesta.getBytes();
				lista.add(buffer);
				dos.writeInt(buffer.length);
				dos.writeInt(lista.size());
				dos.writeInt(buffer.length);
				dos.write(buffer);
			}

			dos.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
