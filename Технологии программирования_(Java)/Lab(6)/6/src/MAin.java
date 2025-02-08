import java.util.Arrays;

public class MAin {
    static final int size = 10;
    static final int hsize = size / 2;

    public static void main(String[] args) {

        Finisharray1(Startarray());
        Finisharray2(Startarray());

    }

    private static float[] Startarray () {
        float[] arr = new float[size];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = 1;
//        }
        Arrays.fill(arr, 1); // вместо цикла for
        return arr;
    }


    private static void Finisharray1 (float[] arr) {

        System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("The total time for one array is ");
        System.out.println(System.currentTimeMillis() - a);
    }


    private static void Finisharray2 (float[] arr) {

        System.out.println(Arrays.toString(arr));
        float[] arr1 = new float[hsize];
        float[] arr2 = new float[hsize];
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, hsize);
        System.arraycopy(arr, hsize, arr2, 0, hsize);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        Thread calcOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread calcTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i+hsize) / 5) * Math.cos(0.2f + (i+hsize) / 5) * Math.cos(0.4f + (i+hsize) / 2));
                }
            }

        });
        calcOne.start();
        calcTwo.start();

        try {
            calcOne.join();
            calcTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, hsize);
        System.arraycopy(arr2, 0, arr, hsize, hsize);
        System.out.println(Arrays.toString(arr));
        System.out.println("The total time for two arrays is ");
        System.out.println(System.currentTimeMillis() - b);
    }
}
