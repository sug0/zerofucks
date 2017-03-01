public class Memory
{
    // tape has 2^16 individual cells
    private static final int TAPE_SIZE  = 65536;

    private int pointer;
    private long[] valuePointedBy;

    // memory constructor
    public Memory()
    {
        valuePointedBy = new long[TAPE_SIZE];
        pointer = 0;
    }

    // trivial methods to abstract tape operations
    public void incrementCurrentCell()
    {
        valuePointedBy[pointer]++;
    }

    public void decrementCurrentCell()
    {
        valuePointedBy[pointer]--;
    }

    public void incrementPointer()
    {
        pointer++;
    }

    public void decrementPointer()
    {
        pointer--;
    }

    public int getCurrentCell()
    {
        return pointer;
    }

    public long getCurrentCellValue()
    {
        return valuePointedBy[pointer];
    }

    public void setCurrentCellValue(long newValue)
    {
        valuePointedBy[pointer] = newValue;
    }

    public String toString()
    {
        return "("
             + pointer
             + ", "
             + valuePointedBy[pointer]
             + ")";
    }
}
