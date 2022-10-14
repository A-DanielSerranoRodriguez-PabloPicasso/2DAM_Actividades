package mainApp;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FilmDAO;
import ui.FilmViewer;

public class MainApp {

	public static void main(String[] args) {
		ResultSet rs = null;
		FilmDAO fdao = null;

		try {
			fdao = new FilmDAO();
			rs = fdao.getFilms(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		new FilmViewer();

		try {
			rs.next();
			System.out.println(rs.getString("title") + ":" + rs.getString("description") + ":"
					+ rs.getString("release_year") + ":" + rs.getInt("rental_duration") + ":"
					+ rs.getDouble("rental_rate") + ":" + rs.getInt("length") + ":" + rs.getDouble("replacement_cost")
					+ ":" + rs.getString("rating") + ":" + rs.getString("special_features") + ":"
					+ rs.getString("last_update"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
