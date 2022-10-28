package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;

public class NeptunoDAO extends AbstractDAO {

	public NeptunoDAO() throws SQLException {
		super();
	}

	public void insertCategoriaBatch(ArrayList<Categoria> categorias) throws SQLException {
		String sql = "insert into categorias (categoria, descripcion) values (?,?);";
		PreparedStatement prepStmt = getPreparedStatement(sql);

		for (Categoria cat : categorias) {
			prepStmt.setString(1, cat.getCategoria());
			prepStmt.setString(2, cat.getDescripcion());
			prepStmt.addBatch();
		}

		prepStmt.executeBatch();
	}

	public void updateCategoriaBatch(ArrayList<Categoria> categorias, String[] cambios, boolean campo1, boolean campo2)
			throws SQLException {
		String sqlUpdateAll = "update categorias set categoria=?, descripcion=? where categoria=?;",
				sqlUpdateCat = "update categorias set categoria=? where categoria=?;",
				sqlUpdateDesc = "update categorias set descripcion=? where categoria=?;";
		PreparedStatement prepStmt = null;

		for (Categoria cat : categorias) {
			if (campo1 && campo2) {
				prepStmt = getPreparedStatement(sqlUpdateAll);
				prepStmt.setString(1, cambios[0]);
				prepStmt.setString(2, cambios[1]);
				prepStmt.setString(3, cat.getCategoria());
			} else if (campo1) {
				prepStmt = getPreparedStatement(sqlUpdateCat);
				prepStmt.setString(1, cambios[0]);
				prepStmt.setString(2, cat.getCategoria());
			} else if (campo2) {
				prepStmt = getPreparedStatement(sqlUpdateDesc);
				prepStmt.setString(1, cambios[1]);
				prepStmt.setString(2, cat.getCategoria());
			}

			prepStmt.addBatch();
		}

		prepStmt.executeBatch();
	}

	public void dropCategoriaBatch(ArrayList<Categoria> categorias) throws SQLException {
		String sql = "delete from categorias where categoria=?";
		PreparedStatement prepStmt = getPreparedStatement(sql);

		for (Categoria cat : categorias) {
			prepStmt.setString(1, cat.getCategoria());
			prepStmt.addBatch();
		}

		prepStmt.executeBatch();
	}

}
