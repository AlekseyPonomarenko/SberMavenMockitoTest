import java.util.Calendar;
import java.util.Date;

public interface UserImpl  extends MyObjectImpl {
    public TownImpl getTown();
    public Calendar getBirthday();
}
