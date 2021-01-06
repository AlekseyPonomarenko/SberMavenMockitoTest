import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HelpStoreTest {

    @Mock
    public MyObjectImpl myObject1, myObject2, myObject3;

    ArrayList <MyObjectImpl> store;

    @Before
    public void before(){
        store = new ArrayList <>();
    }

    @Test
    public void testMethod() {

        store.clear();

        Mockito.when(myObject1.getName()).thenReturn("myObject1");
        Mockito.when(myObject1.getID()).thenReturn("myObject1");

        Mockito.when(myObject2.getName()).thenReturn("myObject2");
        Mockito.when(myObject2.getID()).thenReturn("myObject2");

        Mockito.when(myObject3.getName()).thenReturn("myObject3");
        Mockito.when(myObject3.getID()).thenReturn("myObject3");

        //Часть MethodFind.Name
        Mockito.when(myObject1.getMethodFind()).thenReturn(MethodFind.Name);
        Mockito.when(myObject2.getMethodFind()).thenReturn(MethodFind.Name);
        Mockito.when(myObject3.getMethodFind()).thenReturn(MethodFind.Name);

        HelpStore.addToArray(store, myObject1);
        HelpStore.addToArray(store, myObject2);
        HelpStore.addToArray(store, myObject3);
        Assert.assertEquals(3, store.size());

        //Часть findByName
        Assert.assertEquals("myObject3", HelpStore.findByName(store, "myObject3").getName());

        //Часть MethodFind.Id
        Mockito.when(myObject1.getMethodFind()).thenReturn(MethodFind.Id);
        Mockito.when(myObject2.getMethodFind()).thenReturn(MethodFind.Id);
        Mockito.when(myObject3.getMethodFind()).thenReturn(MethodFind.Id);
        store.clear();

        HelpStore.addToArray(store, myObject1);
        HelpStore.addToArray(store, myObject2);
        HelpStore.addToArray(store, myObject3);
        Assert.assertEquals(3, store.size());

        //Часть findById
        Assert.assertEquals("myObject3", HelpStore.findById(store, "myObject3").getName());
    }

    @Test(expected=IllegalArgumentException.class)
    public void TestSaveDuplicateName(){

        //Проверка на двойное сохранение
        store.clear();
        Mockito.when(myObject1.getName()).thenReturn("myObject1");
        //Mockito.when(myObject1.getID()).thenReturn("myObject1");
        Mockito.when(myObject1.getMethodFind()).thenReturn(MethodFind.Name);
        HelpStore.addToArray(store, myObject1);
        HelpStore.addToArray(store, myObject1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void TestSaveDuplicateId(){

        //Проверка на двойное сохранение
        store.clear();
        //Mockito.when(myObject1.getName()).thenReturn("myObject1");
        Mockito.when(myObject1.getID()).thenReturn("myObject1");
        Mockito.when(myObject1.getMethodFind()).thenReturn(MethodFind.Id);
        HelpStore.addToArray(store, myObject1);
        HelpStore.addToArray(store, myObject1);
    }

}
