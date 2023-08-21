package helper;

import data.PersonDynamicArrays;
import data.impl.PersonDynamicArrayImpl;
import model.Admin;
import model.Person;
import model.Student;
import model.Teacher;

public class ArrayHelper {
    static PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();

    public static boolean arrayChecker() {
        boolean isFound = false;
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Admin) {
                Admin admin = (Admin) person;
                isFound = true;
            } else if (person instanceof Student) {
                Student student = (Student) person;
                isFound = true;
            } else if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                isFound = true;
            } else {
                System.err.println("Person have not find!");
            }
        }
        return isFound;
    }
}

