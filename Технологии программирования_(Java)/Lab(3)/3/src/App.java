public class App
{
    public static void main(String[] args) {

        try{
            String[][] s1 = new  String[][]{ { "0", "0", "0", "0" }, { "3", "0", "0", "0" },{ "0", "0", "0", "0" }, { "0", "0", "0", "0" } };
            CkladivatHochu r = new CkladivatHochu();
            int sum = r.matrix(s1);
            System.out.println("Сумма = " + sum);
    }

        catch(MyArraySizeException ex1){

            System.out.println(ex1.getMessage());
            System.out.println(ex1.getNumberi());
            System.out.println(ex1.getNumberj());
        }
        catch(MyArrayDataException ex2){

            System.out.println(ex2.getMessage());
            System.out.println(ex2.getNumberi());
            System.out.println(ex2.getNumberj());
        }
        finally {System.out.println("Расчет закончен");}

        try{
            String[][] s2 = new  String[][]{ { "0", "0", "0", "0" }, { "3", "0", "0", "0" },{ "0", "0", "0", "0" } };
            CkladivatHochu r = new CkladivatHochu();
            int sum = r.matrix(s2);
            System.out.println("Сумма = " + sum);
        }

        catch(MyArraySizeException ex1){

            System.out.println(ex1.getMessage());
            System.out.println(ex1.getNumberi());
            System.out.println(ex1.getNumberj());
        }
        catch(MyArrayDataException ex2){

            System.out.println(ex2.getMessage());
            System.out.println(ex2.getNumberi());
            System.out.println(ex2.getNumberj());
        }
        finally {System.out.println("Расчет закончен");}

        try{
            String[][] s3 = new  String[][]{ { "нечисло", "0", "0", "0" }, { "3", "0", "0", "0" },{ "0", "0", "0", "0" }, { "0", "0", "0", "0" } };
            CkladivatHochu r = new CkladivatHochu();
            int sum = r.matrix(s3);
            System.out.println("Сумма = " + sum);
        }

        catch(MyArraySizeException  ex1){

            System.out.println(ex1.getMessage());
            System.out.println(ex1.getNumberi());
            System.out.println(ex1.getNumberj());
        }
        catch(MyArrayDataException ex2){

            System.out.println(ex2.getMessage());
            System.out.println(ex2.getNumberi());
            System.out.println(ex2.getNumberj());
        }
        finally {System.out.println("Расчет закончен");}
    }
}
