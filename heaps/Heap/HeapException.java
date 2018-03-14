public class HeapException extends Exception
{
    private String message;
    public HeapException(String message)
    {
        this.message = message;
    }

    public String toString()
    {
        return message;
    }
}