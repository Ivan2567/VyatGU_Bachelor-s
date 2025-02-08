import java.util.*;

public class App
{
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "1", "2", "3", "4", "5",
                "4", "3", "2", "3", "2",
                "3", "4", "3", "6", "3",
                "3", "3", "1", "3", "4"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Массив с повторами");
        System.out.println(words);
        System.out.println("Массив без повторов");
        System.out.println(unique);
        System.out.println("Частота встречаемости");
        for (String i : unique) {
            System.out.println(i + ": " + Collections.frequency(words, i));
        }

        PhoneBook phonebook = new PhoneBook();
        System.out.println(" ");

        phonebook.add("A", "11223344");
        phonebook.add("B", "22334411");
        phonebook.add("C", "22331144");
        phonebook.add("A", "22113344");
        phonebook.add("A", "22223344");
        System.out.println(" ");

        System.out.println("A");
        System.out.println(phonebook.get("A"));
        System.out.println("B");
        System.out.println(phonebook.get("B"));
        System.out.println("C");
        System.out.println(phonebook.get("C"));
        System.out.println("");


        System.out.println("D");
        System.out.println(phonebook.get("D"));
        System.out.println("");

        phonebook.add("A", "11223344");
        System.out.println(phonebook.get("A"));

    }
}
