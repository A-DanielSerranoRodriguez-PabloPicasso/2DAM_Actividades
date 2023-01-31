package psp.ud03.practica02.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileSender extends Thread {

	private Socket socket;

	public FileSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream bis;
		DataOutputStream bos;
		String ruta = "", respuesta;
		File archivo;
		byte[] buffer = new byte[0];

		try {
			bis = new DataInputStream(socket.getInputStream());
			bos = new DataOutputStream(socket.getOutputStream());

			try {
				ruta = bis.readUTF();
			} catch (EOFException e) {
			}
			archivo = new File(ruta);

			if (archivo.exists()) {
				respuesta = "EXISTE";
				bos.writeUTF(respuesta);
				bos.flush();

				bis = new DataInputStream(new FileInputStream(archivo));
				buffer = bis.readAllBytes();
				bos.write(buffer);
				bos.flush();
			} else {
				respuesta = "ERR";

				bos.writeUTF(respuesta);
			}

			bos.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
