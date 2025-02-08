public class Cat implements Action
{
    public void Runjump(Prep[] bariers)
    {
        int metr = 1;
        for (Prep i : bariers)
        {
            if (i instanceof Wall)
            {
                if (i.get() <= 1) { System.out.println("Кот успешно  перепрыгнул " + i.get() + " метров"); }
                else { System.out.println("Кот не смог перепрыгнуть " + i.get() + " метров"); metr = i.get() * 0;}
            }
            if (metr == 0 ){break;}
            if (i instanceof Rundist)
            {
                if ((i.get()) <= 60) {System.out.println("Кот успешно пробежал " + i.get() + " метров");}
                else {System.out.println("Кот не смог пробежать " + i.get() + " метров"); metr = i.get() * 0;}
            }
            if (metr == 0 ){break;}
        }
        //return metr;
    };
}
