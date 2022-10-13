package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba2DAO {
	final private String dbUrl = "jdbc:mysql://localhost:3306/", dbUser = "accda", dbPasswd = "accda";
	private static Connection CONN;

	/**
	 * Crea la conexion con la base de datos
	 * @throws SQLException
	 */
	public Prueba2DAO() throws SQLException {
		CONN = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
	}

	/**
	 * Devuelve un Statement
	 * @return Statement
	 * @throws SQLException
	 */
	public Statement createStatement() throws SQLException {
		return CONN.createStatement();
	}

	/**
	 * Crea todos los componentes necesarios, usando una transaccion
	 */
	public void createAll() {
		try {
			// Crea una transaccion y la ejecuta
			Statement stmt = createStatement();
			stmt.addBatch("drop database if exists prueba2;");
			stmt.addBatch("create database prueba2;");
			stmt.addBatch("use prueba2;");
			stmt.addBatch("create table Region(" + "CodRegion int primary key," + "Nombre varchar(20) not null" + ");");
			stmt.addBatch("create table Provincia(" + "CodProvincia int primary key," + "Nombre varchar(20) not null,"
					+ "CodRegion int,"
					+ "constraint fk_provincia_region foreign key (CodRegion) references Region(CodRegion));");
			stmt.addBatch("create table Localidad(" + "CodLocalidad int primary key," + "Nombre varchar(20) not null,"
					+ "CodProvincia int,"
					+ "constraint fk_localidad_provincia foreign key (CodProvincia) references Provincia(CodProvincia));");
			stmt.addBatch("create table Empleado(" + "ID int primary key," + "DNI varchar(9) not null unique,"
					+ "Nombre varchar(20) not null," + "FechaNac date not null," + "Telefono int,"
					+ "Salario double not null," + "CodLocalidad int,"
					+ "constraint fk_empleado_localidad foreign key (CodLocalidad) references Localidad(CodLocalidad));");
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
