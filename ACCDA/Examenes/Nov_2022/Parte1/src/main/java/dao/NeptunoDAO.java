package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Superusuario;

public class NeptunoDAO extends AbstractDAO {

	public NeptunoDAO() throws SQLException {
		super();
		getStatement().execute("use bd_neptuno");
	}

	/**
	 * Crea la tabla Superusuarios en la base de datos
	 * 
	 * @throws SQLException
	 */
	public void createSuperuserTable() throws SQLException {
		String preparation = "drop table if exists Superusuarios;",
				tableCreation = "create table superusuarios( IdUser int primary key auto_increment, Nombre varchar(40), Apellidos varchar(40), User char(8));";
		Statement stmt = getStatement();

		stmt.addBatch(preparation);
		stmt.addBatch(tableCreation);

		stmt.executeBatch();
	}

	/**
	 * Inserta los susperusuarios en su tabla correspondiente.
	 * 
	 * Se utiliza un sistema de lotes que ejecuta 10 sentencias cada vez.
	 * 
	 * @param sUsuarios ArrayList<Superusuario>
	 * @throws SQLException
	 */
	public void insertSuperusers(ArrayList<Superusuario> sUsuarios) throws SQLException {
		String insert = "insert into Superusuarios(Nombre, Apellidos, User) values (?,?,?);";
		PreparedStatement prepStmt = getPreparedStatement(insert);
		int actual = 1, limit = 10;

		for (Superusuario sUser : sUsuarios) {
			prepStmt.setString(1, sUser.getNombre());
			prepStmt.setString(2, sUser.getApellidos());
			prepStmt.setString(3, sUser.getUser());
			
			prepStmt.addBatch();

			if (actual == limit) {
				prepStmt.executeBatch();
				actual = 1;
			} else
				actual++;
		}

		prepStmt.executeBatch();
	}

}
