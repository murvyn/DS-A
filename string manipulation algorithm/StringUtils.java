
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxOccurringChar(String str) {
        if (str == null || str.isEmpty()) {
            return ' ';
        }
        final int ACII_SIZE = 256;
        int[] frequencies = new int[ACII_SIZE];
        for (var ch : str.toCharArray()) {
            frequencies[ch]++;
        }

        int max = 0;
        char results = ' ';
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                results = (char) i;
            }
        }
        return results;
    }

    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }
        String[] words = sentence.trim().replaceAll(" +", " ").split(sentence);
        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null || first.isEmpty() || second.isEmpty()
                || first.length() != second.length()) {
            return false;
        }
        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static boolean areAnagrams2(String first, String second) {
        if (first == null || second == null || first.isEmpty() || second.isEmpty()
                || first.length() != second.length()) {
            return false;
        }
        final int ENGLISH_ALPHABETHS = 26;
        int[] frequencies = new int[ENGLISH_ALPHABETHS];

        first = first.toLowerCase();
        for (var i = 0; i < first.length(); i++) {
            frequencies[first.charAt(i) - 'a']++;
        }

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0) {
                return false;
            }
            frequencies[index]--;
        }
        return true;
    }

    public static boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
