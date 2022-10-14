import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Account{
    public static ArrayList<Student> students = new ArrayList<Student>();
    public Promo promo = null;
    public String mail;
    public Student(String fname,String lname,String uname,String pass,String email){
        firstname = fname;
        lastname = lname;
        username = uname;
        password = pass;
        mail = email;
    }

    public static void login() throws SQLException {
//        Connection connection = new MyJDBC().connection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM simplon_clone.student;");
//        while(resultSet.next()){
//            students.add(new Student(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
//        }
        Scanner sc = new Scanner(System.in);
        String username = null;
        String password = null;
        System.out.println("\n--------student login------\n");

        System.out.println("enter your username : ");
        username = sc.next();
        System.out.println("enter your password : ");
        password = sc.next();

        for(Student student : Student.students){
            if(username.equals(student.username) && password.equals(student.password)){
                studentMenu(student);
            }else{
                Student.login();
            }
        }
    }

    private static void studentMenu(Student student){
        int selection;
        do{
            selection = mainMenu();
            switch (selection){
                case 1:
                    student.seeBriefs(student);
                    break;
                case 0:
                    continue;
                default:
                    System.out.println("choose correct option please.");
                    break;
            }
        }while(selection != 0);
    }

    private static int mainMenu(){
        int selectNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n~~~~~~~~~~~~~~~~/STUDENT MENU\\~~~~~~~~~~~~~~~");
        System.out.println("\nSelect your action :");
        System.out.println("__________________________");
        System.out.println("1/ see briefs");
        System.out.println("\n0/ -----Disconnect-----");
        System.out.println("\nYour choice :");
        selectNum = sc.nextInt();
        return selectNum;
    }

    public void seeBriefs(Student student){
        System.out.println("\n--------Briefs to do-------");
        for (Brief brief : student.promo.briefs){
            System.out.println("\nbrief : "+brief.title);
            System.out.println("todo : "+brief.body);
            System.out.println("deadline : "+brief.deadline+" days");

        }

    }

}
