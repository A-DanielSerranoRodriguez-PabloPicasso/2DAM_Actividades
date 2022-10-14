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

	public ResultSet getFilms(int startPoint) throws SQLException {
		return statement.executeQuery("select * from film limit " + startPoint + ",20;");
	}
}
