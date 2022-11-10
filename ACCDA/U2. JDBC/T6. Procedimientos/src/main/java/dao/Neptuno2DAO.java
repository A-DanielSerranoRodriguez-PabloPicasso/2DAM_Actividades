package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Neptuno2DAO extends AbstractDAO {

	/**
	 * Se conecta a la base de datos bd_neptuno2
	 * 
	 * @throws SQLException
	 */
	public Neptuno2DAO() throws SQLException {
		super();
		getStatement().execute("use bd_neptuno2;");
	}

	/**
	 * Obtiene el nombre de la categoria
	 * 
	 * @param idCat int
	 * @return String
	 */
	public String getCategoria(int idCat) {
		String sql = "call getCategoriaName (?, ?);";
		try (CallableStatement stmt = getCallableStatement(sql)) {
			stmt.setInt(1, idCat);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.execute();
			return stmt.getString(2);
		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza la descripcion de la categoria
	 * 
	 * @param idCat     int
	 * @param nuevaDesc String
	 */
	public void updateDescCategoria(int idCat, String nuevaDesc) {
		String sql = "call updateCategoriaDesc (?, ?);";
		try (CallableStatement stmt = getCallableStatement(sql)) {
			stmt.setInt(1, idCat);
			stmt.setString(2, nuevaDesc);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	}

}
