package util;
import static util.InputUtil.*;

public class MenuUtil {
    public static int entryMenu() {
        System.out.println("""
                           +++++++++++++++ Welcome to School Management System +++++++++++++++
                           Which one are you?
                           <1> Student
                           <2> Teacher
                           <3> Admin
                           <0> Exit!
                           +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                           """
        );
        return inputRequiredInt("Please enter selection(1,2,3,4): ");
    }

    public static int adminMenu() {
        System.out.println("""
                           ++++++++++++++++++++++++++++++++++++++++++++
                           <1> Add Student
                           <2> Add Teacher
                           <3> Delete Student For Name
                           <4> Delete Teacher For Name
                           <5> Delete Student For ID
                           <6> Delete Teacher For ID
                           <7> Update Student
                           <8> Update Teacher
                           <9> Block Student
                           <10> Block Teacher
                           <11> Open Block
                           <12> Search Student (For Name)
                           <13> Search Teacher (For Name)
                           <14> Admin Log in
                           <15> Search Student (For ID)
                           <16> Search Teacher (For ID)
                           <17> Back To Log In
                           <0> Exit!
                           ++++++++++++++++++++++++++++++++++++++++++++
                           """

        );
        return inputRequiredInt("Please enter selection(1,2,3,4...): ");
    }
    public static int teacherMenu() {
        System.out.println("""
                           ++++++++++++++++++++++++++++++++++++++++++++
                           <1> Teacher Log In!
                           <2> See All Classes!
                           <3> See All Teachers!
                           <0> Exit!
                           ++++++++++++++++++++++++++++++++++++++++++++
                           """

        );
        return inputRequiredInt("Please enter selection(1,2,3,4...): ");
    }
    public static int studentMenu() {
        System.out.println("""
                           ++++++++++++++++++++++++++++++++++++++++++++
                           <1> Student Log In
                           <2> See Info!
                           <0> Exit!
                           ++++++++++++++++++++++++++++++++++++++++++++
                           """

        );
        return inputRequiredInt("Please enter selection(1,2,3,4...): ");
    }
}
