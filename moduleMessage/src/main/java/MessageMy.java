import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MessageMy implements MessageImlp{

    private static ArrayList <MessageImlp> store = new ArrayList<MessageImlp>();
    private UserImpl fromUser;
    private UserImpl toUser;
    private String text;
    private Calendar date;

    @Override
    public UserImpl getFromUser() {
        return fromUser;
    }

    @Override
    public UserImpl getToUser() {
        return toUser;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getName() {
        return super.toString();
    }

    @Override
    public String getID() {
        return super.toString();
    }

    @Override
    public MethodFind getMethodFind() {
        return MethodFind.Id;
    }

    @Override
    public void save() {
        HelpStore.addToArray(store, this);
    }


    public MessageMy(UserImpl fromUser, UserImpl toUser, String text) {
        this.fromUser=fromUser;
        this.toUser=toUser;
        this.text=text;
        this.date = new GregorianCalendar();
    }

    @Override
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd MMM yyy HH:mm:ss");

        return "Message{" +
                "fromUser=" + fromUser.getName() +
                ", toUser=" + toUser.getName() +
                ", text='" + text + '\'' +
                ", date=" + df.format(date.getTime()) +
                '}';
    }

    public static ArrayList <MessageImlp> getStore() {
        return store;
    }
}
