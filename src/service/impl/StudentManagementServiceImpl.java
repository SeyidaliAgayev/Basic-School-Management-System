package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;
import static util.MenuUtil.*;

public class StudentManagementServiceImpl implements StudentManagementServiceInter {
    @Override
    public void studentManagement() {
        StudentServiceInter studentServiceInter = new StudentServiceImpl();
        while (true) {
            try {
                int option = studentMenu();
                switch (option) {
                    case 1:
                        studentServiceInter.studentLogIn();
                        break;
                    case 2:
                        studentServiceInter.seeInfo();
                        break;
                    case 0:
                        System.exit(-1);
                    default:
                        throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                }
            } catch (ServiceExceptions exception) {
                System.err.println(exception.getMessage());
            } catch (RuntimeException exception) {
                System.err.println("Wrong Input!");
            }

        }
    }
}
