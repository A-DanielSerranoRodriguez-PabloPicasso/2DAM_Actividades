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

		if (!mensaje.isEmpty()) {
			buffer = mensaje.getBytes();
			try {
				socket = new Socket(InetAddress.getLocalHost(), PUERTO_REMOTO);
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				dos.writeUTF(mensaje);
				dos.flush();

				try {
					respuesta = dis.readUTF();
				} catch (EOFException e) {
				}

				System.out.println(respuesta);
				if (respuesta.equals("EXISTE")) {
					String[] partes = mensaje.split("/");
					String nombre = partes[partes.length - 1];
					archivo = new File(DIRECTORIO_DEFECTO + "/" + nombre);
					dos = new DataOutputStream(new FileOutputStream(archivo));

					System.out.println("Importando");

					int paquetes = dis.readInt();
					for (int i = 0; i < paquetes; i++) {
						buffer = new byte[dis.readInt()];
						dis.readFully(buffer);
						dos.write(buffer);
					}

					dos.flush();

					System.out.println("Recibido");
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
