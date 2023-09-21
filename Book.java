import java.util.*;

public class Book {
    static HashMap<String, Integer> pb = new HashMap<>();
    public static void main(String[] args) {
        Map<String, HashSet<String>> map = new HashMap<>();

        updateBook(map, "Artem Artemich", "6665749" );
        updateBook(map, "Anna Annushka", "7705566" );
        updateBook(map, "Javokhir Salom", "7799566" );
        updateBook(map, "Lalala Tata", "6675566" );
        updateBook(map, "ASD Tata", "9999999" );
        updateBook(map, "ASD Tata", "8888888" );
        updateBook(map, "ASD Tata", "8888888" );

        List<Map.Entry<String, HashSet<String>>> sortBook = new ArrayList<>(map.entrySet());
        Collections.sort(sortBook, new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> entry1, Map.Entry<String, HashSet<String>> entry2) {

                int phoneCount1 = entry1.getValue().size();
                int phoneCount2 = entry2.getValue().size();


                return phoneCount2 - phoneCount1;
            }
        });

        for (Map.Entry<String, HashSet<String>> entry : sortBook) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static void updateBook(Map<String, HashSet<String>> map, String key, String value) {
        if (map.containsKey(key)) {
            HashSet<String> oldVal = map.get(key);
            oldVal.add(value);
        } else {
            HashSet<String> newList = new HashSet<>();
            newList.add(value);
            map.put(key, newList);
        }
    }
}
