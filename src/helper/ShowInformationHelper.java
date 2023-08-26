package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import model.Person;
import model.Student;
import model.Teacher;

public class ShowInformationHelper {
    public static void seeInformation(String personType) {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher != null) {
                    System.out.println(teacher.toString());
                } else {
                    throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
                }
            }
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                if (student != null) {
                    System.out.println(student.toString());
                } else {
                    throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
                }
            }
        }
    }
}
