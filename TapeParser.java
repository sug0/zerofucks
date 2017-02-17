import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TapeParser
{
    private static int streamPointer, streamEnd, iterNumber;
    private static String tape;
    private static Buffer buf;

    // parser constructor
    public TapeParser(String filePath) throws IOException
    {
        buf        = new Buffer();
        tape       = new String(Files.readAllBytes(Paths.get(filePath)));
        streamEnd  = tape.length();
        iterNumber = 0;
    }

    // read another char in tape
    private static char streamCurrentPointerValue() throws IOException
    {
        return tape.charAt(streamPointer);
    }

    // set pointer back one position
    private static void seekBackStream() throws IOException
    {
        streamPointer--;
    }

    // set pointer one position ahead
    private static void seekAheadStream() throws IOException
    {
        streamPointer++;
    }

    // increment iteration number
    private static void newIteration()
    {
        iterNumber++;
    }

    // decrement iteration number
    private static void endIteration()
    {
        iterNumber--;
    }

    // cycle tape
    public static void eval(Memory m) throws IOException
    {
        for (streamPointer = 0; streamPointer < streamEnd; streamPointer++) {
            switch (streamCurrentPointerValue()) {
                case '-':
                    m.decrementCurrentCell();
                    break;
                case '+':
                    m.incrementCurrentCell();
                    break;
                case '<':
                    m.decrementPointer();
                    break;
                case '>':
                    m.incrementPointer();
                    break;
                case '.':
                    // store new byte in buffer
                    buf.append((char)m.getCurrentCellValue());
                    break;
                case ',':
                    m.setCurrentCellValue((long)System.in.read());
                    break;
                case '[':
                    if (m.getCurrentCellValue() == 0) {
                        seekAheadStream();

                        while (iterNumber > 0 || streamCurrentPointerValue() != ']') {
                            if (streamCurrentPointerValue() == '[')
                                newIteration();

                            if (streamCurrentPointerValue() == ']')
                                endIteration();

                            seekAheadStream();
                        }
                    }
                    break;
                case ']':
                    if (m.getCurrentCellValue() != 0) {
                        seekBackStream();

                        while (iterNumber > 0 || streamCurrentPointerValue() != '[') {
                            if (streamCurrentPointerValue() == ']')
                                newIteration();

                            if (streamCurrentPointerValue() == '[')
                                endIteration();

                            seekBackStream();
                        }

                        seekBackStream();
                    }
                    break;
                default:
                    // ignore other characters
                    break;
            }
        }
        // print buffer to stdout
        buf.flushBufferedData();
    }
}
