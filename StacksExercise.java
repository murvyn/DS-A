
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StacksExercise {

    public static void main(String[] args) {
        String str = "(<1 + 2))";
        Expression expression = new Expression();
        System.out.println(expression.isBalanced(str));
    }
}

class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }
            if (isRightBracket(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean isMatchingPair(char opening, char closing) {
        return leftBrackets.indexOf(opening) == rightBrackets.indexOf(closing);
    }
}
