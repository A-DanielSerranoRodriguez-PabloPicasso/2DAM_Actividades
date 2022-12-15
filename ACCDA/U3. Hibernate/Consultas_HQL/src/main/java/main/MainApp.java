package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import models.Categorias;
import models.Clientes;
import models.Pedidos;
import models.Productos;
import utils.HibernateUtils;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
		Query query;
		List<Object[]> lista;
		List<Pedidos> pedidos;

		System.out.println(
				"-- 1.- Mostrar el nombre del producto y el nombre de la categoria de todos los productos que contengan la letra Q en el nombre.");
		query = session.createQuery(
				"select p, p.categorias from Productos p inner join p.categorias where p.producto like '%Q%' order by p.fechaPedido, p.id");
		lista = query.list();
		for (Object[] elem : lista) {
			Productos p = (Productos) elem[0];
			Categorias c = (Categorias) elem[1];

			System.out.print("Producto: " + p.getProducto() + " || ");
			System.out.println("Categoria: " + c.getCategoria());
		}

		System.out.println(
				"\n-- 2.- Mostrar el numero de pedido y el pais del cliente de los pedidos de mayo del año 1997");
		// NO HAY REGISTROS EN LA BASE DE DATOS. CAMBIAR 1997 POR 1996 Y 5 POR 8 PARA
		// COMPROBAR.
		query = session.createQuery(
				"select d from Detalles d"
				+ " inner join d.pedidos inner join d.productos"
				+ " where year(d.pedidos.fechaPedido)=1997 and month(d.pedidos.fechaPedido)=5"
				+ "order by p.id, p.fechaPedido");
		pedidos = query.list();
		for (Pedidos ped : pedidos) {
			System.out.print("N. pedido: " + ped.getId() + " || ");
			System.out.println("Pais cliente: " + ped.getPaisDestinatario());
		}

		System.out.println(
				"\n-- 3.- Mostrar fecha del pedido, cantidad y el nombre producto, y el codigo del pedido para los codigos de pedido 10285 o 10298.");
		query = session.createQuery("select ped.fechaPedido, prod.cantidadPorUnidad, prod.producto, ped.id "
				+ "from Detalles d inner join d.pedidos ped inner join d.productos prod "
				+ "where ped.id=10285 or ped.id=10298 order by ped.fechaPedido, prod.id");
		lista = query.list();
		for (Object[] elem : lista) {
			System.out.println("Fecha pedido: " + elem[0]);
			System.out.println("Cantidad: " + elem[1]);
			System.out.println("Nombre: " + elem[2]);
			System.out.println("Codigo: " + elem[3]);
		}

		System.out.println("\n-- 4.- ¿Cuanto se factura cada mes? Mostrar el año, el mes y el total.");
		query = session.createQuery(
				"select year(ped.fechaPedido), month(ped.fechaPedido), sum(prod.unidadesPedido * prod.precioUnidad * (1 - d.descuento)) "
						+ "from Detalles d inner join d.productos prod inner join d.pedidos ped "
						+ "group by year(ped.fechaPedido), month(ped.fechaPedido) order by sum(prod.unidadesPedido * prod.precioUnidad * (1 - d.descuento))");
		lista = query.list();
		for (Object[] elem : lista) {
			System.out.println("Anyo: " + elem[0]);
			System.out.println("Mes: " + elem[1]);
			System.out.println("Total: " + elem[2]);
		}

		System.out.println("\n-- 5.- Los pedidos que hizo la empleada Nancy");
		query = session.createQuery("select p from Pedidos p inner join p.empleados e where e.nombre like 'Nancy%'");
		// NO HAY REGISTROS EN LA BASE DE DATOS. PROBAR CON ALEJANDRA
		pedidos = query.list();
		for (Pedidos ped : pedidos) {
			System.out.println(ped.getEmpleados().getNombre() + ": " + ped.getId());
		}

		System.out.println("\n-- 6.- Mostrar los pedidos de ANTON (codigo cliente).");
		query = session.createQuery("select p from Pedidos p inner join p.clientes c where c.codigo='ANTON'");
		pedidos = query.list();
		for (Pedidos ped : pedidos) {
			System.out.println(ped.getClientes().getCodigo() + ": " + ped.getId());
		}

		System.out.println("\n-- 7.- Cuantos productos hay de cada categoria y el precio medio");
		query = session.createQuery(
				"select c.categoria, sum(p), avg(p.precioUnidad) from Productos p"
				+ " inner join p.categorias c group by c");
		lista = query.list();
		for (Object[] elem : lista) {
			String cat = (String) elem[0];
			Long num = (Long) elem[1];
			Double media = (Double) elem[2];
			System.out.println(cat + ": " + num + " | " + media);
		}

		System.out.println("\n-- 8.- Mostrar los pedidos que tienen productos en la categoria 2 o 3");
		query = session.createQuery("select ped from Detalles d "
				+ "inner join d.pedidos ped inner join d.productos prod inner join prod.categorias cat "
				+ "where cat.id=2 or cat.id=3");
		pedidos = query.list();
		for (Pedidos ped : pedidos) {
			System.out.println(ped.getId());
		}

		System.out.println("\n-- 9.- Clientes que pidieron queso en julio de 1997");
		query = session.createQuery("select cli from Detalles d "
				+ "inner join d.productos prod inner join d.pedidos ped inner join ped.clientes cli "
				+ "where prod.producto like '%queso%' and year(ped.fechaPedido) = 1997 and month(ped.fechaPedido) = 7");
		List<Clientes> clientes = query.list();
		for (Clientes cli : clientes) {
			System.out.println(cli.getContacto());
		}

		HibernateUtils.close();

	}

}
