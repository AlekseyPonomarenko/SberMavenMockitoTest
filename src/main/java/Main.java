import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        CountryImpl countryRussia =  new Country("Россия");
        countryRussia.save();

        new Country("Россия").save();
        new Country("Австралия").save();
        new Country("Италия").save();
        new Country("Канада").save();
        new Country("Кения").save();
        HelpStore.showArray(Country.getStore());

        TownImpl townRostovOnDon = new Town("Ростов-на-Дону", countryRussia);
        townRostovOnDon.save();
        new Town("Астрахань", countryRussia).save();
        new Town("Нижний Новгород", countryRussia).save();
        new Town("Дивногорск", countryRussia).save();
        HelpStore.showArray(Town.getStore());

        new User("Носов Иван", townRostovOnDon, new GregorianCalendar(1991, 1,1)).save();
        new User("Белякова Ольга", townRostovOnDon, new GregorianCalendar(1992, 2,2)).save();
        new User("Федосеева Инна", townRostovOnDon, new GregorianCalendar(1993, 3,3)).save();
        new User("Князева Валентина", townRostovOnDon, new GregorianCalendar(1994, 4,4)).save();
        new User("Иванова Светлана", townRostovOnDon, new GregorianCalendar(1995, 5,5)).save();

        HelpStore.showArray(User.getStore());


    }
}
