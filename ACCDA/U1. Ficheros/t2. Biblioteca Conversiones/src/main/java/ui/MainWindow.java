package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.Binario;
import utils.CSV;

public class MainWindow {
	/**
	 * Filter for the files. Currently not implemented
	 * 
	 * @author Daniel Serrano Rodriguez
	 *
	 */
	private enum Type {
		ALL, CSV, DAT
	}

	// Files for the list
	String[] filesName;

	private JFrame frame;
	private JList<String> fileList;
	JScrollPane listScroll;
	private JPanel misc;
	private JPanel files;
	private JScrollPane documentScroll;
	private JTextPane txpPreview;
	private Component hsMisc;
	private Box vbMisc;
	private Component vg1MiscVB;
	private Component vsMiscVB;
	private Box hbFiles2;
	private Box hbFiles1;
	private Component vs1Files;
	private Component vs1FilesHB1;
	private Component hs1FilesHB1;
	private JButton btnLoad;
	private Component hs2FilesHB1;
	private JButton btnDelete;
	private Component hs1FilesHB2;
	private Component vs2Files;
	private Component hsFilesHB1;
	private Component hgFilesHB;
	private Component hs2FilesHB2;
	private Box hbFiles2_1;
	private Component vg2MiscVB;
	private Box hbMiscVBcsv;
	private Component vg3MiscVB;
	private Box vbMiscVBdat;
	private Box hb1MiscVBdat;
	private Component vsMiscVBdat;
	private Box hb2MiscVBdat;
	private JButton btnCsvToDat;
	private Component hsCSV;
	private JButton btnCsvOrd;
	private Component vs1MiscVB;
	private Component vs2MiscVB;
	private JButton btnDatToCsv;
	private Component hsDat;
	private JButton btnDatOrd;
	private JButton btnDatToCsvOrd;
	private JFileChooser fileChooser;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frame.repaint();
		frame.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 930, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		components();
		behavior();
	}

	/**
	 * Creates and puts the components in the panel
	 */
	private void components() {
		populateFiles(Type.ALL);

		files = new JPanel();
		frame.getContentPane().add(files);
		files.setLayout(new BoxLayout(files, BoxLayout.Y_AXIS));
		files.setAlignmentX(Component.LEFT_ALIGNMENT);

		vs1Files = Box.createVerticalStrut(20);
		files.add(vs1Files);

		hbFiles1 = Box.createHorizontalBox();
		files.add(hbFiles1);

		hs1FilesHB1 = Box.createHorizontalStrut(20);
		hs1FilesHB1.setMaximumSize(new Dimension(20, 0));
		hbFiles1.add(hs1FilesHB1);

		btnLoad = new JButton("Cargar");
		hbFiles1.add(btnLoad);

		hs2FilesHB1 = Box.createHorizontalStrut(20);
		hs2FilesHB1.setMaximumSize(new Dimension(20, 0));
		hbFiles1.add(hs2FilesHB1);

		btnDelete = new JButton("Eliminar");
		hbFiles1.add(btnDelete);

		hsFilesHB1 = Box.createHorizontalStrut(20);
		hsFilesHB1.setMaximumSize(new Dimension(20, 0));
		hbFiles1.add(hsFilesHB1);

		hgFilesHB = Box.createHorizontalGlue();
		hbFiles1.add(hgFilesHB);

		vs1FilesHB1 = Box.createVerticalStrut(20);
		files.add(vs1FilesHB1);

		hbFiles2_1 = Box.createHorizontalBox();
		files.add(hbFiles2_1);

		hbFiles2 = Box.createHorizontalBox();
		hbFiles2_1.add(hbFiles2);

		hs1FilesHB2 = Box.createHorizontalStrut(20);
		hbFiles2.add(hs1FilesHB2);
		// Remove <String> to be able to show it in Window Builder
		fileList = new JList(filesName);
		fileList.setLayoutOrientation(JList.VERTICAL);

		listScroll = new JScrollPane();
		listScroll.setMinimumSize(new Dimension(200, 200));
		listScroll.setMaximumSize(new Dimension(1000, 1000));
		hbFiles2.add(listScroll);
		listScroll.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		listScroll.setViewportView(fileList);

		hs2FilesHB2 = Box.createHorizontalStrut(20);
		hbFiles2.add(hs2FilesHB2);

		vs2Files = Box.createVerticalStrut(20);
		files.add(vs2Files);

		misc = new JPanel();
		frame.getContentPane().add(misc);
		misc.setLayout(new BoxLayout(misc, BoxLayout.X_AXIS));

		vbMisc = Box.createVerticalBox();
		misc.add(vbMisc);

		vsMiscVB = Box.createVerticalStrut(20);
		vbMisc.add(vsMiscVB);

		documentScroll = new JScrollPane();
		vbMisc.add(documentScroll);

		txpPreview = new JTextPane();
		txpPreview.setEditable(false);
		documentScroll.setViewportView(txpPreview);

		vg1MiscVB = Box.createVerticalGlue();
		vbMisc.add(vg1MiscVB);

		vs1MiscVB = Box.createVerticalStrut(20);
		vbMisc.add(vs1MiscVB);

		hbMiscVBcsv = Box.createHorizontalBox();
		hbMiscVBcsv.setVisible(false);
		vbMisc.add(hbMiscVBcsv);

		btnCsvToDat = new JButton("CSV a Binario");
		hbMiscVBcsv.add(btnCsvToDat);

		hsCSV = Box.createHorizontalStrut(20);
		hbMiscVBcsv.add(hsCSV);

		btnCsvOrd = new JButton("Ordenar CSV");
		hbMiscVBcsv.add(btnCsvOrd);

		vg2MiscVB = Box.createVerticalGlue();
		vbMisc.add(vg2MiscVB);

		vbMiscVBdat = Box.createVerticalBox();
		vbMiscVBdat.setVisible(false);
		vbMisc.add(vbMiscVBdat);

		hb1MiscVBdat = Box.createHorizontalBox();
		vbMiscVBdat.add(hb1MiscVBdat);

		btnDatToCsv = new JButton("Binario a CSV");
		hb1MiscVBdat.add(btnDatToCsv);

		hsDat = Box.createHorizontalStrut(20);
		hb1MiscVBdat.add(hsDat);

		btnDatOrd = new JButton("Ordenar Binario");
		hb1MiscVBdat.add(btnDatOrd);

		vsMiscVBdat = Box.createVerticalStrut(20);
		vbMiscVBdat.add(vsMiscVBdat);

		hb2MiscVBdat = Box.createHorizontalBox();
		vbMiscVBdat.add(hb2MiscVBdat);

		btnDatToCsvOrd = new JButton("Binario a CSV ordenado");
		hb2MiscVBdat.add(btnDatToCsvOrd);

		vg3MiscVB = Box.createVerticalGlue();
		vbMisc.add(vg3MiscVB);

		vs2MiscVB = Box.createVerticalStrut(20);
		vbMisc.add(vs2MiscVB);

		hsMisc = Box.createHorizontalStrut(30);
		misc.add(hsMisc);

		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo Binario", "dat"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo CSV", "csv"));
		fileChooser.setAcceptAllFileFilterUsed(false);
	}

	/**
	 * Sets the behavior of the components
	 */
	private void behavior() {
		/**
		 * When a component of the list is selected, updates components of the panel
		 */
		fileList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file), linea = "No disponible";

				// If its a CSV, writes its content in the preview panel and shows the buttons
				// of the CSV operations
				if (folder.equals("CSV")) {
					String path = "src/main/resources/" + folder + "/", texto = "";
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(path + file));

						while ((linea = br.readLine()) != null) {
							texto += linea + "\n";
						}
						txpPreview.setText(texto);

						br.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					hbMiscVBcsv.setVisible(true);
					if (vbMiscVBdat.isVisible())
						vbMiscVBdat.setVisible(false);
				} else {
					// If its a Binary, defaults the preview and shows the buttons of the Binary
					// operations
					txpPreview.setText(linea);
					vbMiscVBdat.setVisible(true);
					if (hbMiscVBcsv.isVisible())
						hbMiscVBcsv.setVisible(false);
				}

				reloadView();
			}
		});

		/**
		 * When clicked, the buttons opens a file chooser
		 */
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int menu = fileChooser.showSaveDialog(null);

				// If file is chosen, its copied to the correct folder
				if (menu == JFileChooser.APPROVE_OPTION) {
					String fileName = fileChooser.getSelectedFile().getName();
					File newFile;
					if (fileName.endsWith(".csv")) {
						newFile = new File("src/main/resources/CSV/" + fileName);
						try {
							Files.copy(fileChooser.getSelectedFile().toPath(), newFile.toPath());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else if (fileName.endsWith(".dat")) {
						newFile = new File("src/main/resources/DAT/" + fileName);
						try {
							Files.copy(fileChooser.getSelectedFile().toPath(), newFile.toPath());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}

				restartView();
			}
		});

		/**
		 * When clicked, deletes the selected file
		 */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file);
				String path = "src/main/resources/" + folder + "/" + file;

				new File(path).delete();

				restartView();
			}
		});

		/**
		 * When clicked, turns the CSV to a Binary file
		 */
		btnCsvToDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file);
				String path = "src/main/resources/" + folder + "/" + file;

				CSV.fichero_CSV_to_Binario(path);

				restartView();
			}
		});

		/**
		 * When clicked, orders the CSV
		 */
		btnCsvOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file);
				String path = "src/main/resources/" + folder + "/" + file;

				CSV.ordenar_Archivo_CSV(path);

				restartView();
			}
		});

		/**
		 * When clicked, turns the Binary file to a CSV
		 */
		btnDatToCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file);
				String path = "src/main/resources/" + folder + "/" + file;

				Binario.fichero_Binario_to_CSV(path);

				restartView();
			}
		});

		/**
		 * When clicked, orders the Binary file
		 */
		btnDatOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file);
				String path = "src/main/resources/" + folder + "/" + file;

				Binario.ordenar_Archivo_Binario(path);

				restartView();
			}
		});

		/**
		 * When clicked, turns the Binary file to a ordered CSV
		 */
		btnDatToCsvOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file);
				String path = "src/main/resources/" + folder + "/" + file;

				Binario.fichero_Binario_to_CSV_ordenado(path);

				restartView();
			}
		});
	}

	/**
	 * Repaints the frame
	 */
	private void reloadView() {
		frame.repaint();
		frame.revalidate();
	}

	/**
	 * Destroys the current frame and creates a new one
	 */
	private void restartView() {
		new MainWindow();
		frame.dispose();
	}

	/**
	 * Populates the file list
	 * 
	 * @param tipo
	 */
	private void populateFiles(Type tipo) {
		String csvPath = "src/main/resources/CSV", datPath = "src/main/resources/DAT";
		// Checks the filter used
		switch (tipo) {
		// Obtains the file list of the folder and adds them to the panel list
		case ALL: {
			File csv = new File(csvPath), dat = new File(datPath);
			String[] csvList = csv.list(), datList = dat.list();
			int csvTotal = csvList.length, datTotal = datList.length;
			filesName = new String[csvTotal + datTotal];

			for (int i = 0; i < csvTotal; i++)
				filesName[i] = csvList[i];

			for (int i = 0; i < datTotal; i++)
				filesName[i + csvTotal] = datList[i];

			break;
		}
		case CSV: {
			File csv = new File(csvPath);
			String[] csvList = csv.list();
			int csvTotal = csvList.length;
			filesName = new String[csvTotal];

			for (int i = 0; i < csvTotal - 1; i++)
				filesName[i] = csvList[i];

			break;
		}
		case DAT: {
			File dat = new File(datPath);
			String[] datList = dat.list();
			int datTotal = datList.length;
			filesName = new String[datTotal];

			for (int i = 0; i < datTotal; i++)
				filesName[i] = datList[i];

			break;
		}
		}
	}

	/**
	 * Returns the correct folder for the file
	 * 
	 * @param file Absolute path of the file
	 * @return The correct folder
	 */
	private String getFolder(String file) {
		// Obtains the extension and 
		String extension = file.substring(file.lastIndexOf(".") + 1, file.length());
		switch (extension) {
		case "csv": {
			return "CSV";
		}
		case "dat": {
			return "DAT";
		}
		default: {
			return null;
		}
		}
	}

}
