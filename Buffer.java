public class Buffer
{
    private String data;

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
    }
}
