/**
 * TODO:
 * - test different exceptions,
 *   including ArrayIndexOutOfBoundsException
 **/

import java.io.IOException;

public class ZeroFucks
{
    public static void main(String[] args) throws Exception
    {
        try {
            // interpret until "exit()" is caught
            if (args[0].equals("interactive")) {
                Interpreter zeroFucks = new Interpreter();
                zeroFucks.interpretEachLine();
            } 

            TapeParser parser = new TapeParser(args[0]);
            parser.eval(new Memory());
        } catch (IOException e) {
            Utils.die("Error: couldn't find file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Utils.die("Error: no file provided");
        } catch (Exception e) {
            Utils.die("Error: something occurred!");
        }
    }
}
