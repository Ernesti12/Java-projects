package StudentPackage;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainFrame implements ActionListener, KeyListener {


	JFrame frame;
	JLabel title;

	JLabel title2;
	JPanel panel;
	JButton addData, updateData, removeData, viewStudent;
	JLabel id, lastName, firstName, middleInitial, age,
			gender, course, yearLevel, maritalS, enrollmentS;
	JTextField idf, lastNamef, firstNamef, middleInitialf,
			agef, genderf, coursef, yearLevelf, maritalSf,
			enrollmentSf, view;

	File file;
	FileWriter filewriter;
	PrintWriter pw;
	File file1;
	FileWriter filewriter1;
	PrintWriter pw1;

	JTable table;
	DefaultTableModel tableModel;

	public MainFrame() throws IOException {

		file = new File("Student.dat");
		filewriter = new FileWriter(file, true);
		pw = new PrintWriter(filewriter);

		file1 = new File("StudentOut.txt");
		filewriter1 = new FileWriter(file1, true);
		pw1 = new PrintWriter(filewriter1);

		frame = new JFrame();
		frame.setSize(1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.GRAY);

		String name = JOptionPane.showInputDialog(null,
				"Kindly Enter Your Name");

		title = new JLabel();
		title.setBounds(20, 30, 300, 50);
		title.setText("Welcome Mr/Mrs: " + name);
		title.setFont(new Font("Ink free", Font.BOLD, 20));

		title2 = new JLabel();
		title2.setBounds(400, 10, 300, 50);
		title2.setText("Student Info System");
		title2.setFont(new Font("Ink free", Font.BOLD, 25));

		//ID LABEL
		id = new JLabel("ID: ");
		id.setBounds(20, 80, 100, 30);
		id.setFont(new Font("Arial", Font.BOLD, 15));

		//ID JTEXTFIELD
		idf = new JTextField();
		idf.setBounds(120, 80, 250, 30);
		idf.setBorder(null);

		//LAST NAME LABEL
		lastName = new JLabel("Last Name: ");
		lastName.setBounds(20, 120, 100, 30);
		lastName.setFont(new Font("Arial", Font.BOLD, 15));

		//LAST NAME JTEXTFIELD
		lastNamef = new JTextField();
		lastNamef.setBounds(120, 120, 250, 30);
		lastNamef.setBorder(null);

		//FIRST NAME LABEL
		firstName = new JLabel("First Name: ");
		firstName.setBounds(20, 160, 100, 30);
		firstName.setFont(new Font("Arial", Font.BOLD, 15));

		//FIRST NAME JTEXTFIELD
		firstNamef = new JTextField();
		firstNamef.setBounds(120, 160, 250, 30);
		firstNamef.setBorder(null);

		//MIDDLE INITIAL LABEL
		middleInitial = new JLabel("Middle Initial: ");
		middleInitial.setBounds(20, 200, 100, 30);
		middleInitial.setFont(new Font("Arial", Font.BOLD, 15));

		//MIDLLE INITIAL JTEXTFIELD
		middleInitialf = new JTextField();
		middleInitialf.setBounds(120, 200, 250, 30);
		middleInitialf.setBorder(null);

		//AGE LABEL
		age = new JLabel("Age: ");
		age.setBounds(20, 240, 100, 30);
		age.setFont(new Font("Arial", Font.BOLD, 15));

		//AGE JTEXTFIELD
		agef = new JTextField();
		agef.setBounds(120, 240, 250, 30);
		agef.setBorder(null);

		//GENDER LABEL
		gender = new JLabel("Gender: ");
		gender.setBounds(600, 80, 100, 30);
		gender.setFont(new Font("Arial", Font.BOLD, 15));

		//GENDER JTEXTFIELD
		genderf = new JTextField();
		genderf.setBounds(750, 80, 250, 30);
		genderf.setBorder(null);

		//COURSE LABEL
		course = new JLabel("Course: ");
		course.setBounds(600, 120, 100, 30);
		course.setFont(new Font("Arial", Font.BOLD, 15));

		//COURSE JTEXTFIELD
		coursef = new JTextField();
		coursef.setBounds(750, 120, 250, 30);
		coursef.setBorder(null);
		coursef.addKeyListener(this);

		//YEAR LABEL
		yearLevel = new JLabel("Year Level: ");
		yearLevel.setBounds(600, 160, 100, 30);
		yearLevel.setFont(new Font("Arial", Font.BOLD, 15));

		//YEAR JTEXTFIELD
		yearLevelf = new JTextField();
		yearLevelf.setBounds(750, 160, 250, 30);
		yearLevelf.setBorder(null);

		//MARTIAL STATUS LABEL
		maritalS = new JLabel("Marital Status: ");
		maritalS.setBounds(600, 200, 150, 30);
		maritalS.setFont(new Font("Arial", Font.BOLD, 15));

		//MARTIAL STATUS JTEXTFIELD
		maritalSf = new JTextField();
		maritalSf.setBounds(750, 200, 250, 30);
		maritalSf.setBorder(null);

		//ENROLLMENTS LABEL
		enrollmentS = new JLabel("Enrollment Status: ");
		enrollmentS.setBounds(600, 240, 150, 30);
		enrollmentS.setFont(new Font("Arial", Font.BOLD, 15));

		//ENROLLMENTS JTEXTFIELD
		enrollmentSf = new JTextField();
		enrollmentSf.setBounds(750, 240, 250, 30);
		enrollmentSf.setBorder(null);

        //ADD DATA BUTTON
		addData = new JButton("Add Data");
		addData.setBounds(300, 300, 80, 30);
		addData.setBorder(null);
		addData.setBackground(Color.YELLOW);
		addData.addActionListener(this);

		//UPDATE DATA BUTTON
		updateData = new JButton("Update Data");
		updateData.setBounds(400, 300, 80, 30);
		updateData.setBorder(null);
		updateData.setBackground(Color.YELLOW);
		updateData.addActionListener(this);

		//REMOVE DATA BUTTON
		removeData = new JButton("Remove Data");
		removeData.setBounds(600, 300, 80, 30);
		removeData.setBorder(null);
		removeData.setBackground(Color.YELLOW);
		removeData.addActionListener(this);

		//VIEWSTUDENT BUTTON
		viewStudent = new JButton("Prepare Data");
		viewStudent.setBounds(500, 300, 80, 30);
		viewStudent.setBorder(null);
		viewStudent.setBackground(Color.YELLOW);
		viewStudent.addActionListener(this);

		//VIEW TEXTFIELD
		view = new JTextField();
		view.setBounds(700, 300, 100, 30);
		view.setBorder(null);

		Font font = view.getFont();
		font = font.deriveFont(Font.ITALIC);
		view.setFont(font);
		view.setForeground(Color.gray);
		view.setText("Search");
		view.addKeyListener(this);

		//TABLEMODEL
		String[] columnNames = { "Id", "Last Name", "First Name",
				"Middle Initial", "Age", "Gender", "Course",
				"Year Level", "Marital Status", "Enrollment Status" };
		Object[][] data = {};
		tableModel = new DefaultTableModel(data, columnNames);

		table = new JTable(tableModel);
		table.setSize(1080, 300);
		table.setRowHeight(15);
		table.setFont(new Font("Calibri", Font.BOLD, 10));

		JScrollPane scrollPane = new JScrollPane(table);

		panel = new JPanel(new BorderLayout(10, 10));
		panel.setBounds(10, 350, 1065, 250);

		panel.add(scrollPane);

		//ADD ALL TO FRAME
		frame.add(viewStudent);
		frame.add(view);
		frame.add(panel);
		frame.add(addData);
		frame.add(updateData);
		frame.add(removeData);
		frame.add(firstName);
		frame.add(firstNamef);
		frame.add(lastName);
		frame.add(lastNamef);
		frame.add(age);
		frame.add(agef);
		frame.add(course);
		frame.add(coursef);
		frame.add(gender);
		frame.add(genderf);
		frame.add(middleInitial);
		frame.add(middleInitialf);
		frame.add(yearLevel);
		frame.add(yearLevelf);
		frame.add(maritalS);
		frame.add(maritalSf);
		frame.add(enrollmentS);
		frame.add(enrollmentSf);
		frame.add(id);
		frame.add(idf);
		frame.add(title);
		frame.add(title2);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addData) {

			String[] data = { idf.getText(), lastNamef.getText(), firstNamef.getText(), middleInitialf.getText(),
					agef.getText(), genderf.getText(), coursef.getText(), yearLevelf.getText(), maritalSf.getText(),
					enrollmentSf.getText() };
			
			String id2 = idf.getText();
			String ls = lastNamef.getText();
			String fs = firstNamef.getText();
			String mi = middleInitialf.getText();
			String a = agef.getText();
			String g = genderf.getText();
			String c = coursef.getText();
			String yel = yearLevelf.getText();
			String ms = maritalSf.getText();
			String es = enrollmentSf.getText();

			// int year = Integer.parseInt(yearLevelf.getText());
			if (c.equals("BSIT") || c.equals("BSIS") || c.equals("BSA") || c.equals("BSC") || c.equals("BSED")) {
				int yl = Integer.parseInt(yel);
				if (yl >= 1 && yl <= 4) {
					tableModel.addRow(data);
					try {
						addStudent();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					idf.setText("");
					lastNamef.setText("");
					firstNamef.setText("");
					middleInitialf.setText("");
					agef.setText("");
					genderf.setText("");
					coursef.setText("");
					yearLevelf.setText("");
					maritalSf.setText("");
					enrollmentSf.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "This course is only upto 4 years!");
				}

			} else if (c.equals("BSCE") || c.equals("BSME") || c.equals("BSEE")) {
				int yl = Integer.parseInt(yel);
				if (yl >= 1 && yl <= 5) {
					tableModel.addRow(data);
					try {
						addStudent();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					idf.setText("");
					lastNamef.setText("");
					firstNamef.setText("");
					middleInitialf.setText("");
					agef.setText("");
					genderf.setText("");
					coursef.setText("");
					yearLevelf.setText("");
					maritalSf.setText("");
					enrollmentSf.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "This course is only upto 5 years!");
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "Please enter an existing course!");
			}

			// JOptionPane.showMessageDialog(null, "Data Added Successfully!");

		}
		if (e.getSource() == updateData) {
			tableModel = (DefaultTableModel) table.getModel();
			try {
				addStudent();
				updateRecord();
			} catch (IOException e1) {
				System.out.println("");
				//e1.printStackTrace();
			}

			if (table.getSelectedRowCount() == 1) {

				String id2 = idf.getText();
				String ls = lastNamef.getText();
				String fs = firstNamef.getText();
				String mi = middleInitialf.getText();
				String a = agef.getText();
				String g = genderf.getText();
				String c = coursef.getText();
				String yl = yearLevelf.getText();
				String ms = maritalSf.getText();
				String es = enrollmentSf.getText();

				tableModel.setValueAt(id2, table.getSelectedRow(), 0);
				tableModel.setValueAt(ls, table.getSelectedRow(), 1);
				tableModel.setValueAt(fs, table.getSelectedRow(), 2);
				tableModel.setValueAt(mi, table.getSelectedRow(), 3);
				tableModel.setValueAt(a, table.getSelectedRow(), 4);
				tableModel.setValueAt(g, table.getSelectedRow(), 5);
				tableModel.setValueAt(c, table.getSelectedRow(), 6);
				tableModel.setValueAt(yl, table.getSelectedRow(), 7);
				tableModel.setValueAt(ms, table.getSelectedRow(), 8);
				tableModel.setValueAt(es, table.getSelectedRow(), 9);

				JOptionPane.showMessageDialog(null, "Updated Succesfully");
				
			} else {
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is Empty");
				} else {
					JOptionPane.showMessageDialog(null, "Please select a Row");
				}
			}
		}

		if (e.getSource() == removeData) {
			try {
				removeRecord();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			DefaultTableModel tl = (DefaultTableModel) table.getModel();

			if (table.getSelectedRowCount() == 1) {
				tl.removeRow(table.getSelectedRow());
				JOptionPane.showMessageDialog(null, "The Data is successfully Remove!");
			} else {
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "The table is empty");

				} else {
					JOptionPane.showMessageDialog(null, "Please select a row!");
				}
			}
		}


		if (e.getSource() == viewStudent) {
			tableClicker();
			idf.setEnabled(false);
		}

	}

	public void addStudent() throws IOException {

		file = new File("Student.dat");
		filewriter = new FileWriter(file, true);
		pw = new PrintWriter(filewriter);

		file1 = new File("StudentOut.txt");
		filewriter1 = new FileWriter(file1, true);
		pw1 = new PrintWriter(filewriter1);

		pw.println("Student ID: " + idf.getText());
		pw.println("Student Last Name: " + lastNamef.getText());
		pw.println("Student First Name: " + firstNamef.getText());
		pw.println("Student Middle Initial: " + middleInitialf.getText());
		pw.println("Student Age: " + agef.getText());
		pw.println("Student Gender: " + genderf.getText());
		pw.println("Student Course: " + coursef.getText());
		pw.println("Student Year Level: " + yearLevelf.getText());
		pw.println("Student Marital Status: " + maritalSf.getText());
		pw.println("Student Enrollment Status:" + enrollmentSf.getText());
		pw.println("-------------------------------------------------------------------------------");

		pw1.println("Student ID: " + idf.getText());
		pw1.println("Student Last Name: " + lastNamef.getText());
		pw1.println("Student First Name: " + firstNamef.getText());
		pw1.println("Student Middle Initial: " + middleInitialf.getText());
		pw1.println("Student Age: " + agef.getText());
		pw1.println("Student Gender: " + genderf.getText());
		pw1.println("Student Course: " + coursef.getText());
		pw1.println("Student Year Level: " + yearLevelf.getText());
		pw1.println("Student Marital Status: " + maritalSf.getText());
		pw1.println("Student Enrollment Status:" + enrollmentSf.getText());
		pw1.println("-------------------------------------------------------------------------------");

		pw1.close();
		pw.close();
	}

	//REMOVE RECORD
	public void removeRecord() throws IOException {
		file1 = new File("Middle.txt");
		
		String tempFile = "StudentOut.txt";
		File oldFile = file1;
		File newFile = new File(tempFile);
		
		String remove = "Student ID: " + idf.getText()+"\nStudent Last Name: "
				+ lastNamef.getText()+"\nStudent First Name: " + firstNamef.getText()+
				"\nStudent Middle Initial: " + middleInitialf.getText()+"\nStudent Age: "
				+ agef.getText()+"\nStudent Gender: " + genderf.getText()+"\nStudent Course: "
				+ coursef.getText()+"\nStudent Year Level: " + yearLevelf.getText()+"" +
				"\nStudent Marital Status: " + maritalSf.getText()+"\nStudent Enrollment Status:"
				+ enrollmentSf.getText()+
				"\n-------------------------------------------------------------------------------";
		
		
		try {
			filewriter1 = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(filewriter1);
			pw1 = new PrintWriter(bw);

			String id2 = "";
			String ls = "";
			String fs = "";
			String mi = "";
			String a = "";
			String g = "";
			String c = "";
			String yl = "";
			String ms = "";
			String es = "";
			
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("[,\n]");
			while(scanner.hasNext()) {
				  id2 = scanner.next();
				  ls = scanner.next();
				  fs = scanner.next();
				  mi = scanner.next();
				  a = scanner.next();
				  g = scanner.next();
				  c = scanner.next();
				  yl = scanner.next();
				  ms = scanner.next();
				  es = scanner.next();
				  
				  if(!id2.equals(remove)){
					  pw1.println(id2+","+  ls +","+ fs +","+ mi +","
							  + a +","+ g+","+  c+","+  yl +","+ ms+","+  es);
				  }
				 
			}
			
			scanner.close();
			pw1.flush();
			pw1.close();
			oldFile.delete();
			File dump = file1;
			newFile.renameTo(dump);
			
		} catch (NoSuchElementException e) {
			System.out.println("");
			//e.printStackTrace();
		}
	}

	//UPDATE RECORD
	public void updateRecord() throws IOException {
		
		file1 = new File("Middle.txt");
		
		String tempFile = "StudentOut.txt";
		File oldFile = file1;
		File newFile = new File(tempFile);
		
		
		try {
			filewriter1 = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(filewriter);
			pw1 = new PrintWriter(bw);
			
			
			
			
			String id2 = "";
			String ls = "";
			String fs = "";
			String mi = "";
			String a = "";
			String g = "";
			String c = "";
			String yl = "";
			String ms = "";
			String es = "";
			
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("[,\n]");
			while(scanner.hasNext()) {
				  id2 = scanner.next();
				  ls = scanner.next();
				  fs = scanner.next();
				  mi = scanner.next();
				  a = scanner.next();
				  g = scanner.next();
				  c = scanner.next();
				  yl = scanner.next();
				  ms = scanner.next();
				  es = scanner.next();
				  
				  if(id2.equals(idf.getText())) {
					  pw1.println(idf.getText()+","+ lastNamef.getText()+","+
							  firstNamef.getText()+","+  middleInitialf.getText()+","+
								agef.getText()+","+  genderf.getText()+","+
							  coursef.getText()+","+  yearLevelf.getText()+","+
							  maritalSf.getText()+","+
								enrollmentSf.getText() );
				  }
				  else {
					  pw1.println(id2+","+  ls +","+ fs +","+ mi +","+ a +","+ g+","+  c+","+  yl +","+ ms+","+  es); 
				  }
			}
			
			
			pw1.flush();
			pw1.close();
			
		} catch (NoSuchElementException e) {
			System.out.println("");
			//e.printStackTrace();
		}
		
		
	}

	public void tableClicker() {
		tableModel = (DefaultTableModel) table.getModel();

		String id2 = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
		String ls = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
		String fs = tableModel.getValueAt(table.getSelectedRow(), 2).toString();
		String mi = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
		String a = tableModel.getValueAt(table.getSelectedRow(), 4).toString();
		String g = tableModel.getValueAt(table.getSelectedRow(), 5).toString();
		String c = tableModel.getValueAt(table.getSelectedRow(), 6).toString();
		String yl = tableModel.getValueAt(table.getSelectedRow(), 7).toString();
		String ms = tableModel.getValueAt(table.getSelectedRow(), 8).toString();
		String es = tableModel.getValueAt(table.getSelectedRow(), 9).toString();

		idf.setText(id2);
		lastNamef.setText(ls);
		firstNamef.setText(fs);
		middleInitialf.setText(mi);
		agef.setText(a);
		genderf.setText(g);
		coursef.setText(c);
		yearLevelf.setText(yl);
		maritalSf.setText(ms);
		enrollmentSf.setText(es);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String c = coursef.getText();
		int length = c.length();

		char a = e.getKeyChar();

		if (e.getKeyChar() >= 'B' && e.getKeyChar() <= 'T') {
			if (length < 4) {

			} else {
				coursef.setEditable(false);
				//JOptionPane.showMessageDialog(null, "You can only type up top 4 Characters!");
			}
		} else {
			if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
				coursef.setEditable(true);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == coursef) {
			String c = coursef.getText();
			int length = c.length();

			char a = e.getKeyChar();

			if (e.getKeyChar() >= '0' && e.getKeyChar() <= '0') {
				if (length < 4) {

				} else {
					coursef.setEditable(false);
				}
			} else {
				if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
					coursef.setEditable(true);
				}
			}
		}
		if (e.getSource() == yearLevelf) {

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		tableModel = (DefaultTableModel) table.getModel();

		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(view.getText().trim()));

	}
}
