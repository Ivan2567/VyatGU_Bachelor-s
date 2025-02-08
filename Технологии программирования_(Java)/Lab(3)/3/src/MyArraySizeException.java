public class MyArraySizeException extends Exception
{
    private int i;
    private int j;
    private String m;
    public MyArraySizeException(String message, int inum, int jnum){
        i = inum;
        j = jnum;
        m = message;
    }
    public int getNumberi(){return i;}
    public int getNumberj(){return j;}
    public String getMessage(){return m;}
}
