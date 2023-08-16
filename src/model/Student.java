package model;

public class Student extends Person{
    private int id;
    private String email;
    private String studentClass;

    public Student() {
    }

    public Student(int id, String email,String studentClass, String password, String username) {
        this.id = id;
        this.studentClass = studentClass;
        this.email = email;
    }

    public Student(String surname, String name, int age, String username, String password, int id, String email, String studentClass) {
        super(surname, name, age, username, password);
        this.id = id;
        this.email = email;
        this.studentClass = studentClass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}
