package service;

import DAO.BookDAO;
import model.Book;

public class BookServiceImpl implements BookService {

    private BookDAO dao;

    public BookServiceImpl(BookDAO dao){
        this.dao=dao;
    }

    public void addBook(Book book){
        dao.addBook(book);
    }

    public void viewBooks(){
        dao.viewAllBooks();
    }

    public void updatePrice(int id,String author,double price){
        dao.updatePrice(id,author,price);
    }

    public void deleteBook(int id){
        dao.deleteBook(id);
    }

    public void searchBook(String title){
        dao.searchBookByTitle(title);
    }
}