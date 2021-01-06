import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.GregorianCalendar;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    public TownImpl town;

    /*
   Проверка:
   ID = name
   Метод поиска по Name
   Должно быть уникальное имя
    */
    @Test
    public void TestConstructor(){
        String testName = "ФИО";
        UserImpl testObj = new User(testName, town,  new GregorianCalendar(1991, 1,1));
        Assert.assertEquals(testName, testObj.getID());
        Assert.assertEquals(testName, testObj.getName());
        Assert.assertEquals(MethodFind.Name, testObj.getMethodFind());
        Assert.assertNotEquals(testObj.getName(), testObj.toString());
    }

    /*
    Проверка на двойную запись
     */
    @Test(expected=IllegalArgumentException.class)
    public void TestSaveDuplicate(){
        String testName = "ФИО";
        UserImpl testObj = new User(testName, town,  new GregorianCalendar(1991, 1,1));
        testObj.save();
        testObj.save();
    }

}
