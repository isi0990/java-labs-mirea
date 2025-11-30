package prac14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passwords {
    public static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] passwords = {"F032_Password", "TrySpy1", "smart_pass", "A007"};

        for (String password : passwords) {
            System.out.println(password + " - " + (isStrongPassword(password) ? "надёжен" : "ненадёжен"));
        }
    }
}
