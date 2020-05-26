package Java_Classes;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> bookList = new ArrayList<Book>();

    void addBook(Book book) {
        bookList.add(book);
    }
    public ArrayList<Book> getBookAuthor(String author) {
        ArrayList<Book> bookAuthor = new ArrayList<Book>();
        for (Book a : bookList) {
            if (a.getAuthor().equals(author))
                bookAuthor.add(a);
        }
        return bookAuthor;
    }
    public ArrayList<Book> getBookPublisher(String publisher) {
        ArrayList<Book> bookPublisher=new ArrayList<Book>();
        for(Book book: bookList){
            if(book.getPublisher().equals(publisher))
                bookPublisher.add(book);
        }
        return bookPublisher;
    }
    public ArrayList<Book> getBookYear(int year) {
        ArrayList<Book> bookYear=new ArrayList<Book>();
        for(Book book: bookList){
            if(book.getYearOfPublic()>year)
                bookYear.add(book);
        }
        return bookYear;
    }
}