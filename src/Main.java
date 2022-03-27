import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;

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
                resultSet = statement.executeQuery("select * from books");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("bookISBN"));
                    System.out.println(resultSet.getString("bookTitle"));
                    System.out.println(resultSet.getString("bookAuthor"));
                    System.out.println(resultSet.getString("bookQuantity"));
                    System.out.println();
                }
                break;

            case 2:
                resultSet = statement.executeQuery("select * from students");
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("studentId"));
                    System.out.println(resultSet.getString("studentName"));
                    System.out.println(resultSet.getString("studentAddress"));
                    System.out.println();
                }
                break;

            case 3:
                LocalDate currentDate = LocalDate.now();
                System.out.println(currentDate);
                LocalDate returnDate = currentDate.plusDays(10);
                System.out.println(returnDate);

                System.out.println("Enter Student ID: ");
                int stdId = scan.nextInt();
                System.out.println("Enter Book ISBN: ");
                String bookIsbn = scan.next();

                int issuedId = 1;
                resultSet = statement.executeQuery("SELECT * FROM issuedbooks ORDER BY idIssuedBooks DESC LIMIT 1");
                while(resultSet.next()) {
                    //System.out.println(resultSet.getInt("idIssuedBooks"));
                    issuedId = resultSet.getInt("idIssuedBooks");
                }
                issuedId++;

                try {
                    statement = connection.createStatement();
                    String sql = "INSERT INTO issuedbooks VALUES ("+"'"+issuedId+"'"+", "+"'"+stdId+"'"+", "+"'"+bookIsbn+"'"+", "+"'"+currentDate+"'"+", "+"'"+returnDate+"'" +")";
                    statement.executeUpdate(sql);
                } catch (SQLException e){
                    e.printStackTrace();
                }

                resultSet = statement.executeQuery ("SELECT * FROM books");
                while (resultSet.next ()){
                    String a = resultSet.getString ("bookISBN");
                    int Quan = resultSet.getInt ("bookQuantity");
                    if (a.equalsIgnoreCase (bookIsbn)){
                        if (Quan>0){
                            Quan = Quan - 1;
                            String sql = "UPDATE books SET bookQuantity = "+"'"+Quan+"' WHERE BookISBN ="+"'"+bookIsbn+"'"+";";
                            statement.executeUpdate (sql);
                            //System.out.println ("\nYou successfully issue the book with Return Date: "+returnDate);
                            System.out.println("It Worked");
                            break;
                        }
                        else {
                            System.out.println ("This book is not available yet.");
                            break;
                        }
                    }
                }
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

