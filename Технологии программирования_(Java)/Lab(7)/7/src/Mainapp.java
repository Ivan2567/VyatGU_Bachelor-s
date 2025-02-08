import java.util.*;
import java.util.concurrent.*;
public class Mainapp
{
    public static final int CARS_COUNT =  4;
    private static ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
    public static  Integer win = 1;
    public static void main (String[] args)
    {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CyclicBarrier CB = new CyclicBarrier(CARS_COUNT + 1);
        CountDownLatch CDL = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), CB, CDL);
        }

        for (int i = 0; i < cars.length; i++)
        {
            executorService.execute(cars[i]);
        }
            try { CB.await();}
            catch (InterruptedException | BrokenBarrierException ex)
            {ex.printStackTrace();}
            finally
            {
               System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }

            try { CDL.await(); }
            catch (InterruptedException ex) {ex.printStackTrace(); }
            finally
            {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                 executorService.shutdown();
            }

    }
}





