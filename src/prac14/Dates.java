package prac14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dates {
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static boolean isValidDay(int day, int month, int year) {
        if (month == 2) {
            return day <= (isLeapYear(year) ? 29 : 28);
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    public static boolean isValidDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return false;
        }

        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|[2-9][0-9])\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        if (!matcher.matches()) {
            return false;
        }

        int day = Integer.parseInt(matcher.group(1));
        int month = Integer.parseInt(matcher.group(2));
        int year = Integer.parseInt(matcher.group(3));

        return isValidDay(day, month, year);
    }

    public static void main(String[] args) {
        String[] testDates = {"29/02/2000", "30/04/2003", "01/01/2003", "29/02/2001", "30-04-2003", "1/1/1899", "55/02/2003", "12/31/2001"};

        for (String date : testDates) {
            System.out.println(date + " - " + (isValidDate(date) ? "соответствует" : "не соответствует"));
        }
    }
}
