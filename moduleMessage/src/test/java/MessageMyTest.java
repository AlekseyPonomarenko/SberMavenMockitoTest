import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.GregorianCalendar;

@RunWith(MockitoJUnitRunner.class)
public class MessageMyTest {

    @Mock
    public UserImpl userFrom;

    @Mock
    public UserImpl userTo;

    @Test
    public void TestConstructor(){
        String testName = "ФИО";
        MessageImlp testObj = new MessageMy(userFrom, userTo, testName);
        Assert.assertEquals(testObj.getName(), testObj.getID());
        Assert.assertEquals(testName, testObj.getText());
        Assert.assertEquals(MethodFind.Id, testObj.getMethodFind());
        Assert.assertNotEquals(testObj.getName(), testObj.toString());
    }


    @Test(expected=IllegalArgumentException.class)
    public void TestSaveDuplicate(){
        String testName = "ФИО";
        MessageImlp testObj = new MessageMy(userFrom, userTo, testName);
        testObj.save();
        testObj.save();
    }



}
