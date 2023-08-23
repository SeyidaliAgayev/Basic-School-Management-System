package helper;

import data.GlobalData;
import enums.StatusEnum;
import model.Person;
import model.Student;
import model.Teacher;

import static util.InputUtil.inputRequiredString;

public class DeleteHelper {
    public static void personDelete(String personType) {
        String personName = inputRequiredString("Please enter person's name to delete: ");
        boolean foundPerson = false;
        Student[] studentWithSameName = new Student[GlobalData.personDynamicArrays.size()];
        Teacher[] teacherWithSameName = new Teacher[GlobalData.personDynamicArrays.size()];
        int sameStudentCount = 0;
        int sameTeacherCount = 0;

        if (GlobalData.personDynamicArrays == null && GlobalData.personDynamicArrays.size() == 0) {
            System.out.println(StatusEnum.LIST_IS_EMPTY);
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
            System.out.println(StatusEnum.THERE_IS_NO_ANY_PERSON_WITH_THIS_NAME + ": " + personName);
        }
        if (sameStudentCount > 0) {
            System.out.println(StatusEnum.THERE_ARE_MANY_STUDENT_WITH_THIS_NAME + ": " + personName);
            String studentUsername = inputRequiredString("You should enter username to delete: ");
            for (int i = 0; i < sameStudentCount; i++) {
                Student student = studentWithSameName[i];
                if (student.getUsername().equals(studentUsername)) {
                    GlobalData.personDynamicArrays.delete(student);
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
                    GlobalData.personDynamicArrays.delete(teacher);
                    System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
                }
            }
        }
    }
}
