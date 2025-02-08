public class Rundist implements Prep
{
    private int dist;

    public Rundist(int distance) {
        this.dist = distance;
    }
    public int get (Action[] ochered) {return Math.abs(dist);}
}
