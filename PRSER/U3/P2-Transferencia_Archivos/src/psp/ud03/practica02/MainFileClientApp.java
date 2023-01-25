package psp.ud03.practica02;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

import psp.ud03.practica02.utils.ArrayUtils;
import psp.ud03.practica02.utils.StringUtils;

public class MainFileClientApp {
	private static int PUERTO_LOCAL = 1234, PUERTO_REMOTO = 4321;
	private static String DIRECTORIO_DEFECTO = "archivo";

	public static void main(String[] args) {
		BufferedOutputStream bos;
		DatagramPacket dgpMensaje, dgpRespuesta;
		String mensaje, respuesta;
		byte[] buffer;
		File directorio = new File(DIRECTORIO_DEFECTO);
		Scanner sc = new Scanner(System.in);

		if (!directorio.exists())
			directorio.mkdirs();

		System.out.println("Introduce la ruta absoluta de un archivo del servidor:");
		mensaje = sc.nextLine();

		if (!mensaje.isEmpty()) {
			try (DatagramSocket dgs = new DatagramSocket(PUERTO_LOCAL)) {
				dgs.connect(InetAddress.getLocalHost(), PUERTO_REMOTO);

				buffer = mensaje.getBytes();
				dgpMensaje = new DatagramPacket(buffer, buffer.length);

				dgs.send(dgpMensaje);

				buffer = new byte[3];
				dgpRespuesta = new DatagramPacket(buffer, buffer.length);

				dgs.receive(dgpRespuesta);
				buffer = dgpRespuesta.getData();

				respuesta = StringUtils.standardUtf8(ArrayUtils.truncar(buffer));

				System.out.println(respuesta);

				if (respuesta.equals("ERR")) {
					System.out.println("Error, archivo no encontrado");
				} else {
					String separador, nombreArchivo, osName = System.getProperty("os.name");

					if (osName.matches("^Windows.+"))
						separador = "\\\\";
					else
						separador = "/";

					String[] conjunto = mensaje.split(separador);
					nombreArchivo = conjunto[conjunto.length - 1];

					bos = new BufferedOutputStream(
							new FileOutputStream(new File(DIRECTORIO_DEFECTO + separador + nombreArchivo)));

					buffer = new byte[1024];
					dgpRespuesta = new DatagramPacket(buffer, buffer.length);
					dgs.receive(dgpRespuesta);

					bos.write(ArrayUtils.truncar(buffer));

					bos.close();
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		sc.close();
	}
}
