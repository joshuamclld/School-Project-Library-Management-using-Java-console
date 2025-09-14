// This class manages the operations related to books in the library system.
// It includes functionalities like adding books, searching for books by serial number or title, 
// displaying all books, updating book quantities, borrowing books, and returning books.

import java.util.Scanner;
import java.util.ArrayList;

public class Books {
    
    Scanner input = new Scanner(System.in);
    ArrayList<BookDetails> book = new ArrayList<>();
    
    // Method to add new book to the library
    public void addBook() {
        BookDetails books = new BookDetails();
        
        for(BookDetails b : book){
            if(b.getSerialNumber() == books.getSerialNumber()) {
                System.out.println("Book Serial Number : " + b.getSerialNumber() + 
                    " already exist.");
                return;
            }
        }
        book.add(books); // Add the new book if the serial number is unique
        System.out.println("Book Added Successfully");
    }
    // Method to search for books by serial number or title.
    public void searchBook(){
        int choice;
        do{
            System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
            System.out.println("|     Press 1 to Search by Serial Number     |");
            System.out.println("|     Press 2 to Search by Book Title        |");
            System.out.println("|     Press 0 to Exit                        |");
            System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            System.out.println();
            
            switch(choice){
                case 1:
                    this.searchSerialNumber(); // to search by serial number
                break;
                
                case 2:
                    this.searchBookTitle(); // to search by title
                break;
                
                case 0:
                    System.out.println("Thank you for Searching.");
                break;
                
                default:
                    System.out.println("Invalid Input... Please Input between 0 to 2.");
            }
        }while(choice != 0);
    }
    // Method to search book using it's serial number
    public void searchSerialNumber() {
        System.out.print("Enter Serial Number : ");
        int sNum = input.nextInt();
        System.out.println();
        
        boolean found = false;
        
        for(BookDetails b : book) {
            if(b.getSerialNumber() == sNum) {
                System.out.println(b);
                found = true;
            }
        }
        
        if(!found) {
            System.out.println("Book not found.");
        }
    }
    
    // Method to search book by it's title
    public void searchBookTitle(){
        System.out.print("Enter Title : ");
        String title = input.next();
        System.out.println();
        
        boolean found = false;
        
        for(BookDetails b : book) {
            if(b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Book not found.");
        }
    }
    
    // Method to display all books in the library
    public void showAllBooks() {
        if(book.isEmpty()) {
            System.out.println("No Books is in the Library");
            return;
        }
        for(BookDetails b : book) {
            System.out.println(b);
        }
    }
    
    // Method to increas the quantity of a specific book
    public void upgradeBookQuantity(){
        if(book.isEmpty()){
            System.out.println("No Books is in the Library");
            return;
        }
        System.out.print("Enter Serial Number : ");
        int sNum = input.nextInt();
        System.out.println();
        
        boolean found = false;
        for(BookDetails b : book) {
            if(b.getSerialNumber() == sNum) {
                System.out.print("Enter the number of books to add : ");
                int qty = input.nextInt();
                System.out.println();
                
                b.setBookQuantity(b.getBookQuantity() + qty); // increase the total quantity
                b.setCopyBookQty(b.getCopyBookQty() + qty); //increase the available quantity
                System.out.println("Book Quantity Updated.");
                found = true;
                break;
            }
        }
    }
    
    // Method to borrow a book
    public BookDetails borrowBook(int serialNumber) {
        for (BookDetails b : book) {
            if (b.getSerialNumber() == serialNumber && b.getCopyBookQty() > 0) {
                    b.setCopyBookQty(b.getCopyBookQty() - 1); // reduce the available quantity
                    return b;
                }
            }
        return null;
    }
    
    // Method to return a book
    public void returnBook(BookDetails books){
        for(BookDetails b : book) {
            if(b.getSerialNumber() == books.getSerialNumber()) {
                b.setCopyBookQty(b.getCopyBookQty() + 1); // increase the available quantity 
                break;
            }
        }
    }
    
    // Method to display the main menu for the library system.
    public void displayMenu(){
        System.out.println("†~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~†");
        System.out.println("|    Press 1 to Add Book                     |");
        System.out.println("|    Press 2 to Show All Books               |");
        System.out.println("|    Press 3 to Search Book                  |");
        System.out.println("|    Press 4 to Update Book Quantity         |");
        System.out.println("|    Press 5 to Register Student             |");
        System.out.println("|    Press 6 to Show All Registered Students |");
        System.out.println("|    Press 7 to Borrowed Book                |");
        System.out.println("|    Press 8 to Returned Book                |");
        System.out.println("|    Press 0 to Exit Application             |");
        System.out.println("°~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~°");
    }
}