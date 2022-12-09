package mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.HibernateDAO;
import models.Products;

public class MainApp {

	public static void main(String[] args) {
		HibernateDAO hDao = new HibernateDAO();
		Session session = hDao.getSession();
		Query<Products> query = session.getNamedQuery("getProducts");
		
		List<Products> productos = query.list();
		
		for(Products prod : productos) {
			System.out.println(prod.getProductName());
		}
	}

}
