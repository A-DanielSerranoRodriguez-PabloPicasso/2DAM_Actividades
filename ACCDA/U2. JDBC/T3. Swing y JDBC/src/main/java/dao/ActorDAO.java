package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActorDAO extends AbstractDAO {
	private static Statement statement;

	public ActorDAO() throws SQLException {
		super();
		statement = getStatement();
	}

	public ResultSet getFilms(int filmId) throws SQLException {
		return statement.executeQuery(
				"select concat(a.first_name, ' ', a.last_name) from actor a inner join film_actor fa on a.actor_id = fa.actor_id where fa.film_id = "
						+ filmId + ";");
	}
}
