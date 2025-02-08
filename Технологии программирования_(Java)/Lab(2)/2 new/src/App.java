public class App
 {
     public static void main(String[] args)
    {
        Action[] ochered = new Action[3];
        ochered[0] = new Cat();
        ochered[1] = new Human();
        ochered[2] = new Robot();

        Prep[] bariers = new Prep[6];
        bariers[3] = new Rundist(60);
        bariers[4] = new Rundist(120);
        bariers[5] = new Rundist(180);
        bariers[0] = new Wall(1);
        bariers[1] = new Wall(2);
        bariers[2] = new Wall(3);

        for (Action i : ochered)
        {
            for (Prep j : bariers)
            {
               if(j.get(i) < 0){break;};
            }
        }
    }
}

