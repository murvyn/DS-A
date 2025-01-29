
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapExercise {
    public static void main(String[] args) throws Exception {
        System.out.println(findFirstNonRepeatingChar("a green apple"));
        System.out.println(findFirstRepeatedChar("a green apple"));

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
