package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private final int id;
    private final String bookName;
    private final String Author;
    public Book(int id, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        Author = author;
    }
    public int getId(){
        return id;
    }

    public String bookName(){
        return bookName;
    }

    public String Author(){
        return Author;
    }
    @Override
    public String toString(){
        return "Book id: " + id + ",Book name: " + bookName + ",Author: " + Author;
    }
}

class Library{
    List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public Book SearchById(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public void Display(){
        if(books.isEmpty()){
            System.out.println("No Books available now:");
        }
        else{
            System.out.println("Available books are:");
            for(Book book : books){
                System.out.println(book);
            }
        }
    }
}

public class LibrarySystem{
    public static void main(String[] args) {
        Library book = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.println("1 for add");
            System.out.println("2 for search");
            System.out.println("3 for display");
            System.out.println("4 for exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:System.out.println("Enter id ,name,author");
                int id = sc.nextInt();
                sc.nextLine();
                String Book = sc.nextLine();
                String author = sc.nextLine();
                book.addBook(new Book(id,Book,author));
                System.out.println("Added successfully!!");
                break;
                case 2:System.out.println("Enter id to be searched:");
                int Id = sc.nextInt();
                System.out.println(book.SearchById(Id));
                break;
                case 3:System.out.println("Details of all books available:");
                book.Display();
                break;
                case 4:System.out.println("Exiting from the file!!");
                sc.close();
                return;
                default:
                    System.out.println("Invaild choice!!!");
            }
        }
    }
}