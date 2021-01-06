import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TownTest {

    @Mock
    public CountryImpl country;

    /*
    Проверка:
    ID = name
    Метод поиска по Name
    Должно быть уникальное имя
     */

    @Test
    public void TestConstructor(){

        String testNameTown = "Город";
        TownImpl town = new Town(testNameTown, country);
        Assert.assertEquals(testNameTown, town.getID());
        Assert.assertEquals(testNameTown, town.getName());
        Assert.assertEquals(MethodFind.Name, town.getMethodFind());
        Assert.assertEquals(country, town.getCountry());
        Assert.assertNotEquals(town.getName(), town.toString());
    }

    /*
    Проверка на двойную запись
     */
    @Test(expected=IllegalArgumentException.class)
    public void TestSaveDuplicate(){
        String testNameTown = "Город";
        TownImpl town = new Town(testNameTown, country);
        town.save();
        town.save();
    }
}
