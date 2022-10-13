import java.util.ArrayList;
public class Promo {
    public static ArrayList<Promo> promos = new ArrayList<Promo>();

    public ArrayList<Student> students = new ArrayList<Student>();
    public ArrayList<Brief> briefs = new ArrayList<Brief>();

    public String name;
    public boolean haveTeacher = false;
    public Promo(String n){
        name = n;
    }

}

