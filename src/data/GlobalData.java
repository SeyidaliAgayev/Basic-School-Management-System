package data;

import classes.Classes;
import data.impl.DynamicArray;
import files.impl.FileServiceImpl;
import model.Admin;
import model.Answers;
import model.Person;
import model.Questions;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GlobalData implements Serializable{
    public static DynamicArray<Person> personDynamicArrays = new DynamicArray<>();
    public static DynamicArray<Classes> classesDynamicArray = new DynamicArray<>();
    public static Map<Questions, Answers> questionsAnswersMap;


    static {
        FileServiceImpl.getInstance().readInformation("persons.txt");
//        classesDynamicArray = FileServiceImpl.getInstance().readClassesDynamicArray("classes.txt");
        questionsAnswersMap = service.impl.FileServiceImpl.readQuestionsFromFile("QA.txt");
    }
}
