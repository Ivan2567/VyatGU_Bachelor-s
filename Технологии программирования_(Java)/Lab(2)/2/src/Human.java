public class Human implements Action
{
    public void Runjump(Prep[] bariers)
    {

        int metr = 1;
        for (Prep i : bariers)
        {
            if (i instanceof Wall)
            {
                if (i.get() <= 2) { System.out.println("Человек успешно  перепрыгнул " + i.get() + " метров"); }
                else { System.out.println("Человек не смог перепрыгнуть " + i.get() + " метров"); metr = i.get() * 0; }
            }
            if (metr == 0 ){break;}
            if (i instanceof Rundist)
            {
                if ((i.get()) <= 120) { System.out.println("Человек успешно пробежал " + i.get() + " метров"); }
                else { System.out.println("Человек не смог пробежать " + i.get() + " метров"); metr = i.get() * 0; }
            }
            if (metr == 0 ){break;}
        }
        //return metr;
    };
}
