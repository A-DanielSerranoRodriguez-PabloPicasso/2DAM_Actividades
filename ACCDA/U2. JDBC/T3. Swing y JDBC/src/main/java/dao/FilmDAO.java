package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilmDAO extends AbstractDAO {
	private static Statement statement;

	public FilmDAO() throws SQLException {
		super();
		statement = getStatement();
	}

	public ResultSet getFilms() throws SQLException {
		return statement.executeQuery("select * from film;");
	}
}
