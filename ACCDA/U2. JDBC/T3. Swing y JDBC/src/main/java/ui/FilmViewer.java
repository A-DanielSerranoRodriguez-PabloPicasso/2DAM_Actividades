package ui;

import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ActorDAO;
import dao.FilmDAO;

public class FilmViewer {
	private ResultSet films = null;
	private boolean opt;

	private JFrame frmPeliculasDeSakila;
	private JPanel mainPanel;

	private JLabel lblTitle, lblDescr, lblReleYear, lblRentDur, lblRentRate, lblLength, lblReplCost, lblRating,
			lblSpecFeat, lblLastUpdt, lblActors;
	private JTextField txfTitle, txfReleYear, txfLength, txfRating, txfLastUpdate, txfSpecFeat, txfRentDur, txfRentRate,
			txfReplCost;
	private JTextArea txaDescr, txaActors;
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
		frmPeliculasDeSakila.repaint();
		frmPeliculasDeSakila.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPeliculasDeSakila = new JFrame();
		frmPeliculasDeSakila.setTitle("Peliculas de Sakila");
		frmPeliculasDeSakila.setBounds(100, 100, 1000, 700);
		frmPeliculasDeSakila.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPeliculasDeSakila.getContentPane().setLayout(new CardLayout(0, 0));
		frmPeliculasDeSakila.setVisible(true);
	}

	private void setUIcomponents() {
		mainPanel = new JPanel();
		frmPeliculasDeSakila.getContentPane().add(mainPanel, "name_5564877770200");
		mainPanel.setLayout(null);

		lblTitle = new JLabel("Titulo");
		lblTitle.setBounds(43, 38, 86, 14);
		mainPanel.add(lblTitle);

		lblDescr = new JLabel("Descripcion");
		lblDescr.setBounds(43, 383, 86, 14);
		mainPanel.add(lblDescr);

		lblReleYear = new JLabel("Año lanzamiento");
		lblReleYear.setBounds(395, 38, 121, 14);
		mainPanel.add(lblReleYear);

		lblRentDur = new JLabel("Duración de alquiler");
		lblRentDur.setBounds(43, 183, 162, 14);
		mainPanel.add(lblRentDur);

		lblRentRate = new JLabel("Coste de alquiler");
		lblRentRate.setBounds(193, 183, 111, 14);
		mainPanel.add(lblRentRate);

		lblLength = new JLabel("Duración");
		lblLength.setBounds(568, 38, 86, 14);
		mainPanel.add(lblLength);

		lblReplCost = new JLabel("Coste de remplazo");
		lblReplCost.setBounds(395, 183, 137, 14);
		mainPanel.add(lblReplCost);

		lblRating = new JLabel("Clasificación de edad");
		lblRating.setBounds(43, 107, 121, 14);
		mainPanel.add(lblRating);

		lblSpecFeat = new JLabel("Características especiales");
		lblSpecFeat.setBounds(395, 107, 175, 14);
		mainPanel.add(lblSpecFeat);

		lblLastUpdt = new JLabel("Última actualización");
		lblLastUpdt.setBounds(193, 107, 132, 14);
		mainPanel.add(lblLastUpdt);

		lblActors = new JLabel("Actores");
		lblActors.setBounds(43, 263, 46, 14);
		mainPanel.add(lblActors);

		txfTitle = new JTextField();
		txfTitle.setEditable(false);
		txfTitle.setBounds(43, 63, 309, 20);
		mainPanel.add(txfTitle);
		txfTitle.setColumns(10);

		txfReleYear = new JTextField();
		txfReleYear.setEditable(false);
		txfReleYear.setColumns(10);
		txfReleYear.setBounds(395, 63, 86, 20);
		mainPanel.add(txfReleYear);

		txfLength = new JTextField();
		txfLength.setEditable(false);
		txfLength.setColumns(10);
		txfLength.setBounds(568, 63, 86, 20);
		mainPanel.add(txfLength);

		txfRating = new JTextField();
		txfRating.setEditable(false);
		txfRating.setColumns(10);
		txfRating.setBounds(43, 132, 86, 20);
		mainPanel.add(txfRating);

		txfLastUpdate = new JTextField();
		txfLastUpdate.setEditable(false);
		txfLastUpdate.setColumns(10);
		txfLastUpdate.setBounds(193, 132, 159, 20);
		mainPanel.add(txfLastUpdate);

		txfSpecFeat = new JTextField();
		txfSpecFeat.setEditable(false);
		txfSpecFeat.setColumns(10);
		txfSpecFeat.setBounds(395, 132, 313, 20);
		mainPanel.add(txfSpecFeat);

		txfRentDur = new JTextField();
		txfRentDur.setEditable(false);
		txfRentDur.setColumns(10);
		txfRentDur.setBounds(43, 208, 86, 20);
		mainPanel.add(txfRentDur);

		txfRentRate = new JTextField();
		txfRentRate.setEditable(false);
		txfRentRate.setColumns(10);
		txfRentRate.setBounds(193, 208, 86, 20);
		mainPanel.add(txfRentRate);

		txfReplCost = new JTextField();
		txfReplCost.setEditable(false);
		txfReplCost.setColumns(10);
		txfReplCost.setBounds(395, 208, 86, 20);
		mainPanel.add(txfReplCost);

		txaActors = new JTextArea();
		txaActors.setLineWrap(true);
		txaActors.setEditable(false);
		txaActors.setBounds(43, 288, 873, 64);
		mainPanel.add(txaActors);

		txaDescr = new JTextArea();
		txaDescr.setLineWrap(true);
		txaDescr.setEditable(false);
		txaDescr.setBounds(43, 408, 873, 103);
		mainPanel.add(txaDescr);

		btnFirst = new JButton("Primero");
		btnFirst.setBounds(43, 591, 89, 23);
		btnFirst.setEnabled(false);
		mainPanel.add(btnFirst);

		btnPrev = new JButton("Anterior");
		btnPrev.setBounds(226, 591, 89, 23);
		btnPrev.setEnabled(false);
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
		btnNew.setBounds(795, 131, 121, 23);
		mainPanel.add(btnNew);

		btnSave = new JButton("Guardar");
		btnSave.setVisible(false);
		btnSave.setBounds(795, 207, 121, 23);
		mainPanel.add(btnSave);

		btnCancel = new JButton("Cancelar");
		btnCancel.setVisible(false);
		btnCancel.setBounds(587, 207, 121, 23);
		mainPanel.add(btnCancel);
	}

	private void setUIbehaviour() {
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					films.first();
					btnFirst.setEnabled(false);
					btnPrev.setEnabled(btnFirst.isEnabled());
					btnLast.setEnabled(true);
					btnNext.setEnabled(btnLast.isEnabled());
					fillText();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					films.previous();
					btnNext.setEnabled(true);
					btnLast.setEnabled(true);
					if (films.isFirst()) {
						btnFirst.setEnabled(false);
						btnPrev.setEnabled(false);
					}
					fillText();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					films.next();
					btnPrev.setEnabled(true);
					btnFirst.setEnabled(true);
					if (films.isLast()) {
						btnLast.setEnabled(false);
						btnNext.setEnabled(false);
					}
					fillText();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					films.last();
					btnFirst.setEnabled(true);
					btnPrev.setEnabled(btnFirst.isEnabled());
					btnLast.setEnabled(false);
					btnNext.setEnabled(btnLast.isEnabled());
					fillText();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew.setVisible(false);
				opt = false;
				switchButtonsEdit();
				switchButtonsMovement();
				switchEditText();
			}
		});

		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setVisible(false);
				opt = true;
				clearText();
				switchButtonsEdit();
				switchButtonsMovement();
				switchEditText();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = txfTitle.getText(), rentDur = txfRentDur.getText(), rentRate = txfRentRate.getText(),
						replCost = txfReplCost.getText(),
						length = txfLength.getText().isBlank() ? "0" : txfLength.getText(),
						releaseYear = txfReleYear.getText().isBlank() ? "0" : txfReleYear.getText(),
						empties = "Faltan los siguientes campos: \n\n";
				String[][] mustHave = { { title, "Titulo" }, { rentDur, "Duracion alquiler" },
						{ rentRate, "Coste de alquiler" }, { replCost, "Coste de reemplazo" } };

				if (title.isBlank() || rentDur.isBlank() || rentRate.isBlank() || replCost.isBlank()) {
					for (int i = 0; i < mustHave.length; i++) {
						if (mustHave[i][0].isBlank())
							empties += mustHave[i][1] + "\n";
					}

					JOptionPane.showMessageDialog(frmPeliculasDeSakila, empties);
				} else {
					FilmDAO fdao = null;
					try {
						fdao = new FilmDAO();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					if (opt) {
						boolean correct = false;
						try {
							films.moveToInsertRow();
							films.updateString("title", title);
							films.updateString("description", txaDescr.getText());
							films.updateInt("release_year", Integer.parseInt(releaseYear));
							films.updateDouble("rental_duration", Double.parseDouble(rentDur));
							films.updateDouble("rental_rate", Double.parseDouble(rentRate));
							films.updateInt("length", Integer.parseInt(length));
							films.updateDouble("replacement_cost", Double.parseDouble(replCost));
							films.updateInt("language_id", 1);
							films.insertRow();
						} catch (SQLException e2) {
							e2.printStackTrace();
							correct = false;
						} finally {
							correct = true;
						}

						if (correct)
							JOptionPane.showMessageDialog(frmPeliculasDeSakila, "Insertado correctamente");
						else
							JOptionPane.showMessageDialog(frmPeliculasDeSakila,
									"Algo ha pasado, contacta al administrador");

//						if (fdao.insertFilm(txfTitle.getText(), txaDescr.getText(), txfReleYear.getText(),
//								txfLength.getText(), txfRentDur.getText(), txfRentRate.getText(),
//								txfReplCost.getText()))
////						else
						try {
							films = fdao.getFilms();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							if (fdao.updateFilm(films.getInt(1), title, txaDescr.getText(), txfReleYear.getText(),
									txfLength.getText(), rentDur, rentRate, replCost))
								JOptionPane.showMessageDialog(frmPeliculasDeSakila, "Actualizado correctamente");
							else
								JOptionPane.showMessageDialog(frmPeliculasDeSakila,
										"Algo ha pasado, contacta al administrador");
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setVisible(true);
				btnNew.setVisible(true);
				switchButtonsEdit();
				switchButtonsMovement();
				switchEditText();
				getFilms();
				try {
					fillText();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				btnPrev.setEnabled(false);
				btnFirst.setEnabled(false);
			}
		});
	}

	private void getFilms() {
		FilmDAO fdao = null;
		try {
			fdao = new FilmDAO();
			films = fdao.getFilms();
			films.next();
		} catch (SQLException e) {
			txaDescr.setText("Error de conexión a la base de datos");
			e.printStackTrace();
		}
	}

	private void fillText() throws SQLException {
		ActorDAO aDao = new ActorDAO();
		ResultSet actors = aDao.getActor(films.getInt("film_id"));
		String actorsTxt = "";

		txfTitle.setText(films.getString("title"));
		txfReleYear.setText(Integer.toString(films.getInt("release_year")));
		txfLength.setText(Integer.toString(films.getInt("length")));
		txfRating.setText(films.getString("rating"));
		txfLastUpdate.setText(films.getString("last_update"));
		txfSpecFeat.setText(films.getString("special_features"));
		txfRentDur.setText(Integer.toString(films.getInt("rental_duration")));
		txfRentRate.setText(Double.toString(films.getDouble("rental_rate")));
		txfReplCost.setText(Double.toString(films.getDouble("replacement_cost")));
		txaDescr.setText(films.getString("description"));

		while (actors.next()) {
			if (actors.isLast())
				actorsTxt += actors.getString(1);
			else
				actorsTxt += actors.getString(1) + ", ";
		}
		txaActors.setText(actorsTxt);
	}

	private void switchButtonsEdit() {
		btnEdit.setEnabled(!btnEdit.isEnabled());
		btnNew.setEnabled(!btnNew.isEnabled());
		btnSave.setVisible(!btnSave.isVisible());
		btnCancel.setVisible(!btnCancel.isVisible());
	}

	private void switchButtonsMovement() {
		btnFirst.setVisible(!btnFirst.isVisible());
		btnPrev.setVisible(!btnPrev.isVisible());
		btnNext.setVisible(!btnNext.isVisible());
		btnLast.setVisible(!btnLast.isVisible());
	}

	private void switchEditText() {
		txfTitle.setEditable(!txfTitle.isEditable());
		txfReleYear.setEditable(!txfReleYear.isEditable());
		txfLength.setEditable(!txfLength.isEditable());
		txfRentDur.setEditable(!txfRentDur.isEditable());
		txfRentRate.setEditable(!txfRentRate.isEditable());
		txfReplCost.setEditable(!txfReplCost.isEditable());
		txaDescr.setEditable(!txaDescr.isEditable());
	}

	private void clearText() {
		txfTitle.setText("");
		txfReleYear.setText("");
		txfLength.setText("");
		txfRating.setText("");
		txfLastUpdate.setText("");
		txfRentDur.setText("");
		txfRentRate.setText("");
		txfReplCost.setText("");
		txfSpecFeat.setText("");
		txaActors.setText("");
		txaDescr.setText("");
	}
}
