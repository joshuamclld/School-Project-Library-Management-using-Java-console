// This class manages the borrowing and returning of books by students in the library system.
// It includes functionalities such as registering students, borrowing books, returning books, 
// and displaying all registered students.

import java.util.Scanner;
import java.util.ArrayList;

public class BorrowReturn {
    
    Scanner input = new Scanner(System.in);
    ArrayList<StudentDetails> student = new ArrayList<>();
    Books bookFunction = new Books();
    
    // Method to register a new student in the library system.
    public void registerStudent() {
        StudentDetails students = new StudentDetails();
        for(StudentDetails s : student) {
            if(s.getRegisterNumber().equalsIgnoreCase(students.getRegisterNumber())) {
                System.out.println("Student Register Number : " + s.getRegisterNumber() + " already exist.");
                return;
            }
        }
        student.add(students); // Add the student to the list if the register number is unique.
        System.out.println("Student Register Successfully."); 
    }
    
    // Method to allow a registered student to borrow a book.
    public void borrowBook() {
        if (student.isEmpty()) {
            System.out.println("No Student is Register. Please register a student first.");
            return;
        }

        System.out.print("Enter Student Register Number : ");
        String regNumber = input.nextLine();
        System.out.println();

        // Find the student by registration number.
        StudentDetails currentStudent = findStudentByRegNumber(regNumber);
        if (currentStudent == null) {
            System.out.println("Student not found. Please register the student first.");
            return;
        }

        System.out.print("Enter Serial Number of the Book to Borrow : ");
        int serialNumber = input.nextInt();
        System.out.println();

        BookDetails book = bookFunction.borrowBook(serialNumber);
        if (book == null) {
            System.out.println("Book not available for borrowing.");
            return;
        }

        // Add the borrowed book to the student's
        currentStudent.borrowBook(book);
    }
    
    // Method to allow a registered student to return a borrowed book.
    public void returnBook() {
        if (student.isEmpty()) {
            System.out.println("No Student is Register. Please register a student first.");
            return;
        }

        System.out.print("Enter Student Register Number : ");
        String regNumber = input.next();
        System.out.println();

        // Find the student by registration number.
        StudentDetails currentStudent = findStudentByRegNumber(regNumber);
        if (currentStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Serial Number of the Book to Return : ");
        int serialNumber = input.nextInt();
        System.out.println();

        BookDetails bookToReturn = null;
        for (BookDetails b : currentStudent.getBorrowedBooks()) {
            if (b.getSerialNumber() == serialNumber) {
                bookToReturn = b;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Book not found in the student's borrowed list.");
            return;
        }

        // Remove the book from the student's borrowed list.
        currentStudent.returnBook(bookToReturn);
        // Add the book back to the library system.
        bookFunction.returnBook(bookToReturn);
    }
    
    // Helper method to find a student by their registration number.
    private StudentDetails findStudentByRegNumber(String regNumber) {
        for (StudentDetails s : student) {
            if (s.getRegisterNumber().equalsIgnoreCase(regNumber)) {
                return s;
            }
        }
        return null; // Return null if the student is not found.
    }
    
    // Method to display all registered students in the library system.
    public void showAllRegStudent() {
        if(student.isEmpty()) {
            System.out.println("No Student is Register.");
        }
        
        for(StudentDetails s : student) {
            System.out.println(s);
        }
        System.out.println();
    }
}