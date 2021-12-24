import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) throws EmptyStackException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваше выражение:");
        String[] prefix = in.nextLine().split(" ");
        Stack infix = new Stack();
        String a, b, c = "";
        try {
            for (int i = prefix.length-1; i >= 0; i--) {
                System.out.println(prefix[i]);
                switch (prefix[i]) {
                    case ("+"):
                        a = infix.pop().toString();
                        b = infix.pop().toString();
                        c = a + " + " + b;
                        infix.push(c);
                        break;
                    case ("-"):
                        a = infix.pop().toString();
                        b = infix.pop().toString();
                        c = a + " - " + b;
                        infix.push(c);
                        break;
                    case ("*"):
                        a = infix.pop().toString();
                        b = infix.pop().toString();
                        if (a.length() > 1 && b.length() > 1)
                            c = "(" + a + ")" + "*" + "(" + b + ")";
                        else if (a.length() > 1 && b.length() == 1)
                            c = "(" + a + ")" + "*" +  b;
                        else if (a.length() == 1 && b.length() > 1)
                            c = a + "*" + "(" + b + ")";
                        else
                            c = a + "*" + b;
                        infix.push(c);
                        break;
                    case ("/"):
                        a = infix.pop().toString();
                        b = infix.pop().toString();
                        if (a.length() > 1 && b.length() > 1)
                            c = " (" + a + ") " + "/" + " (" + b + ") ";
                        else if (a.length() > 1 && b.length() == 1)
                            c = " (" + a + ") " + "/" +  b;
                        else if (a.length() == 1 && b.length() > 1)
                            c = a + "/" + " (" + b + ") ";
                        else
                            c = a + "/" + b;
                        infix.push(c);
                        break;
                    default:
                        infix.push(prefix[i]);
                        break;
                }

            }
        }

        catch (EmptyStackException e) {
            System.out.println("Введите корректное выражение");
        }
        System.out.printf("Выражение в инфиксной форме: %s", infix.toString());

    }
}
