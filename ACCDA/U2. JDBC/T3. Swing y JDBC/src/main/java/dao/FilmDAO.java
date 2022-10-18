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

	public boolean insertFilm(String title, String descr, String releaseYear, String length, String rentDur,
			String rentRate, String replaceCost) {
		if (releaseYear.isBlank())
			releaseYear = "0";
		try {
			statement.execute(
					"insert into film(title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost) values ('"
							+ title + "', '" + descr + "', '" + releaseYear + "', 1, " + Integer.parseInt(rentDur)
							+ ", " + Double.parseDouble(rentRate) + ", "
							+ Integer.parseInt(length.isBlank() ? "0" : length) + ", " + Double.parseDouble(replaceCost)
							+ ");");
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateFilm(int id, String title, String descr, String releaseYear, String length, String rentDur,
			String rentRate, String replaceCost) {
		if (releaseYear.isBlank())
			releaseYear = "0";
		try {
			statement.execute("update film set title='" + title + "', description='" + descr + "', release_year='"
					+ releaseYear + "', rental_duration=" + Integer.parseInt(rentDur) + ", rental_rate="
					+ Double.parseDouble(rentRate) + ", length=" + Integer.parseInt(length) + ", replacement_cost="
					+ Double.parseDouble(replaceCost) + " where film_id=" + id + ";");
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
