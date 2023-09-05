package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.FileServiceInter;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import model.Teacher;
import files.impl.FileServiceImpl.*;

import javax.sql.rowset.WebRowSet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static util.InputUtil.inputRequiredString;
import static util.InputUtil.*;

public class DeleteHelper {

    public static void personDeleteForId(String personType) {


       int deleteCount = inputRequiredInt("How many student/teacher do you want to delete: ");
        int[] deleteArray = new int[deleteCount];
        int deleteIndex = 0;
        boolean isDeleted = false;

        if (GlobalData.personDynamicArrays.size() == 0 && GlobalData.personDynamicArrays == null) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }

        for (int i = 0; i < deleteCount; i++) {
            int deleteId = inputRequiredInt("Enter ID to delete: ");

            for (int j = 0; j < GlobalData.personDynamicArrays.size(); j++) {
                Person person = GlobalData.personDynamicArrays.get(j);
                if (personType.equals("Student") && person instanceof Student) {
                    Student student = (Student) person;
                    if (student.getId() == deleteId) {
                        deleteArray[deleteIndex] = j;
                        deleteIndex++;
                        FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Deleted in");
                    }
                }
                if (personType.equals("Teacher") && person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getId() == deleteId) {
                        deleteArray[deleteIndex] = j;
                        deleteIndex++;
                        FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Deleted in");
                    }
                }
            }
        }
        for (int i = 0; i < deleteIndex - 1; i++) {
            for (int j = i + 1; j < deleteIndex; j++) {
                if (deleteArray[i] < deleteArray[j]) {
                    int tempArray = deleteArray[i];
                    deleteArray[i] = deleteArray[j];
                    deleteArray[j] = tempArray;
                }
            }
        }
        for (int i = 0; i < deleteIndex; i++) {
            GlobalData.personDynamicArrays.deleteForId(deleteArray[i]);
            isDeleted = true;
        }
        if (isDeleted) {
            FileServiceImpl.getInstance().writeInformation("persons.txt");
        }
        System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
    }
}
