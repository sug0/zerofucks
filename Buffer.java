public class Buffer
{
    private String data;
    private final int FLUSH_BUF_SIZE = 5000;

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
        if (data.length() >= FLUSH_BUF_SIZE)
            flushBufferedData();
    }
}
