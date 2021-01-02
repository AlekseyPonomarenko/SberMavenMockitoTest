import java.util.ArrayList;

public class Town implements TownImpl {

    private String name;
    private static ArrayList <TownImpl> store = new ArrayList<TownImpl>();
    private CountryImpl country;

    @Override
    public CountryImpl getCountry() {
        return country;
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
        return "Town{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    public Town(String name, CountryImpl country) {
        this.name=name;
        this.country=country;
    }

    public static ArrayList <TownImpl> getStore() {
        return store;
    }
}
