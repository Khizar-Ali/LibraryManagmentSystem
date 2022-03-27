
import java.sql.*;

public class Students{
    private int rollNo;
    private String stdName;
    private String address;

    public Students(int rollNo, String stdName, String address){
        this.rollNo = rollNo;
        this.stdName = stdName;
        this.address = address;
    }

    // Getter Methods
    public String getStdName() {
        return stdName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getAddress() {
        return address;
    }

    // Setter Methods
    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "rollNo=" + rollNo +
                ", stdName='" + stdName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void storeStudents(Connection connection){
        try {

            Statement statement = connection.createStatement ();
            String sql = "INSERT INTO students VALUES ("+"'"+getRollNo()+"'"+", "+"'"+getStdName ()+"'"+", "+"'"+getAddress()+"'" +")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
