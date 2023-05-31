import java.util.*;
import java.io.*;

public class projectBadon2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        final int SIZEARR = 100;
        int index = 0, choice;
        int[] age = new int[SIZEARR];
        int[] year = new int[SIZEARR];
        char[] MI = new char[SIZEARR];
        char[] gender = new char[SIZEARR];
        String[] IDnum = new String[SIZEARR];
        String[] FName = new String[SIZEARR];
        String[] LName = new String[SIZEARR];
        char[] Status1 = new char[SIZEARR];
        String[] Status2 = new String[SIZEARR];
        String[] course = new String[SIZEARR];

        Scanner inFile = new Scanner(new FileReader("studentdata.txt"));
        PrintWriter outFile = new PrintWriter("StudentOut.txt");
        while (index < SIZEARR && inFile.hasNext()) {
            IDnum[index] = inFile.next();
            LName[index] = inFile.next();
            FName[index] = inFile.next();
            MI[index] = inFile.next().charAt(0);
            age[index] = inFile.nextInt();
            gender[index] = inFile.next().charAt(0);
            course[index] = inFile.next();
            year[index] = inFile.nextInt();
            Status1[index] = inFile.next().charAt(0);
            Status2[index] = inFile.next();
            index++;
        }
        inFile.close();

        do {
            choice = menu();

            switch (choice) {
                case 1:
                    System.out.println("\nAdd New Student");
                    addStudent(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index);
                    index++;
                    break;
                case 2:
                    System.out.println("\nUpdate Record");
                    updateStudent(IDnum, LName, age, FName, course, gender, Status1, MI, Status2, year, index);
                    break;
                case 3:
                    System.out.println("\nRemove the Student");
                    System.out.println("1. By ID number");
                    System.out.println("2. By Last Name and First Name");
                    System.out.print("Enter your choice: ");
                    int removeChoice = sc.nextInt();
                    if (removeChoice == 1) {
                        System.out.print("Enter the ID number of the student to remove: ");
                        String removeID = sc.next();
                        removeStudentByID(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, removeID);
                        index--;
                    } else if (removeChoice == 2) {
                        System.out.print("Enter the Last Name of the student to remove: ");
                        String removeLastName = sc.next();
                        System.out.print("Enter the First Name of the student to remove: ");
                        String removeFirstName = sc.next();
                        removeStudentByFullName(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, removeLastName, removeFirstName);
                        index--;
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 4:
                    System.out.println("\nView Student");
                    viewStudent(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index);
                    break;
                default:
                    System.out.println("\nInvalid choice");
            }

        } while (choice >= 1 && choice <= 4);
        System.out.println("\nProgram terminated.");

        for (int i = 0; i < index; i++) {
            outFile.print(IDnum[i]);
            outFile.print("\t" + LName[i]);
            outFile.print("\t" + FName[i]);
            outFile.print("\t" + MI[i]);
            outFile.print("\t" + age[i]);
            outFile.print("\t" + gender[i]);
            outFile.print("\t" + course[i]);
            outFile.print("\t" + year[i]);
            outFile.print("\t" + Status1[i]);
            outFile.println("\t" + Status2[i]);
        }

        outFile.close();
    }

    public static int menu() {
        System.out.println("\nMENU" +"\n===================="+"\n1. Add New Student" + "\n2. Update Record" + "\n3. Remove the Student"
                + "\n4. View Student" +"\n===================="+ "\nEnter your choice: ");
        return sc.nextInt();
    }
    //MAO NI SA PAG ADD SA STUDENT
    public static void addStudent(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender,
                                  String[] course, int[] year, char[] Status1, String[] Status2, int index) {
        boolean check;
        System.out.print("\nInput ID number: ");
        String tempCode = sc.next();

        do {
            check = isDuplicate(IDnum, tempCode, index);
            if (check) {
                System.out.println("\nID number already exists. Input another.");
                tempCode = sc.next();
            } else
                break;
        } while (true);
        IDnum[index] = tempCode;

        System.out.print("\nInput First Name: ");
        FName[index] = sc.next();
        System.out.print("\nInput Last Name: ");
        LName[index] = sc.next();
        System.out.print("\nInput Middle Initial: ");
        MI[index] = sc.next().charAt(0);
        System.out.print("\nInput Age: ");
        age[index] = sc.nextInt();

        // E PANG CHECK KUNG PWEDE BA E INPUT
        boolean validCourse;
        do {
            System.out.print("\nInput Course: ");
            String inputCourse = sc.next();
            validCourse = isValidCourse(inputCourse);
            if (validCourse) {
                course[index] = inputCourse;
                break;
            } else {
                System.out.println("Invalid course. Please enter a valid course.");
            }
        } while (true);


        boolean validYear;
        do {
            System.out.print("\nInput Year: ");
            int inputYear = sc.nextInt();
            validYear = isValidYear(course[index], inputYear);
            if (validYear) {
                year[index] = inputYear;
                break;
            } else {
                System.out.println("Invalid year. Please enter a valid year for the chosen course.");
            }
        } while (true);


        boolean validGender;
        do {
            System.out.print("\nInput Gender (M/F): ");
            char inputGender = sc.next().charAt(0);
            validGender = isValidGender(inputGender);
            if (validGender) {
                gender[index] = inputGender;
                break;
            } else {
                System.out.println("Invalid gender. Please enter 'M' for Male or 'F' for Female.");
            }
        } while (true);


        boolean validStatus1;
        do {
            System.out.print("\nInput Marital Status (S/M): ");
            char inputStatus1 = sc.next().charAt(0);
            validStatus1 = isValidMaritalStatus(inputStatus1);
            if (validStatus1) {
                Status1[index] = inputStatus1;
                break;
            } else {
                System.out.println("Invalid marital status. Please enter 'S' for Single or 'M' for Married.");
            }
        } while (true);


        boolean validStatus2;
        do {
            System.out.print("\nInput Enrollment Status (EN/NE): ");
            String inputStatus2 = sc.next();
            validStatus2 = isValidEnrollmentStatus(inputStatus2);
            if (validStatus2) {
                Status2[index] = inputStatus2;
                break;
            } else {
                System.out.println("Invalid enrollment status. Please enter 'EN' for Enrolled or 'NE' for Not Enrolled.");
            }
        } while (true);
    }

    // PAG CHECK IF WALA GA BALIK BALIK ANG ID NUM
    public static boolean isDuplicate(String[] IDnum, String tempCode, int index) {
        for (int i = 0; i < index; i++) {
            if (tempCode.equals(IDnum[i]))
                return true;
        }
        return false;
    }
    // PAG ILIS SA MGA INFORMATION SA STUDENT
    public static void updateStudent(String[] IDnum, String[] LName, int[] age, String[] FName, String[] course,
                                     char[] gender, char[] Status1, char[] MI, String[] Status2, int[] year, int index) {
        System.out.print("\nInput item code to be updated: ");
        String tempCode = sc.next();
        boolean found = false;

        for (int i = 0; i < index; i++) {
            if (tempCode.equals(IDnum[i])) {
                found = true;

                System.out.print("\nInput New First Name: ");
                FName[i] = sc.next();
                System.out.print("\nInput New Last Name: ");
                LName[i] = sc.next();
                System.out.print("\nInput New Middle Initial: ");
                MI[i] = sc.next().charAt(0);
                System.out.print("\nInput New Age: ");
                age[i] = sc.nextInt();

                // PAG CHECK IF OK BANG GIPANG INPUT
                boolean validCourse;
                do {
                    System.out.print("\nInput New Course: ");
                    String inputCourse = sc.next();
                    validCourse = isValidCourse(inputCourse);
                    if (validCourse) {
                        course[i] = inputCourse;
                        break;
                    } else {
                        System.out.println("Invalid course. Please enter a valid course.");
                    }
                } while (true);


                boolean validYear;
                do {
                    System.out.print("\nInput New Year: ");
                    int inputYear = sc.nextInt();
                    validYear = isValidYear(course[i], inputYear);
                    if (validYear) {
                        year[i] = inputYear;
                        break;
                    } else {
                        System.out.println("Invalid year. Please enter a valid year for the chosen course.");
                    }
                } while (true);


                boolean validGender;
                do {
                    System.out.print("\nInput New Gender (M/F): ");
                    char inputGender = sc.next().charAt(0);
                    validGender = isValidGender(inputGender);
                    if (validGender) {
                        gender[i] = inputGender;
                        break;
                    } else {
                        System.out.println("Invalid gender. Please enter 'M' for Male or 'F' for Female.");
                    }
                } while (true);


                boolean validStatus1;
                do {
                    System.out.print("\nInput New Marital Status (S/M): ");
                    char inputStatus1 = sc.next().charAt(0);
                    validStatus1 = isValidMaritalStatus(inputStatus1);
                    if (validStatus1) {
                        Status1[i] = inputStatus1;
                        break;
                    } else {
                        System.out.println("Invalid marital status. Please enter 'S' for Single or 'M' for Married.");
                    }
                } while (true);


                boolean validStatus2;
                do {
                    System.out.print("\nInput New Enrollment Status (EN/NE): ");
                    String inputStatus2 = sc.next();
                    validStatus2 = isValidEnrollmentStatus(inputStatus2);
                    if (validStatus2) {
                        Status2[i] = inputStatus2;
                        break;
                    } else {
                        System.out.println("Invalid enrollment status. Please enter 'EN' for Enrolled or 'NE' for Not Enrolled.");
                    }
                } while (true);
            }
        }

        if (!found) {
            System.out.println("Item code not found.");
        }
    }
    // MGA CONDITION
    public static boolean isValidCourse(String course) {
        String[] validCourses = {"BSIS", "BSIT", "BSA", "BSC", "BSED", "BSCE", "BSME", "BSEE"};
        for (String validCourse : validCourses) {
            if (validCourse.equals(course))
                return true;
        }
        return false;
    }

    public static boolean isValidYear(String course, int year) {
        if (year >= 1 && year <= 4) {
            return true;
        } else if (year == 5 && (course.equals("BSCE") || course.equals("BSME") || course.equals("BSEE"))) {
            return true;
        }
        return false;
    }

    public static boolean isValidGender(char gender) {
        return gender == 'M' || gender == 'F';
    }

    public static boolean isValidMaritalStatus(char status) {
        return status == 'S' || status == 'M';
    }

    public static boolean isValidEnrollmentStatus(String status) {
        return status.equals("EN") || status.equals("NE");
    }
    //PAG REMOVE SA STUDENT
    public static void removeStudentByID(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String removeID) {
        int removeIndex = -1;
        for (int i = 0; i < index; i++) {
            if (IDnum[i].equals(removeID)) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex != -1) {
            // PAG MOVE SA MGA ELEMENT AFTER PAG REMOVE
            for (int i = removeIndex; i < index - 1; i++) {
                IDnum[i] = IDnum[i + 1];
                LName[i] = LName[i + 1];
                FName[i] = FName[i + 1];
                MI[i] = MI[i + 1];
                age[i] = age[i + 1];
                gender[i] = gender[i + 1];
                course[i] = course[i + 1];
                year[i] = year[i + 1];
                Status1[i] = Status1[i + 1];
                Status2[i] = Status2[i + 1];
            }

            //E LIMPYO ANG LAST ELEMENT
            IDnum[index - 1] = null;
            LName[index - 1] = null;
            FName[index - 1] = null;
            MI[index - 1] = '\0';
            age[index - 1] = 0;
            gender[index - 1] = '\0';
            course[index - 1] = null;
            year[index - 1] = 0;
            Status1[index - 1] = '\0';
            Status2[index - 1] = null;

            System.out.println("Student with ID number " + removeID + " has been removed.");
        } else {
            System.out.println("Student with ID number " + removeID + " not found.");
        }
    }
    //PAG REMMOVE SA STUDENT GAMIT IYA PANGAN
    public static void removeStudentByFullName(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String removeLastName, String removeFirstName) {
        int removeIndex = -1;
        for (int i = 0; i < index; i++) {
            if (LName[i].equals(removeLastName) && FName[i].equals(removeFirstName)) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex != -1) {
            // ANG PAG MOVE SA MGA ELEMENTS AFTER PAG DELETE
            for (int i = removeIndex; i < index - 1; i++) {
                IDnum[i] = IDnum[i + 1];
                LName[i] = LName[i + 1];
                FName[i] = FName[i + 1];
                MI[i] = MI[i + 1];
                age[i] = age[i + 1];
                gender[i] = gender[i + 1];
                course[i] = course[i + 1];
                year[i] = year[i + 1];
                Status1[i] = Status1[i + 1];
                Status2[i] = Status2[i + 1];
            }

            // E LIMPYO ANG LAST ELEMENT SA ARRAY
            IDnum[index - 1] = null;
            LName[index - 1] = null;
            FName[index - 1] = null;
            MI[index - 1] = '\0';
            age[index - 1] = 0;
            gender[index - 1] = '\0';
            course[index - 1] = null;
            year[index - 1] = 0;
            Status1[index - 1] = '\0';
            Status2[index - 1] = null;

            System.out.println("Student with Last Name " + removeLastName + " and First Name " + removeFirstName + " has been removed.");
        } else {
            System.out.println("Student with Last Name " + removeLastName + " and First Name " + removeFirstName + " not found.");
        }
    }
    public static void viewStudent(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index) {
        int viewChoice;
        System.out.println("\nVIEW STUDENT INFORMATION");
        System.out.println("========================");
        System.out.println("[1] By ID number");
        System.out.println("[2] By Family Name");
        System.out.println("[3] By Course");
        System.out.println("[4] By Course and Year");
        System.out.println("[5] By Course and Gender");
        System.out.println("[6] By Enrollment Status");
        System.out.println("[7] By Marital Status");
        System.out.println("[8] By Enrollment Status and Course");
        System.out.println("[9] By Marital Status and Course");
        System.out.println("[10] By Course, Year, and Enrollment Status");
        System.out.print("Enter your choice: ");
        viewChoice = sc.nextInt();

        switch (viewChoice) {
            case 1:
                System.out.print("Enter the ID number of the student: ");
                String viewID = sc.next();
                viewStudentByID(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewID);
                break;
            case 2:
                System.out.print("Enter the family name of the student: ");
                String viewLastName = sc.next();
                viewStudentByLastName(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewLastName);
                break;
            case 3:
                System.out.print("Enter the course: ");
                String viewCourse = sc.next();
                viewStudentByCourse(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewCourse);
                break;
            case 4:
                System.out.print("Enter the course: ");
                String viewCourseByYear = sc.next();
                System.out.print("Enter the year: ");
                int viewYear = sc.nextInt();
                viewStudentByCourseAndYear(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewCourseByYear, viewYear);
                break;
            case 5:
                System.out.print("Enter the course: ");
                String viewCourseByGender = sc.next();
                System.out.print("Enter the gender (M/F): ");
                char viewGender = sc.next().charAt(0);
                viewStudentByCourseAndGender(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewCourseByGender, viewGender);
                break;
            case 6:
                System.out.print("Enter the enrollment status (E/N/B for Enrolled/Not Enrolled/Both): ");
                char viewStatus = sc.next().charAt(0);
                viewStudentByEnrollmentStatus(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewStatus);
                break;
            case 7:
                System.out.print("Enter the marital status (S/M): ");
                char viewMaritalStatus = sc.next().charAt(0);
                viewStudentByMaritalStatus(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewMaritalStatus);
                break;
            case 8:
                System.out.print("Enter the enrollment status (E/N/B for Enrolled/Not Enrolled/Both): ");
                char viewStatusByCourse = sc.next().charAt(0);
                System.out.print("Enter the course: ");
                String viewCourseByStatus = sc.next();
                viewStudentByEnrollmentStatusAndCourse(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewStatusByCourse, viewCourseByStatus);
                break;
            case 9:
                System.out.print("Enter the marital status (S/M): ");
                char viewMaritalStatusByCourse = sc.next().charAt(0);
                System.out.print("Enter the course: ");
                String viewCourseByMaritalStatus = sc.next();
                viewStudentByMaritalStatusAndCourse(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewMaritalStatusByCourse, viewCourseByMaritalStatus);
                break;
            case 10:
                System.out.print("Enter the course: ");
                String viewCourseByYearAndStatus = sc.next();
                System.out.print("Enter the year: ");
                int viewYearByStatus = sc.nextInt();
                System.out.print("Enter the enrollment status (E/N/B for Enrolled/Not Enrolled/Both): ");
                char viewStatusByYearAndCourse = sc.next().charAt(0);
                viewStudentByCourseYearAndEnrollmentStatus(IDnum, FName, LName, MI, age, gender, course, year, Status1, Status2, index, viewCourseByYearAndStatus, viewYearByStatus, viewStatusByYearAndCourse);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void viewStudentByID(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String viewID) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (IDnum[i].equals(viewID)) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID number " + viewID + " not found.");
        }
    }

    public static void viewStudentByLastName(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String viewLastName) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (LName[i].equalsIgnoreCase(viewLastName)) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students with family name " + viewLastName + " found.");
        }
    }

    public static void viewStudentByCourse(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String viewCourse) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (course[i].equalsIgnoreCase(viewCourse)) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students enrolled in the course " + viewCourse + " found.");
        }
    }

    public static void viewStudentByCourseAndYear(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String viewCourse, int viewYear) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (course[i].equalsIgnoreCase(viewCourse) && year[i] == viewYear) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students enrolled in the course " + viewCourse + " and year " + viewYear + " found.");
        }
    }

    public static void viewStudentByCourseAndGender(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String viewCourse, char viewGender) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (course[i].equalsIgnoreCase(viewCourse) && gender[i] == viewGender) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students enrolled in the course " + viewCourse + " with gender " + viewGender + " found.");
        }
    }

    public static void viewStudentByEnrollmentStatus(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, char viewStatus) {
        boolean found = false;
        System.out.println("\nSTUDENT INFORMATION");
        System.out.println("====================");
        if (viewStatus == 'E' || viewStatus == 'B') {
            System.out.println("ENROLLED STUDENTS:");
            for (int i = 0; i < index; i++) {
                if (Status2[i].equals ("EN")) {
                    System.out.println("ID Number: " + IDnum[i]);
                    System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                    System.out.println("Age: " + age[i]);
                    System.out.println("Gender: " + gender[i]);
                    System.out.println("Course: " + course[i]);
                    System.out.println("Year: " + year[i]);
                    System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                    found = true;
                }
            }
        }
        if (viewStatus == 'N' || viewStatus == 'B') {
            System.out.println("NOT ENROLLED STUDENTS:");
            for (int i = 0; i < index; i++) {
                if (Status2[i].equals ("NE")) {
                    System.out.println("ID Number: " + IDnum[i]);
                    System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                    System.out.println("Age: " + age[i]);
                    System.out.println("Gender: " + gender[i]);
                    System.out.println("Course: " + course[i]);
                    System.out.println("Year: " + year[i]);
                    System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No students with enrollment status " + viewStatus + " found.");
        }
    }

    public static void viewStudentByMaritalStatus(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, char viewMaritalStatus) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (Status1[i] == viewMaritalStatus) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students with marital status " + viewMaritalStatus + " found.");
        }
    }

    public static void viewStudentByEnrollmentStatusAndCourse(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, char viewStatus, String viewCourse) {
        boolean found = false;
        System.out.println("\nSTUDENT INFORMATION");
        System.out.println("====================");
        if (viewStatus == 'E' || viewStatus == 'B') {
            System.out.println("ENROLLED STUDENTS IN " + viewCourse + ":");
            for (int i = 0; i < index; i++) {
                if (Status2[i].equals  ("EN") && course[i].equalsIgnoreCase(viewCourse)) {
                    System.out.println("ID Number: " + IDnum[i]);
                    System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                    System.out.println("Age: " + age[i]);
                    System.out.println("Gender: " + gender[i]);
                    System.out.println("Course: " + course[i]);
                    System.out.println("Year: " + year[i]);
                    System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                    found = true;
                }
            }
        }
        if (viewStatus == 'N' || viewStatus == 'B') {
            System.out.println("NOT ENROLLED STUDENTS IN " + viewCourse + ":");
            for (int i = 0; i < index; i++) {
                if (Status2[i].equals("NE") && course[i].equalsIgnoreCase(viewCourse)) {
                    System.out.println("ID Number: " + IDnum[i]);
                    System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                    System.out.println("Age: " + age[i]);
                    System.out.println("Gender: " + gender[i]);
                    System.out.println("Course: " + course[i]);
                    System.out.println("Year: " + year[i]);
                    System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No students with enrollment status " + viewStatus + " and course " + viewCourse + " found.");
        }
    }

    public static void viewStudentByMaritalStatusAndCourse(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, char viewMaritalStatus, String viewCourse) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (Status1[i] == viewMaritalStatus && course[i].equalsIgnoreCase(viewCourse)) {
                System.out.println("\nSTUDENT INFORMATION");
                System.out.println("====================");
                System.out.println("ID Number: " + IDnum[i]);
                System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                System.out.println("Age: " + age[i]);
                System.out.println("Gender: " + gender[i]);
                System.out.println("Course: " + course[i]);
                System.out.println("Year: " + year[i]);
                System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students with marital status " + viewMaritalStatus + " and course " + viewCourse + " found.");
        }
    }

    public static void viewStudentByCourseYearAndEnrollmentStatus(String[] IDnum, String[] FName, String[] LName, char[] MI, int[] age, char[] gender, String[] course, int[] year, char[] Status1, String[] Status2, int index, String viewCourse, int viewYear, char viewStatus) {
        boolean found = false;
        System.out.println("\nSTUDENT INFORMATION");
        System.out.println("====================");
        if (viewStatus == 'E' || viewStatus == 'B') {
            System.out.println("ENROLLED STUDENTS IN " + viewCourse + " YEAR " + viewYear + ":");
            for (int i = 0; i < index; i++) {
                if (Status2[i].equals ("EN") && course[i].equalsIgnoreCase(viewCourse) && year[i] == viewYear) {
                    System.out.println("ID Number: " + IDnum[i]);
                    System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                    System.out.println("Age: " + age[i]);
                    System.out.println("Gender: " + gender[i]);
                    System.out.println("Course: " + course[i]);
                    System.out.println("Year: " + year[i]);
                    System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                    found = true;
                }
            }
        }
        if (viewStatus == 'N' || viewStatus == 'B') {
            System.out.println("NOT ENROLLED STUDENTS IN " + viewCourse + " YEAR " + viewYear + ":");
            for (int i = 0; i < index; i++) {
                if (Status2[i].equals ("NE") && course[i].equalsIgnoreCase(viewCourse) && year[i] == viewYear) {
                    System.out.println("ID Number: " + IDnum[i]);
                    System.out.println("Name: " + LName[i] + ", " + FName[i] + " " + MI[i] + ".");
                    System.out.println("Age: " + age[i]);
                    System.out.println("Gender: " + gender[i]);
                    System.out.println("Course: " + course[i]);
                    System.out.println("Year: " + year[i]);
                    System.out.println("Status: " + Status1[i] + " - " + Status2[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No students with enrollment status " + viewStatus + ", course " + viewCourse + ", and year " + viewYear + " found.");
        }
    }

}
