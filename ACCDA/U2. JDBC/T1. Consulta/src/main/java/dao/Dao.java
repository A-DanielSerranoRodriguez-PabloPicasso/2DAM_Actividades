package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	final private String dbUrl = "jdbc:mysql://localhost:3306/bd_neptuno2", dbUser = "accda", dbPasswd = "accda";
	private static Connection CONN;

	public Dao() throws SQLException {
		CONN = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
	}

	public void getData(String tabla) throws SQLException, IOException {
		Statement stmt = CONN.createStatement();
		BufferedWriter bw = null;
		File file = null;
		try (ResultSet rsltSet = stmt.executeQuery("select * from " + tabla)) {
			file = new File("src/main/resources/" + tabla + ".txt");
			if (!file.exists())
				file.createNewFile();
			bw = new BufferedWriter(new FileWriter(file));
			while (rsltSet.next()) {
				bw.write("ID: " + rsltSet.getInt(1) + ", Codigo: " + rsltSet.getString(2) + ", CP: "
						+ rsltSet.getString(9) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}

		System.out.println("Datos escritos a:\n" + file.getCanonicalPath());
	}
}
