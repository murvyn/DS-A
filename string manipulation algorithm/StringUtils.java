
import java.util.Arrays;
import java.util.Collections;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        String[] words = sentence.trim().split("");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

        // StringBuilder reversed = new StringBuilder();
        // for(int i = words.length - 1; i >= 0; i--) {
        // reversed.append(words[i] + " ");
        // }
        // return reversed.toString().trim();
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        return (str1.length() == str2.length()) && (str1 + str2).contains(str2);
    }
}
