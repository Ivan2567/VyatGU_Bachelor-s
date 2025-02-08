public class Wall implements Prep
{
    private int hei;

    public Wall(int height) {
        this.hei = height;
    }

    public int get (Action ochered) {return ochered.jump(hei);};
}
