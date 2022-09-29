package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow {
	private enum Type {
		ALL, CSV, DAT
	}

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
	private Component vgMiscVB;
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
	private Component horizontalGlue;
	private Component hgMisc;

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
		behaviour();
	}
//	jtextpaint + scroll

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
		
		horizontalGlue = Box.createHorizontalGlue();
		hbFiles2_1.add(horizontalGlue);

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

		vgMiscVB = Box.createVerticalGlue();
		vbMisc.add(vgMiscVB);

		hsMisc = Box.createHorizontalStrut(30);
		misc.add(hsMisc);
		
		hgMisc = Box.createHorizontalGlue();
		misc.add(hgMisc);
	}

	private void behaviour() {
		fileList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String file = fileList.getSelectedValue(), folder = getFolder(file), linea = "No disponible";

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

				} else {
					txpPreview.setText(linea);
				}

				frame.repaint();
				frame.revalidate();
			}
		});
	}

	private void populateFiles(Type tipo) {
		String csvPath = "src/main/resources/CSV", datPath = "src/main/resources/DAT";
		switch (tipo) {
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

	private String getFolder(String file) {
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

	private void populatePreview() {

	}
}
