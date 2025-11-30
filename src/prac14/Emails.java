package prac14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emails {
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] emails = {
                "user@example.com",
                "root@localhost",
                "myhost@@com.ru",
                "@my.ru",
                "Julia String",
                "name@mail.ru"
        };

        for (String email : emails) {
            System.out.println(email + " - " + (isValidEmail(email) ? "соответствует" : "не соответствует"));
        }
    }
}
