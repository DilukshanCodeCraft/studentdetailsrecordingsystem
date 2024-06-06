import java.util.Scanner;

class Node {
    String stdID;
    String stdname;
    int age;
    String gpa;
    Node next;

    public Node(String stdID, String stdname, int age, String gpa) {
        this.stdID = stdID;
        this.stdname = stdname;
        this.age = age;
        this.gpa = gpa;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // ... (insert and Deletestudents methods)
public void insert(String stdID, String stdname, int age, String gpa) {
        Node newNode = new Node(stdID, stdname, age, gpa);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void Deletestudents(Scanner myscanner8, String stdID) {
        // ... (same as before)
        Menu menu2 = new Menu();
        if (this.head == null) {
            System.out.println("List is empty, cannot delete.");
            return;
        }

        if (head.stdID.equals(stdID)) {
            System.out.println("Deleting student with ID: " + stdID);
            this.head = this.head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.stdID.equals(stdID)) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("Deleting student with ID: " + stdID);
            current.next = current.next.next;
            menu2.Menulist(myscanner8);
        } else {
            System.out.println("Student with ID " + stdID + " not found.");
            menu2.Menulist(myscanner8);
        }
    }
    
    public Node getHead() {
        return head;
    }
}

class Menu {
    private LinkedList list;

    public Menu() {
        list = new LinkedList();
    }

    public void Menulist(Scanner myscanner) {
        while (true) {
            System.out.println("\n<<<<< Menu >>>>>\n");
            System.out.println("1. Add Students");
            System.out.println("2. Delete Students");
            System.out.println("3. View Students");
            System.out.println("4. Exit\n");
            System.out.print("Please select an option to continue: ");
            int option = myscanner.nextInt();
            myscanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    Addstudents(myscanner);
                    break;

                case 2:
                    System.out.println(">> Enter Student ID to delete: ");
                    String stdID = myscanner.nextLine();
                    list.Deletestudents(myscanner, stdID);
                    break;

                case 3:
                    Viewstudents(myscanner);
                    break;

                case 4:
                    System.out.println("Program has terminated!");
                    System.exit(0);
                    //return; // Exit the program

                default:
                    System.out.println("Enter a valid option!");
            }
        }
    }

    // ... (Addstudents, Viewstudents, findStudent, and printStudentDetails methods)
        public void Addstudents(Scanner myscanner) {
        // ... (same as before)
         System.out.print("\nPlease Enter the number of student records you wish to enter: ");
        int g = myscanner.nextInt();
        myscanner.nextLine();
        for (int j = 0; j < g; j++) {
            System.out.println("\n<<<<< Student Record No: " + (j+1) + " >>>>>");
            System.out.println("\n>> Enter Student Id: ");
            String stdiddummy = myscanner.nextLine();
            String stdID = stdiddummy.trim();
            System.out.println(">> Enter Student Name: ");
            String stdname = myscanner.nextLine();
            System.out.println(">> Enter Age: ");
            int age = myscanner.nextInt();
            myscanner.nextLine();
            System.out.println(">> Enter GPA: ");
            String gpa = myscanner.nextLine();
            list.insert(stdID, stdname, age, gpa);
            System.out.println("");
        }
        Menulist(myscanner);
    }
    


    public void Viewstudents(Scanner myscanner) {
        Node current = list.getHead();
        System.out.println("\nDo you wish to view all the student records (Y/N)?");
        String h = myscanner.nextLine();
        String trimmedInput = h.trim();

        if (trimmedInput.equalsIgnoreCase("Y")) {
            while (current != null) {
                System.out.println("\n<<<<<<< Student details for: " + current.stdID + " `>>>>>>>");
                System.out.println("Student ID: " + current.stdID);
                System.out.println("Student Name: " + current.stdname);
                System.out.println("Student Age: " + current.age);
                System.out.println("Student GPA: " + current.gpa);
                current = current.next;
            }
        } else {
            System.out.println("\nEnter the Student's ID to retrieve student details: ");
            String studentID = myscanner.nextLine();
            Node student = findStudent(studentID);
            if (student != null) {
                printStudentDetails(student);
            } else {
                System.out.println("Student not found.");
            }
        }
        Menulist(myscanner);
    }

    private Node findStudent(String studentID) {
        Node current = list.getHead();
        while (current != null && !current.stdID.equals(studentID)) {
            current = current.next;
        }
        return current;
    }

    private void printStudentDetails(Node student) {
        System.out.println("*******Student details for: " + student.stdID + "*******");
        System.out.println("Student ID: " + student.stdID);
        System.out.println("Student Name: " + student.stdname);
        System.out.println("Student Age: " + student.age);
        System.out.println("Student GPA: " + student.gpa);
    }
}



public class LinkedListExample {
    public static void main(String[] args) {
        Scanner myscanner1 = new Scanner(System.in);
        Menu menu1 = new Menu();
        menu1.Menulist(myscanner1);
    }
}
