import java.util.ArrayList;

public class HelpStore {

    public static <T extends MyObjectImpl> void addToArray(ArrayList <T> arrayList, T e){

        //Поиск по наименованию, если есть, то не будем добавлять
        if (e.getMethodFind()==MethodFind.Name){
            if (findByName(arrayList, e.getName()) != null){
                return;
            }
        }
        else {
            if (findById(arrayList, e.getID()) != null){
                return;
            }
        }
        arrayList.add(e);
    }


    public static MyObjectImpl findByName(ArrayList <? extends MyObjectImpl> arrayList, String name){

        for (MyObjectImpl e: arrayList){
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public static MyObjectImpl findById(ArrayList <? extends MyObjectImpl> arrayList, String id){

        for (MyObjectImpl e: arrayList){
            if (e.getID().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public static void showArray(ArrayList <? extends MyObjectImpl> arrayList) {
        for (MyObjectImpl e : arrayList) {
            System.out.println(e);
        }
    }

}
