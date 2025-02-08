import java.util.*;
/*
public class BBox<T extends Frut > extends Box
{
    public double weight = 0.0;
    public List<T> frutList = new ArrayList();
    public List   frutList2 = new ArrayList();
    //T b = new T();
    public BBox(T...fruts )
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


    @Override
    public void Peresipka (Box<T> another)
    {
        frutList2 = this.frutList;
        another.frutList.addAll(frutList2);
        another.weight = another.weight + this.getWeight();
        weight = 0.0;
        this.frutList.clear();
    }

 */

public class BBox< T extends Frut > extends Box
{

    public double weight = 0.0;
    public List<T> frutList = new ArrayList();
    public List   frutList2 = new ArrayList();
    //T b = new T();
    public BBox(T...fruts )
    {
        for(T i : fruts) {frutList.add(i); weight += i.getWeight();}
    }
    public void addFruit(Frut frut)
    {
        frutList.add((T) frut);
        weight = weight + frut.getWeight();
    }
    public double getWeight() {
        return weight ;
    }
    public boolean Compare(Box another)
    {
        return (this.getWeight() == another.getWeight());
    }

    @Override
    public void Peresipka (Box another)
    {
        frutList2 = this.frutList;
        another.frutList.addAll(frutList2);
        another.weight = another.weight + this.getWeight();
        weight = 0.0;
        this.frutList.clear();
    }


}
