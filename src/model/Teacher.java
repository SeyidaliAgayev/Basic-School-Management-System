package model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Teacher extends Employee implements Serializable {
    private String teacherClass;
    private boolean isBlocked = false;
    public Teacher() {
    }

    public Teacher(String surname, String name, LocalDate age, String username, String password, double salary, int id, String teacherClass) {
        super(surname, name, age, username, password, salary, id);
        this.teacherClass = teacherClass;
    }


    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + getId() + '\'' +
                "teacherName='" + getName() + '\'' +
                "teacherSurname='" + getSurname() + '\'' +
                "teacherUsername='" + getUsername() + '\'' +
                "teacherAge='" + getBirthdate() + '\'' +
                "teacherSalary='" + getSalary() + '\'' +
                "teacherClass='" + teacherClass + '\'' +
                '}';
    }
    public String dataHistory() {
        return "Person with username: " + getUsername() + "logged in to system -> " +
                "Time: " + LocalDateTime.now();
    }
    public void blockTeacher() {
        this.isBlocked = true;
        System.out.println("Teacher: " + this.getId() + " " + this.getUsername() + " " + "has been blocked!");
    }
    public void unblockTeacher() {
        this.isBlocked = false;
        System.out.println("Teacher: " + this.getId() + " " + this.getUsername() + " " + "has been unblocked!");
    }
}

