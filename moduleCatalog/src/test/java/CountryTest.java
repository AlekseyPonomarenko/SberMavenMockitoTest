import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CountryTest {
    /*
    Проверка:
    ID = name
    Метод поиска по Name
    Должно быть уникальное имя
     */
    @Test
    public void TestConstructor(){
        String testNameCountry = "Страна";
        CountryImpl country = new Country(testNameCountry);
        Assert.assertEquals(testNameCountry, country.getID());
        Assert.assertEquals(testNameCountry, country.getName());
        Assert.assertEquals(MethodFind.Name, country.getMethodFind());
        Assert.assertNotEquals(country.getName(), country.toString());
    }

    /*
    Проверка на двойную запись
     */
    @Test(expected=IllegalArgumentException.class)
    public void TestSaveDuplicate(){
        String testNameCountry = "Страна";
        CountryImpl country = new Country(testNameCountry);
        country.save();
        country.save();
    }

}
