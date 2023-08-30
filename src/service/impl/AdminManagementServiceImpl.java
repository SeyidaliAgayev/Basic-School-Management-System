package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import service.AdminManagementServiceInter;
import service.AdminServiceInter;

import static util.MenuUtil.*;


public class AdminManagementServiceImpl implements AdminManagementServiceInter {
    @Override
    public void adminManagement() {

        AdminServiceInter adminServiceInter = new AdminServiceImpl();
        while (true) {
            try {
                int option = adminMenu();
                switch (option) {
                    case 1:
                        adminServiceInter.addStudent();
                        break;
                    case 2:
                        adminServiceInter.addTeacher();
                        break;
                    case 3:
                        adminServiceInter.deleteStudentForName();
                        break;
                    case 4:
                        adminServiceInter.deleteTeacherForName();
                        break;
                    case 5:
                        adminServiceInter.deleteStudentForId();
                        break;
                    case 6:
                        adminServiceInter.deleteTeacherForId();
                        break;
                    case 7:
                        adminServiceInter.updateStudent();
                        break;
                    case 8:
                        adminServiceInter.updateTeacher();
                        break;
                    case 9:
                        adminServiceInter.blockStudent();
                        break;
                    case 10:
                        adminServiceInter.blockTeacher();
                        break;
                    case 11:
                        adminServiceInter.openBlock();
                        break;
                    case 12:
                        adminServiceInter.searchForStudent();
                        break;
                    case 13:
                        adminServiceInter.searchForTeacher();
                        break;
                    case 14:
                        adminServiceInter.adminLogIn();
                        break;
                    case 15:
                        adminServiceInter.getStudentById();
                        break;
                    case 16:
                        adminServiceInter.getTeacherById();
                        break;
                    case 17:
                        adminServiceInter.seeAllStudentsInformation();
                        break;
                    case 18:
                        adminServiceInter.seeAllTeachersInformation();
                        break;
                    case 19:
                        new BaseManagementServiceImpl().baseManagement();
                        break;
                    default:
                        throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                }
            } catch (ServiceExceptions exception) {
                System.err.println(exception.getMessage());
            } catch (RuntimeException exception) {
                exception.printStackTrace();
            }

        }
    }
}
