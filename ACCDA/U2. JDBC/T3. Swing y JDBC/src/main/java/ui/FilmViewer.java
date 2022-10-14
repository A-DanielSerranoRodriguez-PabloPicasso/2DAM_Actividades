package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.FilmDAO;

public class FilmViewer {
	private int startPoint = 0;
	private ResultSet films = null;

	private JFrame frame;
	private JPanel mainPanel;

	private JLabel lblTitle, lblDescr, lblReleYear, lblRentDur, lblRentRate, lblLength, lblReplCost, lblRating,
			lblSpecFeat, lblLastUpdt;
	private JTextField txfTitle, txfReleYear, txfLength, txfRating, txfLastUpdate, txfSpecFeat, txfRentDur, txfRentRate,
			txfReplCost;
	private JTextArea txaDescr;
	private JButton btnFirst, btnPrev, btnNext, btnLast, btnEdit, btnNew, btnSave, btnCancel;

	/**
	 * Create the application.
	 */
	public FilmViewer() {
		initialize();
		setUIcomponents();
		setUIbehaviour();
		getFilms();
		try {
			fillText();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		frame.repaint();
		frame.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);
	}

	private void setUIcomponents() {
		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "name_5564877770200");
		mainPanel.setLayout(null);

		lblTitle = new JLabel("Titulo");
		lblTitle.setBounds(43, 38, 86, 14);
		mainPanel.add(lblTitle);

		lblDescr = new JLabel("Descripcion");
		lblDescr.setBounds(43, 319, 86, 14);
		mainPanel.add(lblDescr);

		lblReleYear = new JLabel("Año lanzamiento");
		lblReleYear.setBounds(395, 38, 121, 14);
		mainPanel.add(lblReleYear);

		lblRentDur = new JLabel("Duración de alquiler");
		lblRentDur.setBounds(43, 226, 162, 14);
		mainPanel.add(lblRentDur);

		lblRentRate = new JLabel("Coste de alquiler");
		lblRentRate.setBounds(226, 226, 111, 14);
		mainPanel.add(lblRentRate);

		lblLength = new JLabel("Duración");
		lblLength.setBounds(568, 38, 86, 14);
		mainPanel.add(lblLength);

		lblReplCost = new JLabel("Coste de remplazo");
		lblReplCost.setBounds(395, 226, 137, 14);
		mainPanel.add(lblReplCost);

		lblRating = new JLabel("Clasificación de edad");
		lblRating.setBounds(43, 136, 121, 14);
		mainPanel.add(lblRating);

		lblSpecFeat = new JLabel("Características especiales");
		lblSpecFeat.setBounds(395, 136, 175, 14);
		mainPanel.add(lblSpecFeat);

		lblLastUpdt = new JLabel("Última actualización");
		lblLastUpdt.setBounds(226, 136, 132, 14);
		mainPanel.add(lblLastUpdt);

		txfTitle = new JTextField();
		txfTitle.setEnabled(false);
		txfTitle.setBounds(43, 63, 269, 20);
		mainPanel.add(txfTitle);
		txfTitle.setColumns(10);

		txfReleYear = new JTextField();
		txfReleYear.setEnabled(false);
		txfReleYear.setColumns(10);
		txfReleYear.setBounds(395, 63, 86, 20);
		mainPanel.add(txfReleYear);

		txfLength = new JTextField();
		txfLength.setEnabled(false);
		txfLength.setColumns(10);
		txfLength.setBounds(568, 63, 86, 20);
		mainPanel.add(txfLength);

		txfRating = new JTextField();
		txfRating.setEnabled(false);
		txfRating.setColumns(10);
		txfRating.setBounds(43, 161, 86, 20);
		mainPanel.add(txfRating);

		txfLastUpdate = new JTextField();
		txfLastUpdate.setEnabled(false);
		txfLastUpdate.setColumns(10);
		txfLastUpdate.setBounds(226, 161, 111, 20);
		mainPanel.add(txfLastUpdate);

		txfSpecFeat = new JTextField();
		txfSpecFeat.setEnabled(false);
		txfSpecFeat.setColumns(10);
		txfSpecFeat.setBounds(395, 161, 259, 20);
		mainPanel.add(txfSpecFeat);

		txfRentDur = new JTextField();
		txfRentDur.setEnabled(false);
		txfRentDur.setColumns(10);
		txfRentDur.setBounds(43, 251, 86, 20);
		mainPanel.add(txfRentDur);

		txfRentRate = new JTextField();
		txfRentRate.setEnabled(false);
		txfRentRate.setColumns(10);
		txfRentRate.setBounds(226, 251, 86, 20);
		mainPanel.add(txfRentRate);

		txfReplCost = new JTextField();
		txfReplCost.setEnabled(false);
		txfReplCost.setColumns(10);
		txfReplCost.setBounds(395, 251, 86, 20);
		mainPanel.add(txfReplCost);

		txaDescr = new JTextArea();
		txaDescr.setEnabled(false);
		txaDescr.setBounds(43, 344, 873, 167);
		mainPanel.add(txaDescr);

		btnFirst = new JButton("Primero");
		btnFirst.setBounds(43, 591, 89, 23);
		mainPanel.add(btnFirst);

		btnPrev = new JButton("Anterior");
		btnPrev.setBounds(226, 591, 89, 23);
		mainPanel.add(btnPrev);

		btnNext = new JButton("Siguiente");
		btnNext.setBounds(395, 591, 89, 23);
		mainPanel.add(btnNext);

		btnLast = new JButton("Último");
		btnLast.setBounds(568, 591, 89, 23);
		mainPanel.add(btnLast);

		btnEdit = new JButton("Editar");
		btnEdit.setBounds(795, 62, 121, 23);
		mainPanel.add(btnEdit);

		btnNew = new JButton("Nueva película");
		btnNew.setBounds(795, 160, 121, 23);
		mainPanel.add(btnNew);

		btnSave = new JButton("Guardar");
		btnSave.setVisible(false);
		btnSave.setBounds(795, 250, 121, 23);
		mainPanel.add(btnSave);

		btnCancel = new JButton("Cancelar");
		btnCancel.setVisible(false);
		btnCancel.setBounds(587, 250, 121, 23);
		mainPanel.add(btnCancel);
	}

	private void setUIbehaviour() {
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					films.next();
					fillText();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew.setVisible(false);
				switchButtons();
				switchEditText();
			}
		});

		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setVisible(false);
				switchButtons();
				switchEditText();
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setVisible(true);
				btnNew.setVisible(true);
				switchButtons();
				switchEditText();
			}
		});
	}

	private void getFilms() {
		FilmDAO fdao = null;
		try {
			fdao = new FilmDAO();
			films = fdao.getFilms(startPoint);
			films.next();
		} catch (SQLException e) {
			txaDescr.setText("Error de conexión a la base de datos");
			e.printStackTrace();
		}
	}

	private void fillText() throws SQLException {
		txfTitle.setText(films.getString("title"));
		txfReleYear.setText(films.getString("release_year"));
		txfLength.setText(Integer.toString(films.getInt("length")));
		txfRating.setText(films.getString("rating"));
		txfLastUpdate.setText(films.getString("last_update"));
		txfSpecFeat.setText(films.getString("special_features"));
		txfRentDur.setText(Integer.toString(films.getInt("rental_duration")));
		txfRentRate.setText(Double.toString(films.getDouble("rental_rate")));
		txfReplCost.setText(Double.toString(films.getDouble("replacement_cost")));
		txaDescr.setText(films.getString("description"));
	}

	private void switchButtons() {
		btnEdit.setEnabled(!btnEdit.isEnabled());
		btnNew.setEnabled(!btnNew.isEnabled());
		btnSave.setVisible(!btnSave.isVisible());
		btnCancel.setVisible(!btnCancel.isVisible());
	}

	private void switchEditText() {
		txfTitle.setEnabled(!txfTitle.isEnabled());
		txfReleYear.setEnabled(!txfReleYear.isEnabled());
		txfLength.setEnabled(!txfLength.isEnabled());
		txfRating.setEnabled(!txfRating.isEnabled());
		txfLastUpdate.setEnabled(!txfLastUpdate.isEnabled());
		txfSpecFeat.setEnabled(!txfSpecFeat.isEnabled());
		txfRentDur.setEnabled(!txfRentDur.isEnabled());
		txfRentRate.setEnabled(!txfRentRate.isEnabled());
		txfReplCost.setEnabled(!txfReplCost.isEnabled());
		txaDescr.setEnabled(!txaDescr.isEnabled());
	}
}
