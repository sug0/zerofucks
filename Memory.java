public class Memory
{
    // tape has 2^16 individual cells
    private final int TAPE_SIZE  = 65536;

    public int pointer;
    public long[] valuePointedBy = new long[TAPE_SIZE];

    // tape constructor
    public Memory()
    {
        // array is already initialized at 0;
        // start pointer at 0
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
