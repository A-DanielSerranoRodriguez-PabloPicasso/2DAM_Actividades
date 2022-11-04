package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import models.Categorias;
import models.Productos;
import models.Proveedores;

public class NeptunoDAO extends AbstractDAO {
	private Savepoint sp;

	/**
	 * Constructor para conectarse a la base de datos bd_neptuno
	 * 
	 * @throws SQLException
	 */
	public NeptunoDAO() throws SQLException {
		super();
		getStatement().execute("use bd_neptuno");
	}

	/**
	 * Activa las transacciones
	 * 
	 * @throws SQLException
	 */
	public void disableAutocommit() throws SQLException {
		CONN.setAutoCommit(false);
	}

	/**
	 * Desactiva las transacciones
	 * 
	 * @throws SQLException
	 */
	public void enableAutocommit() throws SQLException {
		CONN.setAutoCommit(true);
	}

	/**
	 * Crea un Savepoint al que volver en un rollback
	 * 
	 * @param sp String con el nombre del Savepoint
	 * @throws SQLException
	 */
	public void setSavepoint() throws SQLException {
		sp = CONN.setSavepoint("no_commits");
	}

	/**
	 * Hace un rollback de la transaccion
	 * 
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		CONN.rollback(sp);
	}

	/**
	 * Hace un commit de la transaccion
	 * 
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		CONN.commit();
	}

	/**
	 * Obtiene las categorias
	 * 
	 * @param idCat Id de las categorias que obtener
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getCategorias(int idCat) throws SQLException {
		String sql = "select * from categorias where id = ?;";
		PreparedStatement prepStmt = getPreparedStatement(sql);

		prepStmt.setInt(1, idCat);

		return prepStmt.executeQuery();
	}

	/**
	 * Obtiene los productos
	 * 
	 * @param idCat Id de categoria por la que buscar el producto
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getProductos(int idCat) throws SQLException {
		String sql = "select * from productos where categoria_id = ?;";
		PreparedStatement prepStmt = getPreparedStatement(sql);

		prepStmt.setInt(1, idCat);

		return prepStmt.executeQuery();
	}

	/**
	 * Obtiene los proveedores
	 * 
	 * @param idProvs Id de los proveedores que buscar
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getProveedores(ArrayList<Integer> idProvs) throws SQLException {
		String sql = "select * from proveedores where id = ?";

		for (int i = 0; i < idProvs.size() - 1; i++)
			sql += " or id = ?";
		sql += ";";

		PreparedStatement prepStmt = getPreparedStatement(sql);

		for (int i = 0; i < idProvs.size(); i++)
			prepStmt.setInt(i + 1, idProvs.get(i));

		return prepStmt.executeQuery();
	}

	/**
	 * Inserta categorias en Categorias_new
	 * 
	 * @param cat Categoria a insertar
	 * @throws SQLException
	 */
	public void insertNewCategoria(Categorias cat) throws SQLException {
		String sql = "insert into Categorias_new values(?,?,?);";
		PreparedStatement prepStmt;

		prepStmt = getPreparedStatement(sql);
		prepStmt.setInt(1, cat.getId());
		prepStmt.setString(2, cat.getCategoria());
		prepStmt.setString(3, cat.getDescripcion());

		prepStmt.execute();
	}

	/**
	 * Inserta proveedores en Proveedores_new
	 * 
	 * @param proveedores ArrayList<Proveedores>
	 * @throws SQLException
	 */
	public void insertNewProovedores(Proveedores prov) throws SQLException {
		String sql = "insert into Proveedores_new values(?,?,?);";
		PreparedStatement prepStmt;

		prepStmt = getPreparedStatement(sql);
		prepStmt.setInt(1, prov.getId());
		prepStmt.setString(2, prov.getEmpresa());
		prepStmt.setString(3, prov.getContacto());

		prepStmt.execute();
	}

	/**
	 * Inserta productos en Productos_new
	 * 
	 * @param productos ArrayList<Productos>
	 * @throws SQLException
	 */
	public void insertNewProductos(Productos producto) throws SQLException {
		String sql = "insert into Productos_new values(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement prepStmt;
		prepStmt = getPreparedStatement(sql);
		prepStmt.setInt(1, producto.getId());
		prepStmt.setString(2, producto.getProducto());
		prepStmt.setInt(3, producto.getProveedorId());
		prepStmt.setInt(4, producto.getCategoriaId());
		prepStmt.setString(5, producto.getCantidadPorUnidad());
		prepStmt.setDouble(6, producto.getPrecioUnidad());
		prepStmt.setInt(7, producto.getUnidadesExistencia());
		prepStmt.setInt(8, producto.getUnidadesPedido());
		prepStmt.setInt(9, producto.getNivelNuevoPedido());
		prepStmt.setInt(10, producto.getSuspendido());

		prepStmt.execute();
	}
}
