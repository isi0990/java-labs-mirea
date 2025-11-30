package prac13;

import java.util.*;
import java.io.*;

public class WordChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        try {
            String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
            String[] words = content.split("\\s+");
            String result = getLine(words);
            System.out.println("Результат: " + result);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static String getLine(String... words) {
        if(words.length == 0) return "";

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder();
        result.append(wordList.remove(0));

        boolean found;
        do {
            found = false;
            for(int i = 0; i < wordList.size(); i++) {
                String current = wordList.get(i);
                if(Character.toLowerCase(result.charAt(result.length()-1)) ==
                        Character.toLowerCase(current.charAt(0))) {
                    result.append(" ").append(current);
                    wordList.remove(i);
                    found = true;
                    break;
                }
            }
        } while(found && !wordList.isEmpty());

        return result.toString();
    }
}