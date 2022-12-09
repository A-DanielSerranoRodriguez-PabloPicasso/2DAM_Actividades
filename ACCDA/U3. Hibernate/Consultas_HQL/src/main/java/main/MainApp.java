package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import models.Categorias;
import models.Pedidos;
import models.Productos;
import utils.HibernateUtils;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
		Query query;
		List<Object[]> lista;

//		System.out.println(
//				"-- 1.- Mostrar el nombre del producto y el nombre de la categoria de todos los productos que contengan la letra Q en el nombre.");
//		query = session.createQuery(
//				"select p, p.categorias from Productos p inner join p.categorias where p.producto like '%Q%'");
//		lista = query.list();
//		for (Object[] elem : lista) {
//			Productos p = (Productos) elem[0];
//			Categorias c = (Categorias) elem[1];
//
//			System.out.print("Producto: " + p.getProducto() + " || ");
//			System.out.println("Categoria: " + c.getCategoria());
//		}

//		System.out.println(
//				"\n-- 2.- Mostrar el numero de pedido y el pais del cliente de los pedidos de mayo del año 1997");
//		// NO HAY REGISTROS EN LA BASE DE DATOS. CAMBIAR 1997 POR 1996 Y 5 POR 8 PARA
//		// COMPROBAR.
//		query = session.createQuery(
//				"select d.pedidos from Detalles d inner join d.pedidos inner join d.productos where year(d.pedidos.fechaPedido)=1997 and month(d.pedidos.fechaPedido)=5");
//		List<Pedidos> pedidos = query.list();
//		for (Pedidos ped : pedidos) {
//			System.out.print("N. pedido: " + ped.getId() + " || ");
//			System.out.println("Pais cliente: " + ped.getPaisDestinatario());
//		}

		System.out.println(
				"\n-- 3.- Mostrar fecha del pedido, cantidad y el nombre producto, y el codigo del pedido para los codigos de pedido 10285 o 10298.");
		query = session.createQuery("");

		System.out.println("\n-- 4.- ¿Cuanto se factura cada mes? Mostrar el año, el mes y el total.");
		query = session.createQuery("");

		System.out.println("\n-- 5.- Los pedidos que hizo la empleada Nancy");
		query = session.createQuery("");

		System.out.println("\n-- 6.- Mostrar los pedidos de Anton (codigo cliente).");
		query = session.createQuery("");

		System.out.println("\n-- 7.- Cuantos productos hay de cada categoria y el precio medio");
		query = session.createQuery("");

		System.out.println("\n-- 8.- Mostrar los pedidos que tienen productos en la categoria 2 o 3");
		query = session.createQuery("");

		System.out.println("\n-- 9.- Clientes que pidieron queso en julio de 1997");
		query = session.createQuery("");

		System.out.println("\nOtra manera");
		query = session.createQuery("");

		HibernateUtils.close();

	}

}
