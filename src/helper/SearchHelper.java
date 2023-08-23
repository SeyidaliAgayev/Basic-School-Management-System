package helper;

import data.GlobalData;
import enums.StatusEnum;
import model.Person;
import model.Student;
import model.Teacher;

import static util.InputUtil.inputRequiredInt;
import static util.InputUtil.inputRequiredString;

public class SearchHelper {
    public static void personSearchForName(String personType) {
        Student[] studentsWithSameName = new Student[GlobalData.personDynamicArrays.size()];
        Teacher[] teacherWithSameName = new Teacher[GlobalData.personDynamicArrays.size()];
        boolean foundPerson = false;
        int sameTeacherCount = 0;
        int sameStudentCount = 0;

        String personName = inputRequiredString("Please enter person's name to search: ");
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                if (student.getName().equalsIgnoreCase(personName)) {
                    studentsWithSameName[sameStudentCount] = student;
                    sameStudentCount++;
                    foundPerson = true;
                }
            }
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getName().equalsIgnoreCase(personName)) {
                    teacherWithSameName[sameTeacherCount] = teacher;
                    sameTeacherCount++;
                    foundPerson = true;
                }
            }
        }
        if (!foundPerson) {
            System.err.println(StatusEnum.THERE_IS_NO_ANY_PERSON_WITH_THIS_NAME + ": " + personName);
        }
        if (sameStudentCount > 0) {
            for (int i = 0; i < sameStudentCount; i++) {
                Student student = studentsWithSameName[i];
                System.out.println(student.toString());
            }
        }
        if (sameTeacherCount > 0) {
            for (int i = 0; i < sameTeacherCount; i++) {
                Teacher teacher = teacherWithSameName[i];
                System.out.println(teacher.toString());
            }
        }
    }

    public static void personSearchForId(String personType) {
        int personId = inputRequiredInt("Please enter person's id to search: ");
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == personId) {
                    System.out.println(student.toString());
                } else {
                    System.err.println(StatusEnum.THERE_IS_NO_ANY_PERSON_WITH_THIS_ID + ": " + personId);
                }
            }
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == personId) {
                    System.out.println(teacher.toString());
                } else {
                    System.err.println(StatusEnum.THERE_IS_NO_ANY_PERSON_WITH_THIS_ID + ": " + personId);
                }
            }
        }
    }
}
