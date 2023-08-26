package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import model.Person;
import model.Student;
import model.Teacher;

import static util.InputUtil.inputRequiredString;
import static util.InputUtil.*;

public class DeleteHelper {

    public static void personDeleteForId(String personType) {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            if (GlobalData.personDynamicArrays.get(i) instanceof Student || GlobalData.personDynamicArrays.get(i) instanceof Teacher) {
                System.out.println(GlobalData.personDynamicArrays.get(i).toString());
            }

        }
        int[] deleteCount = inputRequiredIntArray("How many student/teacher do you want to delete: ");
        int[] deleteArray = new int[deleteCount.length];
        int deleteIndex = 0;

        if (GlobalData.personDynamicArrays.size() == 0 && GlobalData.personDynamicArrays == null) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                for (int j = 0; j < deleteCount.length; j++) {
                    int deleteId = inputRequiredInt("Enter ID to delete: ");
                    if (student.getId() == deleteId) {
                        deleteArray[deleteIndex] = i;
                        deleteIndex++;
                    }
                }
            }
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                for (int j = 0; j < deleteCount.length; j++) {
                    int deleteId = inputRequiredInt("Enter ID to delete: ");
                    if (teacher.getId() == deleteId) {
                        deleteArray[deleteIndex] = i;
                        deleteIndex++;
                    }
                }
            }
        }
        for (int i = deleteArray.length - 1; i >= 0 ; i--) {
            GlobalData.personDynamicArrays.deleteForId(deleteArray[i]);
        }

        System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
    }
    public static void personDeleteForName(String personType) {
        String personName = inputRequiredString("Please enter person's name to delete: ");
        boolean foundPerson = false;
        Student[] studentWithSameName = new Student[GlobalData.personDynamicArrays.size()];
        Teacher[] teacherWithSameName = new Teacher[GlobalData.personDynamicArrays.size()];
        int sameStudentCount = 0;
        int sameTeacherCount = 0;

        if (GlobalData.personDynamicArrays == null && GlobalData.personDynamicArrays.size() == 0) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                if (student.getName().equalsIgnoreCase(personName)) {
                    studentWithSameName[sameStudentCount] = student;
                    sameStudentCount++;
                    foundPerson = true;
                    break;
                }
            }
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getName().equalsIgnoreCase(personName)) {
                    teacherWithSameName[sameTeacherCount] = teacher;
                    sameTeacherCount++;
                    foundPerson = true;
                    break;
                }
            }
        }
        if (!foundPerson) {
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        if (sameStudentCount > 0) {
            System.out.println(StatusEnum.THERE_ARE_MANY_STUDENT_WITH_THIS_NAME + ": " + personName);
            String studentUsername = inputRequiredString("You should enter username to delete: ");
            for (int i = 0; i < sameStudentCount; i++) {
                Student student = studentWithSameName[i];
                if (student.getUsername().equals(studentUsername)) {
                    GlobalData.personDynamicArrays.deleteForName(student);
                    System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
                }
            }
        }
        if (sameTeacherCount > 0) {
            System.out.println(StatusEnum.THERE_ARE_MANY_TEACHER_WITH_THIS_NAME + ": " + personName);
            String teacherUsername = inputRequiredString("You should enter username to delete: ");
            for (int i = 0; i < sameTeacherCount; i++) {
                Teacher teacher = teacherWithSameName[i];
                if (teacher.getUsername().equals(teacherUsername)) {
                    GlobalData.personDynamicArrays.deleteForName(teacher);
                    System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
                }
            }
        }
    }
}
