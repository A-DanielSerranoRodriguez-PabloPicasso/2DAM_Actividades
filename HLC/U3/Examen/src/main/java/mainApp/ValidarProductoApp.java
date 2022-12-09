package mainApp;

import utils.ValidationWorker;

public class ValidarProductoApp {

	public static void main(String[] args) {
		ValidationWorker vw = new ValidationWorker("src/main/resources/datos/conErrores/datos001.txt");
		
		vw.validaCorreoPedidos();
		vw.validaDominio();
		vw.validaFechaInicio();
		vw.validaMarca();
		vw.validaNombre();
		vw.validaNombre();
		vw.validaPrecio();
		vw.validaPuntosDebiles();
		vw.validaPuntosFuertes();
		vw.validaPuntuacion();
		vw.validaReferencia();
		vw.validaUrl();
	
		vw.muestraErrores();
		
	}
}
