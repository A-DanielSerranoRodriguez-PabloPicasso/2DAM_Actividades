package psp.ud03.practica02.models;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class FileSender extends Thread {

	private Socket socket;

	public FileSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedInputStream bis;
		BufferedOutputStream bos;
		BufferedReader br;
		BufferedWriter bw;
		String ruta;
		byte[] buffer;
		int size;

		try {
			bis = new BufferedInputStream(socket.getInputStream());
			bos = new BufferedOutputStream(socket.getOutputStream());
			size = bis.read();
			buffer = new byte[size];
			int i = 0;

			while (i < size) {
				buffer[i] = (byte) bis.read();
				i++;
			}

			bos.write(buffer);
			bos.flush();
//			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			ruta = new String(br.readLine());
//			System.out.println(ruta);
//			ruta = new String(br.readLine());
//			System.out.println(ruta);
//			bw.write(ruta);
//			bw.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
