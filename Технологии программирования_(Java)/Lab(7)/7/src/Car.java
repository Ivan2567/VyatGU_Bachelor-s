import java.util.concurrent.*;
public class Car implements Runnable
{
    private static int CARS_COUNT;
    static{ CARS_COUNT =  0;}
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier CB;
    private CountDownLatch CDL;
    public String  getName () { return name; }
    public int getSpeed () {  return speed; }
    public Car (Race race,  int speed, CyclicBarrier CB, CountDownLatch CDL )
    {
        this .race = race;
        this .speed = speed;
        CARS_COUNT++;
        this .name ="Участник#"+ CARS_COUNT;
        this.CB = CB;
        this.CDL = CDL;
    }
    @Override public void run ()
    {
        try
        {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            CB.await();
        } catch (Exception e) {e.printStackTrace();}

        for (int i = 0; i < race.getStages().size(); i++)
        {
            race.getStages().get(i).go(this);
        }
        int finishPlace = Mainapp.win ;
        if (finishPlace == 1)
        {
            System.out.println(this.name + " win");
            Mainapp.win++;
        }
        CDL.countDown();
    }
}

