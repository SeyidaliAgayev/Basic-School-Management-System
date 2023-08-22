package model;

public class Teacher extends Employee{
    private String teacherClass;
    public Teacher() {
    }

    public Teacher(String surname, String name, int age, String username, String password, double salary, int id, String teacherClass) {
        super(surname, name, age, username, password, salary, id);
        this.teacherClass = teacherClass;
    }

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
                "teacherAge='" + getAge() + '\'' +
                "teacherSalary='" + getSalary() + '\'' +
                "teacherClass='" + teacherClass + '\'' +
                '}';
    }
}

