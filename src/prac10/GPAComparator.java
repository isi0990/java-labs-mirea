package prac10;

import java.util.Comparator;

public class GPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getAverageGrade(), s1.getAverageGrade()); // По убыванию
    }
}