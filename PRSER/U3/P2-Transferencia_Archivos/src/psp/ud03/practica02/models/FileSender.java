package psp.ud03.practica02.models;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import psp.ud03.practica02.utils.StringUtils;

public class FileSender extends Thread {

	private Socket socket;

	public FileSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedInputStream bis;
		BufferedOutputStream bos;
		String ruta, respuesta;
		File archivo;
		byte[] buffer;
		int size;

		try {
			bis = new BufferedInputStream(socket.getInputStream());
			bos = new BufferedOutputStream(socket.getOutputStream());
			size = bis.read();
			System.out.println(size);
			buffer = new byte[size];
			int i = 0;

			while (i < size) {
				buffer[i] = (byte) bis.read();
				i++;
			}

			ruta = StringUtils.standardUtf8(buffer);
			archivo = new File(ruta);

			if (archivo.exists()) {
				respuesta = "EXISTE";
				buffer = respuesta.getBytes();

				bos.write(buffer.length);
				bos.write(buffer);

				bis = new BufferedInputStream(new FileInputStream(archivo));
				buffer = bis.readAllBytes();
				System.out.println(buffer.length);
				bos.write(buffer.length);
				bos.write(buffer);
			} else {
				respuesta = "ERR";
				buffer = respuesta.getBytes();

				bos.write(buffer.length);
				bos.write(buffer);
			}

			bos.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
