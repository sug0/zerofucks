/**
 * TODO:
 * - test different exceptions,
 *   including ArrayIndexOutOfBoundsException
 **/

import java.io.IOException;
import java.io.FileNotFoundException;

public class ZeroFucks
{
    public static void main(String[] files) throws Exception
    {
        try {
            Memory tapeMemory = new Memory();
            TapeParser parser = new TapeParser(files[0]);

            parser.eval(tapeMemory);
        } catch (IOException e) {
            Utils.die("Error: couldn't find file " + files[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Utils.die("Error: no file provided");
        } catch (RuntimeException e) {
            Utils.die("Error: something occurred!");
        }
    }
}
