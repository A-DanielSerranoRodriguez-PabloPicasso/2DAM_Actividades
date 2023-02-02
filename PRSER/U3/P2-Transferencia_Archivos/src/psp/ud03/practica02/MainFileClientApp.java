package psp.ud03.practica02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainFileClientApp {
	private static final int PUERTO_REMOTO = 4321;
	private static final String DIRECTORIO_DEFECTO = "archivo";

	public static void main(String[] args) {
		DataOutputStream dos;
		DataInputStream dis;
		Scanner sc = new Scanner(System.in);
		File archivo = new File(DIRECTORIO_DEFECTO);
		Socket socket;
		String mensaje, respuesta = "";
		byte[] buffer;

		if (!archivo.exists())
			archivo.mkdirs();

		System.out.println("Introduce la ruta absoluta de un archivo del servidor:");
		mensaje = sc.nextLine();
		mensaje += "\n\r";

		/*
		 * Si el mensaje no esta vacio, comienza el proceso.
		 * 
		 * Antes de enviar los bytes, enviamos un entero que representa su tamanyo.
		 * 
		 * Antes de recibir los bytes, obtenemos el tamanyo de la respuesta, los
		 * paquetes totales que vamos a recibir y el tamanyo del paqute a recibir.
		 */
		if (!mensaje.isEmpty()) {
			buffer = mensaje.getBytes();
			try {
				socket = new Socket(InetAddress.getLocalHost(), PUERTO_REMOTO);
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				dos.writeInt(buffer.length);
				dos.write(buffer);
				dos.flush();

				int respuestaLenght = 0, paquetes = 0, paquteSize = 0;

				try {
					respuestaLenght = dis.readInt();
					paquetes = dis.readInt();
					paquteSize = dis.readInt();
				} catch (EOFException e) {
				}

				buffer = new byte[respuestaLenght];
				for (int i = 0; i < respuestaLenght; i++) {
					buffer[i] = (byte) dis.read();
				}
				respuesta = new String(buffer);

				if (respuesta.equals("OK\n\r")) {
					String[] partes = mensaje.split("/");
					String nombre = partes[partes.length - 1];
					archivo = new File(DIRECTORIO_DEFECTO + "/" + nombre);
					dos = new DataOutputStream(new FileOutputStream(archivo));

					/*
					 * Como la respuesta es correcta, leemos los paqutes y los escribimos en el
					 * archivo correspondiente.
					 */
					for (int i = 0; i < paquetes; i++) {
						if (i == 0)
							buffer = new byte[paquteSize - respuestaLenght];
						else
							buffer = new byte[paquteSize];

						try {
							dis.readFully(buffer);
						} catch (EOFException e) {
						}

						dos.write(buffer);
						try {
							paquteSize = dis.readInt();
						} catch (EOFException e) {
						}
					}

					dos.flush();
				} else {
					System.out.println("Archivo no encontrado");
				}

				socket.close();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		sc.close();
	}
}
