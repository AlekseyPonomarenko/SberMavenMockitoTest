import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class User implements UserImpl {

    private String name;
    private TownImpl town;
    private Calendar birthday;
    private static ArrayList <UserImpl> store = new ArrayList<UserImpl>();


    @Override
    public TownImpl getTown() {
        return town;
    }

    @Override
    public Calendar getBirthday() {
        return birthday;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public MethodFind getMethodFind() {
        return MethodFind.Name;
    }

    @Override
    public void save() {
        HelpStore.addToArray(store, this);
    }

    @Override
    public String getID() {
        return name;
    }

    @Override
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd MMM yyy");

        return "User{" +
                "name='" + name + '\'' +
                ", town=" + town.getName() +
                ", birthday=" + df.format(birthday.getTime())  +
                '}';
    }

    public User(String name, TownImpl town, Calendar birthday) {
        this.name=name;
        this.town=town;
        this.birthday=birthday;
    }

    public static ArrayList <UserImpl> getStore() {
        return store;
    }
}
