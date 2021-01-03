import java.util.Calendar;

public interface MessageImlp extends MyObjectImpl{
    public UserImpl getFromUser();
    public UserImpl getToUser();
    public String getText();
    public Calendar getDate();
}
