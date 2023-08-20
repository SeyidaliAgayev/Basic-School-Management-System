package data.impl;


import data.PersonDynamicArrays;
import model.Person;


public class PersonDynamicArrayImpl implements PersonDynamicArrays {
    private Person[] persons = new Person[0];

    @Override
    public void add(Person person) {
        Person[] newPersons = new Person[persons.length + 1];

        for (int i = 0; i < persons.length; i++) {
            newPersons[i] = persons[i];
        }

        newPersons[newPersons.length - 1] = person;
        persons = newPersons;
    }

    @Override
    public Person get(int index) {
        if (index >= persons.length || index < 0) {
            System.out.println("Index is Wrong!");
            return null;
        } else {
            return persons[index];
        }
    }

    @Override
    public void delete(Person person) {
        Person[] newPersons = new Person[persons.length - 1];

        int newIndex = 0;

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != person) {
                newPersons[newIndex] = persons[i];
                newIndex++;
            }
        }
        persons = newPersons;
    }

    @Override
    public int size() {
        return persons.length;
    }
}
