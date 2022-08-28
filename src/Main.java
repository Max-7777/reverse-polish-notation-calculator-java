import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat("########.########");

        boolean run = true;
        Scanner sc = new Scanner(System.in);

        Calc c = new Calc(ParseFile.parseOperatorData(), ParseFile.parseSymbolData());

        do {
            System.out.print("Input: ");
            String input = sc.nextLine();

            String result = df.format(c.solveRPN(input));
            System.out.println("Result: " + result);

            String symbolValue = c.symbolValue(Float.parseFloat(result));
            if (!symbolValue.equals("")) System.out.println("[" + symbolValue + "]");

            System.out.println("Again? <y/n>");
            if (sc.nextLine().equals("n")) run = false;

        } while (run);

        System.out.println("bye");
    }
}