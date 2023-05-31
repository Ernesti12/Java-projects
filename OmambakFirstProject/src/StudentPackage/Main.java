package StudentPackage;

import java.io.*;
import java.util.*;

public class Main {
		Main() throws IOException{
		
		}
	public static void main(String[] args) throws IOException {
		new Main();
	}

	public void updateRecord() {
			
		}
	public void enterRecord() throws IOException {
		File file = new File("C://StudentFile.dat");
		PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
		if(!file.exists()) {
			file.createNewFile();
			
		}
		
		Scanner scanner = new Scanner(System.in);

		String[] id = new String[20];
		String[] lastName = new String[20];
		String[] firstName = new String[20];
		char[] middleInitial = new char[20];
		int[] age = new int[20];
		String[] gender = new String[20];
		String[] course = new String[20];
		int[] year = new int[20];
		String[] maritalStatus = new String[20];
		String[] enrollmentStatus = new String[20];
		
		String answer;
	
		for(int i = 0; i < age.length; i++) {
			do {
			System.out.print("Enter the Student's ID: ");
			id[i] = scanner.next();
			
			System.out.print("Enter the Student's Last Name: ");
			lastName[i] = scanner.next();

			System.out.print("Enter the Student First Name: ");
			firstName[i] = scanner.next();
			scanner.next();

			System.out.print("Enter the Student's Middle Initial: ");
			middleInitial[i] = scanner.next().charAt(0);
			
			System.out.print("Enter the Student's age: ");
			age[i] = scanner.nextInt();
			
			System.out.print("Enter the Student's gender: ");
			gender[i] = scanner.next();
			
			System.out.print("Enter the Student's course: ");
			course[i] = scanner.next();
			
			System.out.print("Enter the Student's year level: ");
			year[i] = scanner.nextInt();
			
			System.out.print("Enter the Student's Marital Status: ");
			maritalStatus[i] = scanner.next();
			
			System.out.print("Enter the Student's Enrollment Status: ");
			enrollmentStatus[i] = scanner.next(); 
			
			System.out.println("Do you want to Enter another Student info? ");
			answer = scanner.next();
		}while(answer.equals("YES") || answer.equals("yes"));
			break;
			
		}
		for(int j=0;j < age.length; j++) {
			System.out.println("Student ID: "+id[j]);
			pw.println("Student ID: "+id[j]);
			System.out.println("Student Last Name: "+lastName[j]);
			pw.println("Student Last Name: "+lastName[j]);
			System.out.println("Student First Name: "+firstName[j]);
			pw.println("Student First Name: "+firstName[j]);
			System.out.println("Student Middle Initial: "+middleInitial[j]);
			pw.println("Student Middle Initial: "+middleInitial[j]);
			System.out.println("Student Full Name: "+lastName[j]+", "+firstName[j]+" "+middleInitial[j]+".");
			pw.println("Student Full Name: "+lastName[j]+", "+firstName[j]+" "+middleInitial[j]+".");
			System.out.println("Student Age: "+age[j]);
			pw.println("Student Age: "+age[j]);
			System.out.println("Student Gender: "+gender[j]);
			pw.println("Student Gender: "+gender[j]);
			System.out.println("Student Course: "+course[j]);
			pw.println("Student Course: "+course[j]);
			System.out.println("Student Year: "+year[j]);
			pw.println("Student Year: "+year[j]);
			System.out.println("Student Marital Status: "+maritalStatus[j]);
			pw.println("Student Marital Status: "+maritalStatus[j]);
			System.out.println("Student Enrollment Status: "+enrollmentStatus[j]);
			pw.println("Student Enrollment Status: "+enrollmentStatus[j]);
		}
		pw.close();
	}
		
	
	}

