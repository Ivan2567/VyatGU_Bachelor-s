import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static final int size = 60000000;
    static final int n = 6;

    public static void main(String[] args)
    {
        Finisharray1(Startarray());
        Finisharray2(Startarray());
    }
    private static float[] Startarray ()
    {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        return arr;
    }
    private static void Finisharray1 (float[] arr)
    {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время без разбивки " + (System.currentTimeMillis() - t1));
        System.out.println(arr[size -1]);
    }
    private static void Finisharray2 (float[] arr)
    {
        float[][] arrays = new float[n][size/n];
        long t2 = System.currentTimeMillis();
        for (int j = 0; j < n; j++)
        {
            System.arraycopy(arr, size/n * j, arrays[j], 0, size/n);
        }

        Thread myThreads[] = new Thread[n];
        for (int j = 0; j < n; j++) {
            int finalJ = j;
            myThreads[j] = new Thread(new Thread()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < size/n; i++)
                    {
                        arrays[finalJ][i] = (float) (arrays[finalJ][i] * Math.sin(0.2f + (i+size/n * finalJ) / 5) * Math.cos(0.2f + (i+size/n * finalJ) / 5) * Math.cos(0.4f + (i+size/n * finalJ) / 2));
                    }
                }
            });
            myThreads[j].start();
        }
        for (int j = 0; j < n; j++) {
            try {
                myThreads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < n; j++) {
            System.arraycopy(arrays[j], 0, arr, size/n * j, size/n);
        }


        System.out.println("Время с разбивкой " + (System.currentTimeMillis() - t2));
        System.out.println(arr[size-1]);
    }
}
// задача кол-ва потоков с равным распределением     готово