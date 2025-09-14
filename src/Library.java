// Main class that represents the library system.
// This class serves as the entry point of the program and 
// provides a menu-driven interface
// for managing library operations such as adding books, 
// registering students, borrowing/returning books, etc.

import java.util.Scanner;
import java.util.ArrayList;

public class Library {
    
    public static void main(String[] args) {
        
        BorrowReturn student = new BorrowReturn(); // Instance to manage student-related operations.
        Books bookFunction = student.bookFunction; // Reference to the Books instance for managing books.
        ArrayList<StudentDetails> students = new ArrayList<>(); // List of students (not directly used in this class).
        
        Scanner input = new Scanner(System.in);
        System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
        System.out.println("|          Welcome to TLGC Library!          |");
        System.out.println("|     Select From The Following Options      |");
        System.out.println("°~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~°");
        
        int choice; // Variable to store user choice.
        
        // Loop to continuously display the menu and 
        // process user input until they choose to exit.
        do{
            bookFunction.displayMenu(); // Display the main menu.
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            System.out.println();
            
            // Handle user choice using a switch statement.
            switch(choice){
                
                // Option to add a new book to the library.
                case 1:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|                  Add Books                 |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    bookFunction.addBook();
                System.out.println();
                break;
                
                // Option to display all books in the library.
                case 2:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|                Show All Books              |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    bookFunction.showAllBooks();
                System.out.println();
                break;
                
                // Option to search for a book by serial number or title.
                case 3:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|                 Search Book                |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    bookFunction.searchBook();
                System.out.println();
                break;
                
                // Option to update the quantity of an existing book.
                case 4:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|             Update Book Quantity           |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    bookFunction.upgradeBookQuantity();
                System.out.println();
                break;
                
                // Option to register a new student.
                case 5:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|               Register Student             |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    student.registerStudent();
                System.out.println();
                break;
                
                // Option to display all registered students.
                case 6:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|          Show All Register Students        |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    student.showAllRegStudent();
                break;
                
                // Option to allow a student to borrow a book.
                case 7:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|                 Borrow Books               |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    student.borrowBook();
                System.out.println();
                break;
                
                // Option to allow a student to return a book.
                case 8:
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                System.out.println("|                 Return Books               |");
                System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
                    student.returnBook();
                System.out.println();
                break;
                
                // Exit the program.
                case 0:
                    System.out.println("Closing Program...");
                    System.out.println("Thank you for using!");
                break;
                
                // Handle invalid input.
                default:
                    System.out.println("Invalid Input... Please Input between 0 to 8");
                    System.out.println();
            }
            
        }while(choice != 0); // Continue the loop until the user chooses to exit.
        
    }
    
}