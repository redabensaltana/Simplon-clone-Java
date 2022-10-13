import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        int selection;
        do{
            selection = mainMenu();
            switch (selection){
                case 1:
                    Student.login();
                    break;
                case 2:
                    Teacher.login();
                    break;
                case 3:
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case 0:
                    System.out.println("Program exited.");
                    break;
                default:
                    System.out.println("choose correct option please.");
                    break;
            }
       }while(selection != 0);
    }

    private static int mainMenu(){
        int selectNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nSelect your account type :");
        System.out.println("__________________________");
        System.out.println("1/ student");
        System.out.println("2/ teacher");
        System.out.println("3/ admin");
        System.out.println("\n0/ -----Exit-----");
        System.out.println("\nYour choice :");
        selectNum = sc.nextInt();
        return selectNum;
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
