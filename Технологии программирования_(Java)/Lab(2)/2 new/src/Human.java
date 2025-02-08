public class
Human implements Action
{
    public int jump (int hei)
    {
        if ((hei > 0) && (hei <= 2)) {
            System.out.println("Человек суспешно перепрыгнул " + hei + " метров");
        }
        else {System.out.println("Человек не смог перепрыгнуть " + hei + " метров");hei = hei * -1 ;}
        return hei;
    };
    public int run (int dist)
    {
        if ((dist > 0) && (dist <= 120)) {
            System.out.println("Человек суспешно пробежал " + dist + " метров");
        }
        else {System.out.println("Человек не смог пробежать " + dist + " метров");dist = dist * -1;}
        return dist;
    };
}
