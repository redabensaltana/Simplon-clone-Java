import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    protected Connection connection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplon_clone","root","password");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
