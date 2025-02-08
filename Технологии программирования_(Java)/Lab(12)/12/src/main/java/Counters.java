public class Counters {
    private static int c1 = 0;

    private static int[] wait = new int[]{5,10,20,50,100,150,200,250};
    public static int getWait(int i) {
        return wait[i];
    }
    public static int getC1() {
        return c1;
    }

    public static void setC1() {
        c1 = c1+1;
    }

    //public static void setC10() {
     //   c1 = 0;
    //}
}
