
import java.util.Map;
import java.util.HashMap;

public class HashMapExercise {
    public static void main(String[] args) throws Exception {
        System.out.println(findFirstNonRepeatingChar("a green apple"));

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
}
