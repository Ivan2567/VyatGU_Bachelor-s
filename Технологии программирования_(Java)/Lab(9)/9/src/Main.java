import java.awt.*;
import java.lang.reflect.*;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws NoSuchMethodException
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Method m = AnClass.class.getMethod( "Tab" ,  null );
            Table annotation = m.getAnnotation(Table.class);

            Connection conn1 = DriverManager.getConnection
                    ( "jdbc:postgresql://localhost:5432/lab9","postgres","1111" );
            System.out.println("connect");
            Statement stmt1 = conn1.createStatement();
            System.out.println("CREATE TABLE "+ (annotation.title()) + "();");
            stmt1.executeUpdate( "CREATE TABLE "+ (annotation.title()) + "();");
            System.out.println("create");
            stmt1.close();
            conn1.close();
            AnClass anClass = new AnClass();
            //Method[] method = AnClass.class.getDeclaredMethods();
            Connection conn2 = DriverManager.getConnection
                    (  "jdbc:postgresql://localhost:5432/lab9","postgres","1111"  );
            System.out.println("connect");
            String list = "";
            Statement stmt2 = conn2.createStatement();
            for(Method o : anClass.getClass().getDeclaredMethods())
            {
                if (o.getAnnotation(Columns.class) !=  null )
                {
                    try {
                        list += (" ADD COLUMN "+ (o.invoke(anClass)).toString())
                                .replace(",", "")
                                .replace("[", "")
                                .replace("]", "");
                        list += ",";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("ALTER TABLE " +annotation.title()+ list.substring(0,list.length()-1) +" ;");
            stmt2.executeUpdate("ALTER TABLE " +annotation.title()+ list.substring(0,list.length()-1) +" ;");
            System.out.println("alter");
            conn2.close();
            //AnClass anClass2= new AnClass();
            Connection conn3 = DriverManager.getConnection
                    (  "jdbc:postgresql://localhost:5432/lab9","postgres","1111"  );
            System.out.println("connect");
            String l = "";int i = 1;
            Statement stmt3 = conn3.createStatement();
            for(Method o : anClass.getClass().getDeclaredMethods())
            {
                if (o.getAnnotation(Obj.class) !=  null )
                {
                    try {
                        l += (o.invoke(anClass)).toString()
                                .replace("[", "")
                                .replace("]", "");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
            String arr1[] = l.split(", ", i*2);
            String obj = "", coln = "";
            for (int j = 0; j < arr1.length;j++)
            {
                if(j%2==0){obj+=arr1[j];obj+=", ";}
                if(j%2!=0) {coln+= arr1[j];coln+=", ";}
            }

            System.out.println("Insert into " +annotation.title()+
                    "("+coln.substring(0,coln.length()-2) +") values('"+obj.substring(0,obj.length()-2)+"') ;");
            stmt3.executeUpdate("Insert into " +annotation.title()+
                    "("+coln.substring(0,coln.length()-2) +") values('"+obj.substring(0,obj.length()-2)+"') ;");
            System.out.println("alter");
            conn3.close();
        } catch (ClassNotFoundException | SQLException e) { }
    }
}

