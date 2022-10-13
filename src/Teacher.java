import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teacher extends Account{
    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public Promo promo = null;
    public Teacher(String fname,String lname,String uname,String pass) {
        firstname = fname;
        lastname = lname;
        username = uname;
        password = pass;
    }

    public static void login() throws SQLException {
        Connection connection = new MyJDBC().connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM simplon_clone.teacher;");
        while(resultSet.next()){
            teachers.add(new Teacher(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        Scanner sc = new Scanner(System.in);
        String username = null;
        String password = null;
        System.out.println("\n--------teacher login------\n");

        System.out.println("enter your username : ");
        username = sc.next();
        System.out.println("enter your password : ");
        password = sc.next();
        for(Teacher teacher : Teacher.teachers){
            if(username.equals(teacher.username) && password.equals(teacher.password)){
                teacherMenu(teacher);
                //break;
            }else if(!username.equals(teacher.username) || !password.equals(teacher.password)){
                Teacher.login();
            }
        }

    }

    private static void teacherMenu(Teacher teacher){


        int selection;
        do{
            selection = mainMenu();
            switch (selection){
                case 1:
                    teacher.addStudentToPromo(teacher);
                    break;
                case 2:
                    addBriefToPromo(teacher);
                    break;
               // case 0:
                 //   break;
                default:
                    System.out.println("choose correct option please.");
                    break;
            }
        }while(selection != 0);

    }
    private static int mainMenu(){
        int selectNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n~~~~~~~~~~~~~~~~/TEACHER MENU\\~~~~~~~~~~~~~~~");
        System.out.println("\nSelect your action :");
        System.out.println("__________________________");
        System.out.println("1/ add student to promo");
        System.out.println("2/ add brief to promo");
        System.out.println("\n0/ -----Disconnect-----");
        System.out.println("\nYour choice :");
        selectNum = sc.nextInt();
        return selectNum;
    }

    private void addStudentToPromo(Teacher teacher){
        int choiceStudent;
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> newStudents = new ArrayList<Student>();
        System.out.println("\n/-------------Choose the student--------------/\n");
        //looping to get students with no promo and display them to choose
        for (Student student :
                Student.students) {
            if (student.promo == null){
                newStudents.add(student);
                System.out.println(newStudents.indexOf(student)+"/ "+student.firstname+" "+student.lastname);
            };
        }
        System.out.println("\nyour choice :");
        choiceStudent = sc.nextInt();

        //adding a student to promo
        for (Student student : Student.students){
            if (student.equals(newStudents.get(choiceStudent))){
                        student.promo = teacher.promo;
                        teacher.promo.students.add(student);
                        break;
            }
        }
      //  teacherMenu(teacher);
    }
    private static void  addBriefToPromo(Teacher teacher){
        String title,body;
        int deadline;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n/-------------enter brief infos--------------/");

        System.out.println("enter title:");
        title = sc.nextLine();
        System.out.println("enter body:");
        body = sc.nextLine();
        System.out.println("enter deadline:");
        deadline = sc.nextInt();
        teacher.promo.briefs.add(new Brief(title,body,deadline));
    }
}
