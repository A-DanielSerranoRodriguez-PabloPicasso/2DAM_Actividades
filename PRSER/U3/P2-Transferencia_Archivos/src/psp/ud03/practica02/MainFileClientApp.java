package psp.ud03.practica02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainFileClientApp {
	private static final int PUERTO_REMOTO = 4321;
	private static final String DIRECTORIO_DEFECTO = "archivo";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File directorio = new File(DIRECTORIO_DEFECTO);
		Socket socket;
		BufferedReader br;
		BufferedWriter bw;
		String mensaje, respuesta;
		byte[] buffer;

		if (!directorio.exists())
			directorio.mkdirs();

		System.out.println("Introduce la ruta absoluta de un archivo del servidor:");
		mensaje = sc.nextLine();

		if (!mensaje.isEmpty()) {
			buffer = mensaje.getBytes();
			try {
				socket = new Socket(InetAddress.getLocalHost(), PUERTO_REMOTO);
				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				bw.write(mensaje);
//				bw.newLine();
//				bw.flush();
				bos.write(buffer.length);
				bos.write(buffer);
				bos.flush();

//				socket.shutdownOutput();

				respuesta = new String(bis.readAllBytes());

				System.out.println(respuesta);

//				bw.write("amongus");
//				bw.newLine();
//				bw.flush();
//				respuesta = br.readLine();

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
