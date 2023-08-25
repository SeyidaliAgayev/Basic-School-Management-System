package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import service.TeacherManagementServiceInter;
import service.TeacherServiceInter;
import static util.MenuUtil.*;

public class TeacherManagementServiceImpl implements TeacherManagementServiceInter {
    @Override
    public void teacherManagement() {
        TeacherServiceInter teacherServiceInter = new TeacherServiceImpl();
        while (true) {
            try {
                int option = teacherMenu();
                switch (option) {
                    case 1:
                        teacherServiceInter.teacherLogIn();
                        break;
                    case 2:
                        teacherServiceInter.seeAllClasses();
                        break;
                    case 3:
                        teacherServiceInter.seeAllTeachers();
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
