import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class Books {
    private String ISBN;
    private String Title;
    private String author;
    private int bookQuantity;

    public Books(String ISBN, String Title, String author, int bookQuantity){
        this.ISBN = ISBN;
        this.Title = Title;
        this.author = author;
        this.bookQuantity = bookQuantity;
    }

    // Getter Methods
    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    // Setter Methods
    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "ISBN='" + ISBN + '\'' +
                ", Title='" + Title + '\'' +
                ", author='" + author + '\'' +
                ", bookQuantity=" + bookQuantity +
                '}';
    }

    public void storeBook(Connection connection){
        try {

            Statement statement = connection.createStatement ();
            String sql = "INSERT INTO books VALUES ("+"'"+getISBN()+"'"+", "+"'"+getTitle()+"'"+", "+"'"+getAuthor()+"'"+", "+"'"+getBookQuantity()+"'" +")";
            statement.executeUpdate (sql);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}
