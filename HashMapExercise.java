
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashMapExercise {
    public static void main(String[] args) throws Exception {
        System.out.println(findFirstNonRepeatingChar("a green apple"));
        System.out.println(findFirstRepeatedChar("a green apple"));
        
        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        System.out.println("done");

    }

    public static char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (var ch : str.toCharArray()) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for (var ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}

class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[6];

    public void put(int key, String value) {
        var index = hash(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }
        for (var entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        if (entries[index] != null) {
            for (var entry : entries[index]) {
                if (entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}