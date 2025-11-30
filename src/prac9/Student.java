package prac9;

public class Student implements Comparable<Student> {
    private int iDNumber;
    private String name;
    private double gpa;

    public Student(int iDNumber, String name, double gpa) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getiDNumber() {
        return iDNumber;
    }

    public double getGPA() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    @Override
    public String toString() {
        return "Student{iDNumber=" + iDNumber + ", name='" + name + "', gpa=" + gpa + '}';
    }
}
