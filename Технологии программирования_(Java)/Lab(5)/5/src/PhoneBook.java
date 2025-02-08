import java.util.*;
public class PhoneBook
{
    private HashMap<String, List<String>> book;

    public PhoneBook(){
        this.book = new HashMap<>();
    }

    public void add(String sname, String phone){
        if(book.containsKey(sname))
        {
            List<String> phones = book.get(sname);
            if(phones.contains(phone))
            {
                System.out.println(phone + " уже существует для " + sname);
            }
            else
            {
                phones.add(phone);
                System.out.println("Добавлен " + sname + " тел: " + phone);
            }
        }
        else
        {
            book.put(sname, new ArrayList<>(Arrays.asList(phone)));
            System.out.println("Добавлен " + sname + " тел: " + phone);
        }
    }
    public List<String> get(String sname)
    {
        if(book.containsKey(sname))
        {
            return book.get(sname);
        }
        else
        {
            System.out.println("В справочнике нет записи для " + sname);
            return new ArrayList<>();
        }
    }
}
