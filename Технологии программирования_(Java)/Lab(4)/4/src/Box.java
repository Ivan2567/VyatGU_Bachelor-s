import java.util.*;
public class Box<T extends Frut >
{
    public double weight = 0.0;
    public List<T> frutList = new ArrayList();
    public List   frutList2 = new ArrayList();
    //T b = new T();
    public Box(T...fruts )
    {
        for(T i : fruts) {frutList.add(i); weight += i.getWeight();}
    }
    public void addFruit(T frut)
    {
        frutList.add(frut);
        weight = weight + frut.getWeight();
    }
    public double getWeight() {
        return weight ;
    }
    public boolean Compare(Box<?> another)
    {
        return (this.getWeight() == another.getWeight());
    }


    public void Peresipka (Box<T> another)
    {
        frutList2 = this.frutList;
        another.frutList.addAll(frutList2);
        another.weight = another.weight + this.getWeight();
        weight = 0.0;
        this.frutList.clear();
    }

    public void Peresipka (BBox<?> another)
    {
        frutList2 = this.frutList;
        another.frutList.addAll(frutList2);
       another.weight = another.getWeight() + this.getWeight();
        weight = 0.0;
        this.frutList.clear();
    }



    /*
    public void Peresipka (Box<?> another)
    {
        if(this.getClass() != another.getClass())
        {
            if(another.getClass() )
            {
                frutList2 = this.frutList;
                another.frutList.addAll(frutList2);
                another.weight = another.weight + this.getWeight();
                weight = 0.0;
                this.frutList.clear();
            }
        } else
        {
           int k = 0; int b = 1/k;
        }

     */
    
}
