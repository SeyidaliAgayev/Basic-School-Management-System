package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import model.Teacher;

public class ShowInformationHelper {
    static FileServiceImpl fileService = new FileServiceImpl();
    public static void seeInformation(String personType) {
        boolean isFound = false;

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher != null) {
                    isFound = true;
                }
            }
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;
                if (student != null) {
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }

        if (personType.equals("Student")) {
            fileService.readInformation();
        } else if (personType.equals("Teacher")) {
            fileService.readInformation();
        } else {
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
    }
}
