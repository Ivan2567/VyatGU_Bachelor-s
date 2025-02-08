public class Robot implements Action
{

    public void Runjump(Prep[] bariers)
    {
        int metr = 1;
        for (Prep i : bariers)
        {
            if (i instanceof Wall)
            {
                if (i.get() <= 3) { System.out.println("Робот успешно  перепрыгнул " + i.get() + " метров"); }
                else { System.out.println("Робот не смог перепрыгнуть " + i.get() + " метров"); metr = i.get() * 0; }

            }
            if (metr == 0 ){break;}
            if (i instanceof Rundist)
            {
                if ((i.get()) <= 180) { System.out.println("Робот успешно пробежал " + i.get() + " метров"); }
                else { System.out.println("Робот не смог пробежать " + i.get() + " метров"); metr = i.get() * 0; }
            }
            if (metr == 0 ){break;}
        }
            //return metr;
        }
};
