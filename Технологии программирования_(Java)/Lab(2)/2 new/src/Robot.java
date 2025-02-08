public class Robot implements Action
{
    int point = 1;
    public int jump (int hei)
    {
        if ((hei > 0) && (hei <= 3)) {
            System.out.println("Робот успешно  перепрыгнул " + hei + " метров");
        }
        else {System.out.println("Робот не смог перепрыгнуть " + hei + " метров");hei = hei * -1;}
        return hei;
    };
    public int run (int dist)
    {
        if ((dist > 0) && (dist <= 180)) {
            System.out.println("Робот успешно пробежал " + dist + " метров");
        }
        else {System.out.println("Робот не смог пробежать " + dist + " метров");dist = dist * -1;}
        return dist;
    };
}
