public class Cat implements Action, Superjump
{
    public static void superjump (int shei) { System.out.println("Кот успешно перепрыгнул " + shei + " метров"); }
    public int jump (int hei)
    {
        superjump (hei);
        return hei;
    }
    public int run (int dist)
    {
        if ((dist > 0) && (dist <= 60)) {
            System.out.println("Кот успешно пробежал " + dist + " метров");
        }
        else {System.out.println("Кот не смог пробежать " + dist + " метров"); dist = dist * -1;}
        return dist;
    };
}
