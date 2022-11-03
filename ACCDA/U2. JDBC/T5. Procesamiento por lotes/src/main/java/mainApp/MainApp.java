package mainApp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.NeptunoDAO;
import model.Categoria;

public class MainApp {

	public static void main(String[] args) {
		NeptunoDAO nDao = null;
		ArrayList<Categoria> categorias = new ArrayList<>();
		String[] cambios = new String[2];

		for (int i = 1; i <= 20; i++) {
			categorias.add(new Categoria("Categoria" + i, "Descripcion" + i));
			cambios[0] = "Categoria" + (20 + i);
			cambios[1] = "Descripcion" + (20 + i);
		}

		try {
			nDao = new NeptunoDAO();
			nDao.insertCategoriaBatch(categorias);

			nDao.updateCategoriaBatch(categorias, cambios, false, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
