import java.util.ArrayList;

public class Country implements CountryImpl {

    private String name;
    private static ArrayList <CountryImpl> store = new ArrayList<CountryImpl>();


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
        return getName();
    }

    public Country(String name) {
        this.name=name;
    }

    public static ArrayList <CountryImpl> getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
