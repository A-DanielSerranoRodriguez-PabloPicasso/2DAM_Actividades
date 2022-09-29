package ui;

import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;

public class MainWindow {
	private enum Type {
		ALL, CSV, DAT
	}

	String[] filesName;

	private JFrame frame;
	private JList<String> fileList;
	JScrollPane scrollPane;
	private JPanel panel;

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
		frame.setBounds(100, 100, 693, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		components();
	}
//	jtextpaint + scroll

	private void components() {
		populateFiles(Type.ALL);
		fileList = new JList(filesName);
		fileList.setLayoutOrientation(JList.VERTICAL);
//		frame.getContentPane().add(fileList);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(fileList);
		frame.getContentPane().add(scrollPane);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
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

		}
			break;
		case CSV: {
			File csv = new File(csvPath);
			String[] csvList = csv.list();
			int csvTotal = csvList.length;
			filesName = new String[csvTotal];

			for (int i = 0; i < csvTotal - 1; i++)
				filesName[i] = csvList[i];

		}
			break;
		case DAT: {
			File dat = new File(datPath);
			String[] datList = dat.list();
			int datTotal = datList.length;
			filesName = new String[datTotal];

			for (int i = 0; i < datTotal; i++)
				filesName[i] = datList[i];

		}
			break;
		}
	}

}
