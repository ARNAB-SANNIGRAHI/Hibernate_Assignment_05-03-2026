package DAO;

import model.Book;
import java.sql.*;

public class BookDAOImpl implements BookDAO {

    String url="jdbc:mysql://localhost:3306/book_management?user=root&password=Arnab";

    public void addBook(Book book) {

        try {

            Connection con=DriverManager.getConnection(url);

            String sql="INSERT INTO book VALUES(?,?,?,?)";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,book.getId());
            ps.setString(2,book.getTitle());
            ps.setString(3,book.getAuthor());
            ps.setDouble(4,book.getPrice());

            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {

        try{

            Connection con=DriverManager.getConnection(url);

            String sql="SELECT * FROM book";

            PreparedStatement ps=con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                System.out.println(
                        rs.getInt("id")+" | "+
                        rs.getString("title")+" | "+
                        rs.getString("author")+" | "+
                        rs.getDouble("price")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updatePrice(int id,String author,double price){

        try{

            Connection con=DriverManager.getConnection(url);

            String sql="UPDATE book SET price=? WHERE id=? AND author=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setDouble(1,price);
            ps.setInt(2,id);
            ps.setString(3,author);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Price Updated");
            else
                System.out.println("Book Not Found");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteBook(int id){

        try{

            Connection con=DriverManager.getConnection(url);

            String sql="DELETE FROM book WHERE id=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,id);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Book Deleted");
            else
                System.out.println("Book Not Found");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void searchBookByTitle(String title){

        try{

            Connection con=DriverManager.getConnection(url);

            String sql="SELECT * FROM book WHERE title=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,title);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                System.out.println(
                        rs.getInt("id")+" | "+
                        rs.getString("title")+" | "+
                        rs.getString("author")+" | "+
                        rs.getDouble("price")
                );
            }
            else{
                System.out.println("Book Not Found");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}