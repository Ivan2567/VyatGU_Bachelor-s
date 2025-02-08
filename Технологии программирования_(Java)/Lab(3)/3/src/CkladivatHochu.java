import java.util.Arrays;

public class CkladivatHochu
{
    public int matrix (String[][] mass) throws MyArraySizeException//,MyArrayDataException
    {
        int i = 0;
        int j = 0;
        for ( i = 0; i < mass.length; i++)
        {
            for ( j = 0; j < mass[i].length; j++) { }
            if(!(j == 4)) throw new MyArraySizeException("Это не 4 на 4", i, j);
        }
        if(!(i == 4)) throw new MyArraySizeException("Это не 4 на 4", i, j);

        int[][] nums = { { 0, 0, 0, 0 }, { 3, 0, 0, 0 },{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        int summ = 0;
        for ( i = 0; i < mass.length; i++)
        {
            for ( j = 0; j < mass[i].length; j++)
            {
                try {
                    nums[i][j] = Integer.parseInt(mass[i][j]);
                   summ += nums[i][j];
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException ("Не то валяется в ", i, j);
                }
            }

        }
        return summ;
    }



}
