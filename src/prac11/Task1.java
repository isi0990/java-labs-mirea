package prac11;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task1 {
    public static void main(String[] args) {
        String developer = "Иванов Иван";
        Date startDate = new Date();

        Date endDate = new Date(startDate.getTime() + 20 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Разработчик: " + developer);
        System.out.println("Дата получения: " + sdf.format(startDate));
        System.out.println("Дата сдачи: " + sdf.format(endDate));
    }
}