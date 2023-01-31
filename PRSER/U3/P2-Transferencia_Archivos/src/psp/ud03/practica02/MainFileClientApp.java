package psp.ud03.practica02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import psp.ud03.practica02.utils.StringUtils;

public class MainFileClientApp {
	private static final int PUERTO_REMOTO = 4321;
	private static final String DIRECTORIO_DEFECTO = "archivo";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File archivo = new File(DIRECTORIO_DEFECTO);
		Socket socket;
		String mensaje, respuesta;
		byte[] buffer;

		if (!archivo.exists())
			archivo.mkdirs();

		System.out.println("Introduce la ruta absoluta de un archivo del servidor:");
		mensaje = sc.nextLine();

		if (!mensaje.isEmpty()) {
			buffer = mensaje.getBytes();
			try {
				socket = new Socket(InetAddress.getLocalHost(), PUERTO_REMOTO);
				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
				bos.write(buffer.length);
				System.out.println(buffer.length);
				bos.write(buffer);
				bos.flush();

				int i = 0, size = bis.read();
				buffer = new byte[size];
				while (i < size) {
					buffer[i] = (byte) bis.read();
					i++;
				}

				respuesta = StringUtils.standardUtf8(buffer);

				System.out.println(respuesta);
				if (respuesta.equals("EXISTE")) {
					System.out.println("Importando");
					String[] partes = mensaje.split("/");
					String nombre = partes[partes.length - 1];
					archivo = new File(DIRECTORIO_DEFECTO + "/" + nombre);
					i = 0;
					size = bis.read();
					System.out.println(size);
					System.out.println();
					buffer = new byte[size];
					while (i < size) {
						buffer[i] = (byte) bis.read();
						System.out.println(buffer[i]);
						i++;
					}
					bos = new BufferedOutputStream(new FileOutputStream(archivo));
					bos.write(buffer);
					bos.flush();
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
