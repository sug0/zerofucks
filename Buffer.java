public class Buffer
{
    // every 5 seconds flush buffer
    private final long NUM_SECONDS   = 5000000000L;
    private final int FLUSH_BUF_SIZE = 5000;

    private String data;
    private long startTime = System.nanoTime();

    // initialize buffer
    public Buffer()
    {
        data = new String();
    }

    public void append(char c)
    {
        data += c;
    }

    public void flushBufferedData()
    {
        System.out.print(data);
        data = "";
    }

    // prevent indefinitely looping
    // programs to output nothing
    public void flushDataLarge()
    {
        if ((data.length() >= FLUSH_BUF_SIZE)
        ||  (System.nanoTime() - startTime > NUM_SECONDS)) {
            startTime = System.nanoTime();
            flushBufferedData();
        }
    }
}
