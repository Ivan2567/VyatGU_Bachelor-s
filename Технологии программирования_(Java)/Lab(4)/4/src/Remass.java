public class Remass <T extends Number>
{
    private T[] nums;
    public Remass (T... nums)
    {
        this .nums = nums;
    }
    public T[] mass()
    {
        return  nums;
    }
    public T[] newmass()
    {
        T dop =  nums[0];
        nums[0] = nums[1];
        nums[1] = dop;
        return  nums;
    }
}


