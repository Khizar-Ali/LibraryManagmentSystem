import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("Enter 1 for Books\nEnter 2 for Students\nEnter 3 for Issue Book\nEnter 4 for Add Books");
        int opt = scan.nextInt();

        switch(opt){
            case 1:
                ResultSet resultSet = statement.executeQuery("select * from books");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("ISBN"));
                    System.out.println(resultSet.getString("Title"));
                    System.out.println(resultSet.getString("Author"));
                    System.out.println(resultSet.getString("bookQuantity"));
                    System.out.println();
                }
                break;
            case 2:
                ResultSet resultset = statement.executeQuery("select * from students");
                while(resultset.next()){
                    System.out.println(resultset.getString("stdName"));
                    System.out.println(resultset.getInt("idStudents"));
                    System.out.println(resultset.getString("ISBN"));
                    System.out.println(resultset.getString("issueDate"));
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Input Roll No");
                int rollNo = scan.nextInt();
                //System.out.println();
                System.out.println("Input Name");
                String stdName = scan.next();
                //System.out.println();
                System.out.println("Input ISBN");
                String ISBN = scan.next();
                //System.out.println();
                System.out.println("Input Issue Date");
                String issueDate = scan.next();

                Students student = new Students(stdName,rollNo,ISBN,issueDate);

                student.storeStudents(connection);
                break;
            case 4:
                System.out.println("Input ISBN Number:");
                String bookISBN = scan.next();
                System.out.println("Input Book Title: ");
                String Title = scan.next();
                System.out.println("Input Author Name: ");
                String author = scan.next();
                System.out.println("Input the Quantity of Book: ");
                int bookQuantity = scan.nextInt();

                Books book = new Books(Title, author, bookISBN,bookQuantity);

                book.storeBook(connection);
                break;

        }
    }
}

