package service.impl;

import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;
import static util.MenuUtil.*;
import model.Student;
import static helper.TimeHelper.*;
import static util.InputUtil.*;

import java.util.InputMismatchException;

public class StudentManagementServiceImpl implements StudentManagementServiceInter {
    private static StudentManagementServiceImpl instance = null;
    private StudentManagementServiceImpl() {

    }

    public static StudentManagementServiceImpl getInstance() {
        return instance == null ? new StudentManagementServiceImpl() : instance;
    }

    @Override
    public void studentManagement(Student student) {
        while (true) {
            try {
                int option = studentMenu();
                switch (option) {
                    case 1:
                        int questionCount = inputRequiredInt("Please insert number of questions which you want in exam: ");
                        timeCounter();
                        ExamManagementServiceImpl examManagementService = new ExamManagementServiceImpl();
                        String log = examManagementService.startExam(student.getUsername(), "QA.txt",questionCount );
                        FileServiceImpl.getInstance().writeLogToFile(student.getUsername(), log);
                        System.out.println();
                        System.out.println(StatusEnum.EXAM_ENDED);

                        break;
                    case 2:
                        StudentServiceImpl.getInstance().seeInfo();
                        break;
                    case 0:
                        System.exit(-1);
                    default:
                        throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                }
            } catch (ServiceExceptions exception) {
                System.err.println(exception.getMessage());
            } catch (InputMismatchException exception) {
                System.err.println("Wrong Input!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
