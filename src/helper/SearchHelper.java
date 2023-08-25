package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import model.Person;
import model.Student;
import model.Teacher;

import static util.InputUtil.inputRequiredInt;
import static util.InputUtil.inputRequiredString;

public class SearchHelper {
    public static void personSearchForName(String personType) {
        if (GlobalData.personDynamicArrays.size() == 0 && GlobalData.personDynamicArrays == null) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
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
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
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

    public static Person personSearchForId(String personType) {
        Person finalPerson = null;
        int personId = inputRequiredInt("Please enter person's id to search: ");
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == personId) {
                    finalPerson = student;
                }
            }
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == personId) {
                    finalPerson = teacher;
                }
            }
        }
        if (finalPerson == null) {
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        return finalPerson;
    }
}
