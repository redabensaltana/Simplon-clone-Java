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

    //public static void clearScreen(){
      //  System.out.print("\033[H\033[2J");
        //System.out.flush();
    //}


}

/*
import services.Courier;
import services.SendService;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        Courier.init("YOUR_AUTH_TOKEN_HERE");

        SendEnhancedRequestBody request = new SendEnhancedRequestBody();
        SendRequestMessage message = new SendRequestMessage();

        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", "bensaltana.reda@gmail.com");
        message.setTo(to);

        HashMap<String, Object> content = new HashMap<String, Object>();
        content.put("title", "Welcome!");
        content.put("community", "Thanks for signing up, {{name}}");
        message.setContent(content);

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name", "Peter Parker");
        message.setData(data);

        HashMap<String, Object> routing = new HashMap<String, Object>();
        routing.put("method", "single");
        routing.put("channels", ["email"]);
        message.setRouting(routing);

        request.setMessage(message);
        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(request);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
