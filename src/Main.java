import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.returnList();
        System.out.println("First element of list " + list.get(0));
        list.remove(2);
        System.out.println("After remove list has " + list.size()+ " elements");
        list.clear();
        System.out.println("List: "+ list.size());
        System.out.println("Contains size after clear "+ list.contains("Size"));
    }
}