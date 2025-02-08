import com.sun.jdi.Value;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        //1
        List<String> words = Arrays.asList(
                "1", "2", "3", "4", "5",
                "4", "3", "2", "3", "2",
                "3", "4", "3", "6", "3",
                "3", "3", "1", "3", "4");
        Map<String, Long> s = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                //.reduce((i1, i2) -> i1 > i2 ? i1 : i2) .ifPresent(System.out::println)
                //.entrySet()
                //.stream()
                //.max(Map.Entry.comparingByValue())
                //.get().getKey();
                ;
        String word = s
                .entrySet()//Возвращаем значения типа Map.Entry<K(Key), V(Value)>.
                .stream()//Запихивам в поток
                .max(Map.Entry.comparingByValue())//Щем макскимальное значение повтора
                .get().getKey()//Получаем его ключ из потока
                ;
        System.out.println( "Результат: "+ word);

        //2
        List<Person> persons =  new ArrayList<>(Arrays.asList(
                new Person( "Ann" ,  35, Person.Position.MANAGER),
                new Person( "Bob" ,  44, Person.Position.DIRECTOR),
                new Person( "Cana" ,  25, Person.Position.ENGINEER),
                new Person( "Diana" ,  42, Person.Position.ENGINEER),
                new Person( "Frank" ,  55, Person.Position.MANAGER),
                new Person( "Gregor" ,  19, Person.Position.MANAGER),
                new Person( "Helen" ,  33, Person.Position.ENGINEER),
                new Person( "Jojo" ,  37, Person.Position.ENGINEER)));
        Double av_age = persons.stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println( "Средний возраст: "+ av_age);
        //3
        int n = 3;
        System.out.println(
                persons.stream()
                        .filter(x->x.position == Person.Position.ENGINEER)
                .sorted((o1, o2) -> o2.age -o1.age)
                .map((Function<Person, String>) person -> person.name)
                .limit(n)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining(", " ,n+" самых старших сотрудников в не алфавитном порядке зовут: " ,"" ))
                );
    }
}//добавить отделы, N старших + имена в обратном алфавитном порядке
// Закинуть все в поток(без листа)

