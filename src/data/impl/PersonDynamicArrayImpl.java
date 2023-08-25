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
    public void deleteForName(Person person) {
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
    public void deleteForId (int... index) { // 1,3
        // person.length = 4
        //
        for (int i = 0; i < index.length; i++) {
            if (index[i] < 0 || index[i] >= persons.length) {
                System.err.println("Wrong input!!!");
                return;
            }
        }
        Person[] newPersons = new Person[persons.length - index.length];

        for (int i = 0, j = 0, k = 0; i < persons.length; i++) {
            if (k < index.length) {
                if (i == index[k]) {
                    k++;
                    continue;
                }
            }

            newPersons[j++] = persons[i];
        }
        persons = newPersons;
    }

    @Override
    public int size() {
        return persons.length;
    }
}
