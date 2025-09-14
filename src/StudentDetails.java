// This class represents a student's details and their interaction with the library system.
// It includes properties for the student's name, registration number, and the list of books they have borrowed.
// Methods are provided to manage borrowing and returning books, along with getters for accessing data.

import java.util.Scanner;
import java.util.ArrayList;

public class StudentDetails {
    
    private String studentName; // Stores the name of the student.
    private String registerNumber; // Stores the unique registration number of the student.
    ArrayList<BookDetails> borrowedBooks = new ArrayList<>(); // List to track books currently borrowed by the student.
    Scanner input = new Scanner(System.in);
    
    // Constructor to initialize student details during registration.
    public StudentDetails(){
        System.out.print("Enter Student Name \t:\t");
        this.studentName = input.nextLine();
        System.out.print("Enter Register Number \t:\t");
        this.registerNumber = input.nextLine();
    }
    // Getter Method to retrieve the student name, 
    // register number and the list of books borrowed by student
    public String getStudentName() {
        return studentName;
    }
    
    public String getRegisterNumber() {
        return registerNumber;
    }
    
    public ArrayList<BookDetails> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    // Method to borrow a book. Ensures that a student 
    // cannot borrow more than 3 books at a time.
    public void borrowBook(BookDetails book) {
        if(borrowedBooks.size() >= 3) {
            System.out.println("Cannot borrow more than 3 books.");
            return;
        }
        
        borrowedBooks.add(book); // Add the book to the borrowed list.
        System.out.println("Book successfull borrowed.");
    }
    
    // Method to return a borrowed book.
    public void returnBook(BookDetails book) {
        if(borrowedBooks.remove(book)) {
            System.out.println("Book successfully returned");
        }else {
            System.out.println("Book not found in borrowed list"); // If the book is not in the list.
        }
    }
    
    // Overridden toString method to display student details.
    @Override
    public String toString() {
        return "Name\t\t:\t" + studentName + "\nRegister Number\t:\t" + registerNumber ;
    }
} 