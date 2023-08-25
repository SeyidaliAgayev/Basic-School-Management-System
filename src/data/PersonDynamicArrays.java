package data;
import model.Person;

public interface PersonDynamicArrays{
    void add(Person person);
    Person get(int index);
    void deleteForName(Person person);
    void deleteForId(int... index);
    int size();
}
