package prac11;

import java.util.*;
import java.text.*;

class Student {
    private String name;
    private Calendar birthDate;

    public Student(String name, Calendar birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(String format) {
        SimpleDateFormat sdf;
        switch (format.toLowerCase()) {
            case "short":
                sdf = new SimpleDateFormat("dd.MM.yy");
                break;
            case "medium":
                sdf = new SimpleDateFormat("dd MMM yyyy");
                break;
            case "full":
                sdf = new SimpleDateFormat("d MMMM yyyy 'г.'");
                break;
            default:
                sdf = new SimpleDateFormat("dd.MM.yyyy");
        }
        return sdf.format(birthDate.getTime());
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', birthDate=" +
                getFormattedBirthDate("medium") + "}";
    }
}