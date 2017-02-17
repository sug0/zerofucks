import java.util.Scanner;
import java.io.IOException;

public class Interpreter
{
    private static TapeParser parser;
    private static Scanner stdin;

    public Interpreter()
    {
        parser = new TapeParser();
        stdin  = new Scanner(System.in);
    }

    public static void printPrompt()
    {
        System.out.print("bf% ");
    }

    public static void interpretEachLine() throws IOException
    {
        while (true) {
            printPrompt();

            if ((parser.tape = stdin.nextLine()).equals("exit()"))
                Utils.stopExecutionWith("Zero fucks given...");
            else
                parser.eval(new Memory());

            System.gc();
        }
    }
}
