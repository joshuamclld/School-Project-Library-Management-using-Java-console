// Class to represent the details of a book in the library.

import java.util.Scanner;

public class BookDetails {
    
    // Declaration of class variables to store details about a book.
    // These include private fields for title, author, serial number, and total quantity,
    // as well as a public field for the available quantity (copyBookQty).
    // A Scanner object is also declared for user input.
    private String title;
    private String author;
    private int serialNumber;
    private int bookQuantity;
    public int copyBookQty;
    Scanner input = new Scanner(System.in);
    
    
    // Constructor for the BookDetails class.
    // Prompts the user to input details about a 
    // book and initializes the fields accordingly.
    public BookDetails() {
        System.out.print("Enter Book Title\t:\t");
        this.title = input.nextLine();
        System.out.print("Enter Book Author\t:\t");
        this.author = input.nextLine();
        System.out.print("Enter Book Serial Number:\t");
        this.serialNumber = input.nextInt();
        System.out.print("Enter Book Quantity\t:\t");
        this.bookQuantity = input.nextInt();
        this.copyBookQty = this.bookQuantity;
    }
    
    // Getter and setter methods for accessing and 
    // modifying the attributes of the class.
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getSerialNumber() {
        return serialNumber;
    }
    public int getBookQuantity() {
        return bookQuantity;
    }
    public int getCopyBookQty() {
        return copyBookQty;
    }
    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
    public void setCopyBookQty(int copyBookQty) {
        this.copyBookQty = copyBookQty;
    }
    
    // This method provides a string representation of the object,
    // including details like serial number, title, author, available quantity, and total quantity.
    @Override
    public String toString() {
        return "Serial Number\t  :\t" +serialNumber + "\nTitle\t\t  :\t" + title + "\nAuthor\t\t  :\t" + author + 
                "\nAvailable Quantity:\t" + copyBookQty + "\nTotal Quantity\t  :\t" + bookQuantity + "\n";
    }
}