import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class Admin extends Account{

    public Admin (){
        firstname = null;
        lastname = null;
        username = "admin";
        password = "password";
    }

    public void login() throws SQLException {
            Scanner sc = new Scanner(System.in);
            String username = null;
            String password = null;
            System.out.println("\n------------------------------");

            System.out.println("enter your username : ");
            username = sc.next();
            System.out.println("enter your password : ");
            password = sc.next();

            if(username.equals(this.username )&& password.equals(this.password)){
                adminMenu();
            }else if(!username.equals(this.username)|| !password.equals(this.password)){
                this.login();
            }
    }

    public void adminMenu() throws SQLException {
        int selection;
        do{
            selection = mainMenu();
            switch (selection){
                case 1:
                    this.addStudent();
                    break;
                case 2:
                    this.addTeacher();
                    break;
                case 3:
                    this.addPromo();
                    break;
                case 4:
                    this.givePromoToTeacher();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("choose correct option please.");
                    break;
            }
        }while(selection != 0);
    }
    private int mainMenu(){
        int selectNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n~~~~~~~~~~~~~~~~~/ADMIN MENU\\~~~~~~~~~~~~~~~");
        System.out.println("\nSelect your action :");
        System.out.println("__________________________");
        System.out.println("1/ create student");
        System.out.println("2/ create teacher");
        System.out.println("3/ create promo");
        System.out.println("4/ add promo to teacher");
        System.out.println("\n0/ -----Disconnect-----");
        System.out.println("\nYour choice :");
        selectNum = sc.nextInt();
        return selectNum;
    }

    //Actions
    private void addStudent() throws SQLException {
    String fname,lname,uname,pass,mail;
    Scanner sc = new Scanner(System.in);
        System.out.println("\n/-------------enter student infos--------------/");

        System.out.println("enter firstname:");
        fname = sc.next();
    System.out.println("enter lastname:");
        lname = sc.next();
    System.out.println("enter username:");
        uname = sc.next();
    System.out.println("enter password:");
        pass = sc.next();
        System.out.println("enter mail:");
        mail = sc.next();
    Student.students.add(new Student(fname,lname,uname,pass,mail));
//        Connection connection = new MyJDBC().connection();
//        Statement statement = connection.createStatement();
//        statement.execute("INSERT INTO `simplon_clone`.`student` (`firstname`, `lastname`, `username`, `password`, `mail`) VALUES ('"+fname+"','"+lname+"','"+uname+"','"+pass+"','"+mail+"');");

    //adminMenu();
    }
    private void addTeacher() throws SQLException {
        String fname,lname,uname,pass;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n/-------------enter teacher infos--------------/");

        System.out.println("enter firstname:");
        fname = sc.next();
        System.out.println("enter lastname:");
        lname = sc.next();
        System.out.println("enter username:");
        uname = sc.next();
        System.out.println("enter password:");
        pass = sc.next();
        Teacher.teachers.add(new Teacher(fname,lname,uname,pass));
//        Connection connection = new MyJDBC().connection();
//        Statement statement = connection.createStatement();
//        statement.execute("INSERT INTO `simplon_clone`.`teacher` (`firstname`, `lastname`, `username`, `password`) VALUES ('"+fname+"', "+lname+", '"+uname+"', '"+pass+"');");
       // adminMenu();
    }
    private void addPromo(){
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n/-------------enter promo infos--------------/");

        System.out.println("enter name:");
        name = sc.next();
        Promo.promos.add(new Promo(name));
        //adminMenu();
    }
    private void givePromoToTeacher() {
        int choiceTeacher,choicePromo;
        Scanner sc = new Scanner(System.in);

        ArrayList<Teacher> newTeachers = new ArrayList<Teacher>();
        System.out.println("\n/-------------Choose the teacher--------------/\n");
        //looping to get null promo teachers and display them to choose
        for (Teacher teacher :
                Teacher.teachers) {
            if (teacher.promo == null){
                newTeachers.add(teacher);
                System.out.println(newTeachers.indexOf(teacher)+"/ "+teacher.firstname+" "+teacher.lastname);
            };
        }
        System.out.println("\nyour choice :");
        choiceTeacher = sc.nextInt();

        //____________________________________________________________________

        ArrayList<Promo> newPromos = new ArrayList<Promo>();
        System.out.println("\n/-------------Choose the promo--------------/\n");
        //looping to get promo with no teacher and display them to choose
        for (Promo promo :
                Promo.promos) {
            if (promo.haveTeacher == false){
                newPromos.add(promo);
                System.out.println(newPromos.indexOf(promo)+"/ "+promo.name);
            };
        }
        System.out.println("\nyour choice :");
        choicePromo = sc.nextInt();

        //____________________________________________________________________

        //assining a promo to teacher
        for (Teacher teacher : Teacher.teachers){
            if (teacher.equals(newTeachers.get(choiceTeacher))){
                for (Promo promo : Promo.promos){
                    if (promo.equals(newPromos.get(choicePromo))){
                        promo.haveTeacher = true;
                        teacher.promo = promo;
                        break;
                    }
                }
                break;
            }
        }
        //adminMenu();


    }
}
