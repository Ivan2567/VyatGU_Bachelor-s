import java.lang.reflect.Array;
import java.util.*;

public class MainApp
     {
         public static void main(String args[])
         {
             //Задание 1
             Remass<Integer> intRemass =  new Remass<Integer>( 1,  2,  3,  4,  5);
             System.out.println( "Старый массив: "+ Arrays.toString( intRemass.mass()));
             System.out.println( "Новый массив: "+ Arrays.toString(intRemass.newmass()));
             //Задание 2
             Integer[] mas=new Integer[]{1, 2, 3, 4};
             List m= new ArrayList<Integer>();
             Collections.addAll(m, mas);
             System.out.println(m);
             m.add(13);
             System.out.println(m);
             //List a= Arrays.asList(mas);
             //a.add(13); Ошибка, ведь List a полученный так имеет фикс. длинну
             //System.out.println(m);
             //Задание 3

             Box<Apple> ABox1 = new Box<>(new Apple());
             //ABox1.addFruit(new Apple());
             ABox1.addFruit(new Apple());
             ABox1.addFruit(new Apple());

             Box<Apple> ABox2 = new Box<>();
             ABox2.addFruit(new Apple());
             ABox2.addFruit(new Apple());
             //ABox1.addFruit(new Orange()); //  Ошибка

             Box<Orange> OBox = new Box<>();
             OBox.addFruit(new Orange());
             OBox.addFruit(new Orange());
             //OBox.addFruit(new Banana());
             //OBox.addFruit(new Apple()); // Ошибка

             System.out.println("Вес ABox1 " + ABox1.getWeight());
             System.out.println("Вес ABox2 " + ABox2.getWeight());
             System.out.println("Вес ОBox " + OBox.getWeight());

             System.out.println("Равны ли ABox1 и ОBox " + ABox1.Compare(OBox));
             System.out.println("Равны ли ABox2 и ОBox " + ABox2.Compare(OBox));
             ABox1.Peresipka(ABox2);
             System.out.println("Вес ABox1 после пересыпки " + ABox1.getWeight());
             System.out.println("Вес ABox2 после пересыпки " + ABox2.getWeight());


             //ABox1.Peresipka(OBox); // Ошибка

             //Создать Бананы с возможностью пересыпки в любую коробку.
             //Подправить конструктор класса Box для множественнго добавления типо
             // Box<Apple> ABox1 = new Box<>(new Apple(), new Apple(), new Apple());

             //Box<Apple> ABox1 = new Box<>(new Apple(), new Apple(), new Apple());
             /*
             Box<Banana> APBox1 = new Box<>(new Banana(),new Apple());
             APBox1.addFruit(new Apple());
             Box<Apple> APBox2 = new Box<>(new Banana(),new Apple());
             APBox2.addFruit(new Banana());
             */
             BBox<Banana> BBox1 = new BBox<>(new Banana());
             //BBox1.addFruit(new Apple());
             //BBox1.addFruit(new Orange());
             BBox1.Peresipka(OBox);
             //OBox.Peresipka(BBox1);
             BBox<Banana> BBox2 = new BBox<>(new Banana());
             BBox2.Peresipka(ABox1);
             //ABox1.Peresipka(BBox1);
             System.out.println("Вес ОBox после пересыпки " + OBox.getWeight());
             System.out.println("Вес ABox1 после пересыпки " + ABox1.getWeight());
         }
    }

