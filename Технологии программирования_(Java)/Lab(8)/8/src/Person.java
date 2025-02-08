public class Person
{
    enum Position { ENGINEER, DIRECTOR, MANAGER; }
    public String name;
    public int age;
    public Position position;
    public Person (String name,  int age, Position position)
    {
        this .name = name;
        this .age = age;
        this .position = position;
    }
}
