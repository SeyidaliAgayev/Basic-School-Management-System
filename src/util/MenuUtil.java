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
                           <3> Delete Student For ID
                           <4> Delete Teacher For ID
                           <5> Update Student
                           <6> Update Teacher
                           <7> Block Student
                           <8> Block Teacher
                           <9> Open Block
                           <10> Search Student (For Name)
                           <11> Search Teacher (For Name)
                           <12> Admin Log in
                           <13> Search Student (For ID)
                           <14> Search Teacher (For ID)
                           <15> See All Information (Students)
                           <16> See All Information (Teachers)
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
