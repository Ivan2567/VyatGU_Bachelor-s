import java.awt.*;
import java.lang.annotation.*;
import java.util.ArrayList;


@Retention (RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Table{String title() default "title"; }
@Retention (RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Columns{}
@Retention (RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Obj {}
public class AnClass
{
    @Table(title = "tablename")
    public void Tab() { System.out.println( "..." ); }
    @Columns
    public ArrayList column1()
    {
        ArrayList<String> col = new ArrayList<String>();
        col.add("email");//colname
        col.add("text");//coltype
        return col;
    }
    @Columns
    public ArrayList column2()
    {
        ArrayList<String> col = new ArrayList<String>();
        col.add("Name");
        col.add("text");
        return col;
    }
    @Obj
    public ArrayList<String> object()
    {
        ArrayList<String> obj = new ArrayList<String>();
        obj.add("java@mail.com");//stringinf
        obj.add("email ");//colname
        return obj;
    }
}
