package model;

public class StudentModel {
    private int studentId;
    private String studentName;
    private String studentClass;
    private String studentCourse;
    private String studentDateOfBirth;
    private int studentAge;
    private String studentAddress;
    private double studentCgpa;

    public StudentModel() {
    }

    public StudentModel(int studentId, String studentName, String studentClass, String studentCourse,
                        String studentDateOfBirth, int studentAge, String studentAddress, double studentCgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentCourse = studentCourse;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentAge = studentAge;
        this.studentAddress = studentAddress;
        this.studentCgpa = studentCgpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(String studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public double getStudentCgpa() {
        return studentCgpa;
    }

    public void setStudentCgpa(double studentCgpa) {
        this.studentCgpa = studentCgpa;
    }
}
