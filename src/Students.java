
import java.sql.*;

public class Students {
    private String stdName;
    private int rollNo;
    private String ISBN;
    private String issueDate;

    public Students(String stdName, int rollNo, String ISBN, String issueDate){
        this.stdName = stdName;
        this.rollNo = rollNo;
        this.ISBN = ISBN;
        this.issueDate = issueDate;
    }

    // Getter Methods
    public String getStdName() {
        return stdName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getIssueDate() {
        return issueDate;
    }


    // Setter Methods
    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Students{" +
                "stdName='" + stdName + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", issueDate='" + issueDate + '\'' +
                '}';
    }

    public void storeStudents(Connection connection){
        try {

            Statement statement = connection.createStatement ();
            String sql = "INSERT INTO students VALUES ("+"'"+getRollNo()+"'"+", "+"'"+getStdName ()+"'"+", "+"'"+getISBN()+"'"+", "+"'"+getIssueDate()+"'" +")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
