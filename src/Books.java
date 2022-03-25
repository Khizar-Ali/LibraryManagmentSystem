import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class Books {
    private String Title;
    private String author;
    private String ISBN;
    private int bookQuantity;

    public Books(String Title, String author, String ISBN, int bookQuantity){
        this.Title = Title;
        this.author = author;
        this.ISBN = ISBN;
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
                "Title='" + Title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
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
