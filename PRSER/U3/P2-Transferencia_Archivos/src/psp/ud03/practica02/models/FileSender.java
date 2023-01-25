package psp.ud03.practica02.models;

import java.net.DatagramSocket;
import java.net.Socket;

public class FileSender extends Thread {

	private Socket tcpSocket;
	private DatagramSocket dgs;
	private int puerto;
	private String ruta;

	public FileSender(Socket socket) {
		this.tcpSocket = socket;
	}

	@Override
	public void run() {
		
		
//		DatagramPacket dgpRespuesta;
//		byte[] buffer = new byte[1024];
//		File archivo = new File(ruta);
//		String respuesta;
//		boolean exists = archivo.exists();
//		BufferedInputStream bis = null;
//
//		try {
//			dgs.connect(InetAddress.getLocalHost(), puerto);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//
//		if (exists) {
//			respuesta = "OK";
//		} else {
//			respuesta = "ERR";
//		}
//
//		buffer = respuesta.getBytes();
//		dgpRespuesta = new DatagramPacket(buffer, buffer.length);
//
//		try {
//			dgs.send(dgpRespuesta);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		if (exists) {
//			try {
//				bis = new BufferedInputStream(new FileInputStream(archivo));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//
//			try {
//				buffer = bis.readAllBytes();
//				bis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			dgpRespuesta = new DatagramPacket(buffer, buffer.length);
//
//			try {
//				dgs.send(dgpRespuesta);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
