public class Utils
{
    public static void die(String msg)
    {
        System.err.println(msg);
        System.exit(1);
    }

    public static void stopExecutionWith(String msg)
    {
        System.out.println(msg);
        System.exit(0);
    }
}
