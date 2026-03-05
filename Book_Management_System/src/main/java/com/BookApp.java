package com;

import DAO.*;
import model.Book;
import service.*;

import java.util.Scanner;

public class BookApp {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        BookDAO dao=new BookDAOImpl();
        BookService service=new BookServiceImpl(dao);

        while(true){
        	System.out.println("===Welcome To Book Management System===");
            System.out.println("1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Update Price");
            System.out.println("4 Delete Book");
            System.out.println("5 Search Book");
            System.out.println("6 Exit");
            System.out.println();
            System.out.print("Enter your choice:");
            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("Enter Id:");
                    int id=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Title:");
                    String title=sc.nextLine();

                    System.out.println("Enter Author:");
                    String author=sc.nextLine();

                    System.out.println("Enter Price:");
                    double price=sc.nextDouble();

                    service.addBook(new Book(id,title,author,price));
                    break;

                case 2:
                    service.viewBooks();
                    break;

                case 3:

                    System.out.println("Enter Id:");
                    int bid=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Author:");
                    String auth=sc.nextLine();

                    System.out.println("Enter New Price:");
                    double p=sc.nextDouble();

                    service.updatePrice(bid,auth,p);
                    break;

                case 4:

                    System.out.println("Enter Id:");
                    int del=sc.nextInt();

                    service.deleteBook(del);
                    break;

                case 5:

                    sc.nextLine();
                    System.out.println("Enter Title:");
                    String t=sc.nextLine();

                    service.searchBook(t);
                    break;

                case 6:
                	System.out.println("Thank You");
                    System.exit(0);
            }
        }
    }
}