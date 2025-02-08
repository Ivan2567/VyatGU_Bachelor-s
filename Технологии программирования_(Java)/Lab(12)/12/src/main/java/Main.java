//import Counters;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
                //.configure("")
                //.addAnnotatedClass(items.class)
        Session session = factory.openSession();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Item item = session.find(Item.class , 41L );
            System. out .println(item.getVersion()); // <-1
            item.setVal( 20);
            session.flush();
            System. out .println(item.getVersion()); // <-2
            item.setVal( 30);
            session.flush();
            System. out .println(item.getVersion()); // <-3
            session.getTransaction().rollback();
            session = factory.getCurrentSession();
            session.beginTransaction();
            item = session.find(Item.class , 41L );
            System. out .println(item.getVersion()); // <-1
            session.getTransaction().commit(); session.close();
/*
            new Thread(() -> {
                System.out.println( "Thread #1 started" );
                Session ssession = factory.getCurrentSession();
                ssession.beginTransaction();
                Item iitem = ssession.get(Item.class, 41L ); // <-version = 1
                iitem.setVal( 100);
                try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ssession.save(iitem);
                ssession.getTransaction().commit(); // version увеличиваетсядо2
                System.out.println( "Thread #1 committed" );
                if(ssession != null ) { ssession.close(); }
                //countDownLatch.countDown();
            }).start();
            new Thread(() -> { System.out.println( "Thread #2 started" );
                Session ssession = factory.getCurrentSession();
                ssession.beginTransaction();
                Item iitem = ssession.get(Item.class, 41L ); // <-version = 1
                iitem.setVal( 200);
                try {
                    Thread.sleep( 3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    ssession.save(iitem); ssession.getTransaction().commit();
                    // в момент подтверждения транзакции во втором потоке производится сравнение
                    // версии при старте транзакции (1) и текущим значением версии (2)
                    System.out.println( "Thread #2 committed" ); }
                catch(OptimisticLockException e)
                { ssession.getTransaction().rollback();
                    System.out.println( "Thread #2 rollback" );
                    e.printStackTrace();
                }
                if(ssession != null ) { ssession.close(); }
                //countDownLatch.countDown();
            }).start();
            //try{
            //    countDownLatch.await();
            //} catch(InterruptedException e) {
            //    e.printStackTrace(); }
*/
        int[]answ = new int[8];
        //pu

        //for (int c = 0; c < 6; c++) {
           //int cr = Counters.getWait(c);
        //int[] wait = new int[]{5,10,20,50,100,150,200,250};

            CountDownLatch cdl = new CountDownLatch(8);
            for (int j = 0; j < 8; j++) {
                new Thread(() -> {
                    System.out.println("Threads started");
                    for (int i = 0; i < 20000; i++) {
                        Boolean b = true;
                        while (b == true)
                        {
                        Session ssession = factory.getCurrentSession();
                        ssession.beginTransaction();
                        long rand = ThreadLocalRandom.current().nextLong(42, 82);
                        Item iitem = ssession.get(Item.class, rand, LockMode.OPTIMISTIC);
                        int val = iitem.getVal();
                        iitem.setVal(val + 1);
                        try {
                            Thread.sleep(20 );

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ssession.save(iitem);

                        try {
                            ssession.getTransaction().commit();
                            b = false;
                        } catch (OptimisticLockException e) {
                            //e.printStackTrace();
                            Counters.setC1();
                        }

                        //ssession.getTransaction().commit();

                        if (ssession != null) {
                            ssession.close();
                        }
                    }
                    }
                    System.out.println("Thread committed");
                    cdl.countDown();
                }).start();
            }

            try{
                cdl.await();
            } catch(InterruptedException e) {
                e.printStackTrace(); }

            session = factory.getCurrentSession();
            session.beginTransaction();
            int sumValue = 0;
            List<Item> items = session.createQuery( "SELECT i FROM Item i " , Item. class )
                    .setLockMode(LockModeType. PESSIMISTIC_WRITE )
                    .getResultList();
            for (Item o : items)
            { sumValue += o. getVal() ; }
            session.getTransaction().commit();
            session.close();
            System.out.println( sumValue );
            //answ[c] = Counters.getC1();
        System.out.println(Counters.getC1());
        //}

        for (int a = 0; a < answ.length; a++) {
            // System.out.println(Counters.getC1(a));
        }

    }
}
// В зависимости от задержки смотреть кол-во Exeption
