package data;
import model.Person;

public interface PersonDynamicArrays{
    void add(Person person);
    Person get(int index);
    void delete(Person person);
    int size();
}
