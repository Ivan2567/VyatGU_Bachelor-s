import java.util.concurrent.*;
public class Tunnel extends Stage
{
    public Tunnel () {this .length =  80; this .description = "Тоннель "+ length + " метров" ;}
    private Semaphore S = new Semaphore(Mainapp.CARS_COUNT / 2);
    @Override public void go (Car c)
    {
        try
        {
            try
            { System.out.println(c.getName() + "готовится к этапу: (ждет) "+ description);
                S.acquire();
                System.out.println(c.getName() + " началэтап: "+ description);
                Thread.sleep(length / c.getSpeed() *  1000);

            }
            catch(InterruptedException e) { e.printStackTrace(); }
            finally
            {
                System.out.println(c.getName() +  " закончилэтап: "+ description);
                S.release();
            }
        }
        catch(Exception e) { e.printStackTrace(); }
    }
}
