package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class GeneralDAO extends AbstractDAO {

	/**
	 * Creates a general connection
	 * 
	 * @throws SQLException
	 */
	public GeneralDAO() throws SQLException {
		super();
	}

	/**
	 * Inserts the data received
	 * 
	 * @param data ArrayLis<String[]>
	 */
	public void insertData(ArrayList<String[]> data) {
		// Initialized a Savepoint for rollbacks
		Savepoint savePoint = null;
		try {
			// Generated the statement and the resultset
			savePoint = CONN.setSavepoint("no_commits");
			Statement stmt = getStatement();
			ResultSet idProf = null;

			// Loop through the data
			for (int i = 0; i < data.size(); i++) {
				String[] partData = data.get(i);
				PreparedStatement psProfs = getPreparedStatement(
						"insert into profesor(nif_p, nombre, especialidad, telefono) values (?,?,?,?);");

				/*
				 * If it's a teacher, insert it and get the id.
				 * 
				 * Else, added to the batch.
				 */
				if (partData[0].equals("Profesor")) {
					idProf = insertProf(partData, psProfs);
				} else
					stmt.addBatch(insertAsign(partData, idProf));
			}
			/*
			 * Batch is executed.
			 * 
			 * If no errors, changes are committed. Else, rollback is produced.
			 */
			stmt.executeBatch();
			CONN.commit();
		} catch (SQLException e) {
			try {
				CONN.rollback(savePoint);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Sets the values of the PreparedStatement and returns the id generated
	 * 
	 * @param prof String[]
	 * @param ps   PreparedStatement
	 * @return ResultSet
	 * @throws SQLException
	 */
	private ResultSet insertProf(String[] prof, PreparedStatement ps) throws SQLException {
		ps.setString(1, prof[1]);
		ps.setString(2, prof[2]);
		ps.setString(3, prof[3]);
		ps.setString(4, prof[4]);
		ps.execute();
		return ps.getGeneratedKeys();
	}

	/**
	 * Returns the statement to be executed
	 * 
	 * @param asign  String[]
	 * @param idProf ResultSet
	 * @return String
	 * @throws SQLException
	 */
	private String insertAsign(String[] asign, ResultSet idProf) throws SQLException {
		idProf.last();
		asign[0] = idProf.getString(1);
		return "insert into asignatura(cod_asignatura, nombre, id_profesor) values ('" + asign[1] + "','" + asign[2]
				+ "','" + asign[0] + "');";
	}

}
