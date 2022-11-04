package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;

public class Neptuno2DAO extends AbstractDAO {

	/**
	 * Crea una conexion a la base de datos bd_neptuno2.
	 * 
	 * @throws SQLException
	 */
	public Neptuno2DAO() throws SQLException {
		super();
		getStatement().execute("use bd_neptuno2");
	}

	/**
	 * Inserta las categorias en la base de datos en la tabla "categorias".
	 * 
	 * @param categorias ArrayList<Categoria>
	 * @throws SQLException
	 */
	public void insertCategoriaBatch(ArrayList<Categoria> categorias) throws SQLException {
		String sql = "insert into categorias (categoria, descripcion) values (?,?);";
		PreparedStatement prepStmt = getPreparedStatement(sql);

		for (int i = 0; i < categorias.size(); i++) {
			Categoria cat = categorias.get(i);
			prepStmt.setString(1, cat.getCategoria());
			prepStmt.setString(2, cat.getDescripcion());
			prepStmt.addBatch();

			if (i % 5 == 0) {
				prepStmt.executeBatch();
				prepStmt.clearBatch();
			}
		}

		prepStmt.executeBatch();
	}

	public void updateCategoriaBatch(ArrayList<Categoria> categorias, ArrayList<Categoria> cambios, boolean campo1,
			boolean campo2) throws SQLException {
		String sqlUpdateAll = "update categorias set categoria=?, descripcion=? where categoria=?;";
		PreparedStatement prepStmt = null;
		prepStmt = getPreparedStatement(sqlUpdateAll);

		for (int i = 0; i < categorias.size(); i++) {
			Categoria newCat = cambios.get(i), oldCat = categorias.get(i);

			prepStmt.setString(1, oldCat.getCategoria());
			prepStmt.setString(2, oldCat.getDescripcion());

			if (campo1)
				prepStmt.setString(1, newCat.getCategoria());

			if (campo2)
				prepStmt.setString(2, newCat.getDescripcion());

			prepStmt.setString(3, oldCat.getCategoria());

			prepStmt.addBatch();

			if (i % 5 == 0) {
				prepStmt.executeBatch();
				prepStmt.clearBatch();
			}
		}

		prepStmt.executeBatch();
	}

}
