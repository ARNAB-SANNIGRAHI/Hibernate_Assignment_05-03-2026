package DAO;

import model.Book;

public interface BookDAO {

    void addBook(Book book);

    void viewAllBooks();

    void updatePrice(int id,String author,double price);

    void deleteBook(int id);

    void searchBookByTitle(String title);
}