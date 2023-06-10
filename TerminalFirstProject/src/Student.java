import java.io.*;
import java.util.*;

class Student implements Serializable {
    String id;
    String lastName;
    String firstName;
    char middleInitial;
    int age;
    String course;
    int year;
    String status1;
    String status2;
    Student(String id,String lastName, String firstName,
            char middleInitial, int age, String course,
            int year, String status1, String status2){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.age = age;
        this.course = course;
        this.year = year;
        this.status1 = status1;
        this.status2 = status2;

    }
    public String toString(){
        return id + " " + firstName + " " + lastName +
                " " + middleInitial + " " + age + " "
                + course + " " + year + " " + status1
                + " " + status2 + " ";
    }
}

class StudentFile{

    public static void main(String[] args) throws Exception  {

        int choice = -1;
        do {
            System.out.println("---------------------------------------");
            System.out.println("STUDENT INFORMATION SYSTEM             ");
            System.out.println("1. ADD NEW STUDENT                     ");
            System.out.println("2. UPDATE RECORD                       ");
            System.out.println("3. REMOVE STUDENT                      ");
            System.out.println("4. VIEW STUDENT                        ");
            System.out.println("0. Exit                                ");
            System.out.println("---------------------------------------");
            System.out.print("Enter Your Choice: ");
            Scanner s = new Scanner(System.in);
            choice = s.nextInt();

            if(choice == 1) {


                    File file = new File("Student.dat.txt");
                    ArrayList<Student> al = new ArrayList<>();
                    ObjectOutputStream oos = null;
                    ObjectInputStream ois = null;
                    ListIterator li = null;

                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Student>) ois.readObject();
                        ois.close();
                    }

                System.out.print("How many new students do you want to add? : ");
                int n = s.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter ID number: ");
                    String idf = s.next();
                    System.out.print("Enter Last Name: ");
                    String ln = s.next();
                    System.out.print("Enter First Name: ");
                    String fn = s.next();
                    System.out.print("Enter Middle Initial: ");
                    char mi = s.next().charAt(0);
                    System.out.print("Enter Age: ");
                    int agef = s.nextInt();

                        System.out.print("Enter Course: ");
                        String cf = s.next();

                        String [] arr = {"BSIS", "BSIT", "BSA", "BSC", "BSED", "BSCE", "BSME", "BSEE"};


                        if (cf.equals(arr[0])) {

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");

                        }else if(cf.equals(arr[1])) {
                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        }else if(cf.equals(arr[2])){

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        }else if(cf.equals(arr[3])){

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        }else if(cf.equals(arr[4])){

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        }else if(cf.equals(arr[5])){

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        }else if(cf.equals(arr[6])){

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        }else if(cf.equals(arr[7])){

                            System.out.println("----------------------------");
                            System.out.println("Valid course!               ");
                            System.out.println("----------------------------");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("Invalid course!             ");
                            System.out.println("----------------------------");
                        }


                        System.out.print("Enter Year: ");
                        int yr = s.nextInt();
                        System.out.print("Enter Status1: ");
                        String st = s.next();
                        System.out.print("Enter Status2: ");
                        String st2 = s.next();

                        al.add(new Student(idf, ln, fn, mi, agef, cf, yr, st, st2));
                }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();

            }else if(choice == 2){


            }



        }while(choice != 0);

    }


}
