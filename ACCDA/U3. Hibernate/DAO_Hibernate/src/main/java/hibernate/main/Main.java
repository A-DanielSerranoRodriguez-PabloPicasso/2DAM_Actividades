package hibernate.main;

import org.hibernate.Session;

import hibernate.services.ClienteManagmentServiceImpl;
import hibernate.services.VehiculoManagmentServiceImpl;
import hibernate.services.interfaces.ClienteManagmentServiceI;
import hibernate.services.interfaces.VehiculoManagmentServiceI;
import models.Cliente;
import models.Vehiculo;

public class Main {
	public static void main(String[] args) {
		final Session sesion = HibernateUtil.getSessionFactory().openSession();

		VehiculoManagmentServiceI vehiculoService = new VehiculoManagmentServiceImpl(sesion);
		ClienteManagmentServiceI clienteService = new ClienteManagmentServiceImpl(sesion);

		Vehiculo v = vehiculoService.searchById(1);

		System.out.println(v.getColor());

		Cliente c = clienteService.searchById(1);

		System.out.println(c);

	}
}
