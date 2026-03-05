package service;

import model.Book;

public interface BookService {

    void addBook(Book book);

    void viewBooks();

    void updatePrice(int id,String author,double price);

    void deleteBook(int id);

    void searchBook(String title);
}