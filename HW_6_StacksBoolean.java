package hw_6_stacksboolean;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 *
 * @author Jocelyn Louie
 */
public class HW_6_StacksBoolean {

    /**
     * This program evaluates boolean expressions and returns either true,
     * false, or raises an exception depending on whether or not the expression
     * the user typed in was valid.
     **/
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");
    public static final Pattern UNSIGNED_INT = Pattern.compile("\\d+.*?");

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter 1 to evaluate an expression or 2 to exit: ");
        int answer = reader.nextInt();
        //clearing scanner
        reader.nextLine();

        while (answer == 1) {
            System.out.print("Please type in a basic expression enclosed in parenthesis. Example: (6>=7): ");
            String expression = reader.nextLine();

            //checks if parenthesis are balanced in expression
            boolean balanced = isBalanced(expression);
            if (balanced == false) {
                System.out.println("Expression not balanced");
            } else {
                boolean result = evaluate(expression);
                System.out.println("The expression is: " + result);
            }

            //setting up next iteration
            System.out.print("Enter 1 to evaluate an expression or 2 to exit: ");
            answer = reader.nextInt();
            //clearing scanner
            reader.nextLine();
        }
    }

    public static boolean evaluate(String expression) {
        //numbers in expression
        Stack<Integer> nums = new Stack<>();
        //operators in expression
        Stack<Character> operators = new Stack<>();
        //result of expression
        Stack<Boolean> result = new Stack<>();
        boolean not = false;
        //replacing double characters with single char options for evaluation
        expression = expression.replace("||", "o");
        expression = expression.replace("&&", "a");
        expression = expression.replace("==", "e");
        expression = expression.replace(">=", "g");
        expression = expression.replace("<=", "l");
        expression = expression.replace("!=", "n");

        Scanner input = new Scanner(expression);
        //value to be pushed to stacks once sorted
        String next;

        while (input.hasNext()) {
            //next piece of expression is a number
            if (input.hasNext(UNSIGNED_INT)) {
                next = input.findInLine(UNSIGNED_INT);
                //wrapping to Integer object
                nums.push(new Integer(next));
            } else {
                //next piece of operation is not a number
                next = input.findInLine(CHARACTER);
                switch (next.charAt(0)) {
                    case '<': 
                    case '>': 
                    case 'e': 
                    case 'n': 
                    case 'a':
                    case 'o': 
                    case 'g': 
                    case 'l':
                    case '!': not = true; operators.push(next.charAt(0));break;
                    case ')':
                        evaluateStacks(nums, operators, result, not);break;
                    case '(':operators.push(next.charAt(0));break;
                    default:throw new IllegalArgumentException("Please type in an expressions enclosed in parenthesis");
                }
            }
        }
        if (result.isEmpty()) throw new IllegalArgumentException("Result Underflow");
        return result.pop();
    }

    public static void evaluateStacks(Stack<Integer> numbers, Stack<Character> operations, Stack<Boolean> result, boolean not) {
        int n2, n1;
        char op;
        
        //check that stacks have enough items in them
        if (operations.size() < 1) throw new IllegalArgumentException("No operation given");
        
        else if ((numbers.isEmpty()) || (result.size()>=2)) {
             //getting rid of extra ( in operations stack
            operations.pop();
            op = operations.pop();
            
            switch (op) {
                //and & or case needs to have another operation to evaluate expression
                case 'o':
                case 'a':
                    if (result.size() < 2) throw new IllegalArgumentException("Result underflow: too few expressions to evaluate");
                    boolean b2 = result.pop();
                    boolean b1 = result.pop();
                    if (op == 'o') result.push(b1 || b2);
                    else {result.push(b1 && b2);}
                    break;
                //only needs one expression to evaluate
                case '!':
                    if (result.size() < 1) throw new IllegalArgumentException("Result underflow: too few expressions to evaluate");
                    result.push(!(result.pop()));
                    break;
                default:throw new IllegalArgumentException("Illegal operation");
            }
        } else {
            //getting two numbers to evaluate
            n2 = numbers.pop();
            n1 = numbers.pop();
            op = operations.pop();

            //evaluate expression based on the operation on top of operations stack
            switch (op) {
                case '<':result.push(n1 < n2);break;
                case '>':result.push(n1 > n2);break;
                case 'e':result.push(n1 == n2);break;
                case 'n':result.push(n1 != n2);break;
                case 'g':result.push(n1 >= n2);break;
                case 'l':result.push(n1 <= n2);break;
                default:throw new IllegalArgumentException("Operator not recognized");
            }
        }
    }

    public static boolean isBalanced(String expression) {
        final char LEFT_NORMAL = '(';
        final char RIGHT_NORMAL = ')';
        Stack<Character> store = new Stack<>();
        boolean failed = false;
        
        for (int i = 0; !failed && (i < expression.length()); i++) {
            switch (expression.charAt(i)) {
                case LEFT_NORMAL:store.push(expression.charAt(i));break;
                case RIGHT_NORMAL: if (store.isEmpty() || (store.pop() != LEFT_NORMAL)) failed = true; break;
            }
        }return (store.isEmpty() && !failed);
    }
}//end of HW_6_StacksBoolean