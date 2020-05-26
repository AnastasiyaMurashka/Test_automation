package Java_Classes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library books=new Library();
        books.addBook(new Book(12345, "The Great Gatsby","F. Scott Fitzgerald", "Eva",
                1994, 342, 34.40, "hardback"));
        books.addBook(new Book(12335, "To Kill a Mockingbird","Harper Lee", "Evabook",
                1993, 342, 34.40, "paperback"));
        books.addBook(new Book(12347, "Harry Potter and the Sorcerer's Stone","J.K. Rowling",
                "Eva", 2000, 342, 34.40, "hardback"));

        System.out.println("Books sorted by years: ");
        ArrayList<Book> byYears= books.getBookYear(1993);
        for(Book book: byYears){
            System.out.println(book.toString());
        }
        System.out.println("Book by author ");
        System.out.println(books.getBookAuthor("Harper Lee"));
        System.out.println("Book by publisher");
        System.out.println(books.getBookPublisher("Eva"));
    }
}
