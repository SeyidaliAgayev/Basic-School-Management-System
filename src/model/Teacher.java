package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class Teacher extends Employee{
    private String teacherClass;
    public Teacher() {
    }

    public Teacher(String surname, String name, LocalDate age, String username, String password, double salary, int id, String teacherClass) {
        super(surname, name, age, username, password, salary, id);
        this.teacherClass = teacherClass;
    }

    @XmlElement
    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
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
}

