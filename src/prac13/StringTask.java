package prac13;

public class StringTask {
    public static void analyzeString(String str) {
        // 2. Последний символ
        System.out.println("Последний символ: " + str.charAt(str.length() - 1));

        // 3. Проверка окончания
        System.out.println("Заканчивается на '!!!': " + str.endsWith("!!!"));

        // 4. Проверка начала
        System.out.println("Начинается с 'I like': " + str.startsWith("I like"));

        // 5. Проверка содержания
        System.out.println("Содержит 'Java': " + str.contains("Java"));

        // 6. Позиция подстроки
        System.out.println("Позиция 'Java': " + str.indexOf("Java"));

        // 7. Замена символов
        System.out.println("Замена 'a' на 'o': " + str.replace('a', 'o'));

        // 8. Верхний регистр
        System.out.println("Верхний регистр: " + str.toUpperCase());

        // 9. Нижний регистр
        System.out.println("Нижний регистр: " + str.toLowerCase());

        // 10. Вырезание подстроки
        int javaIndex = str.indexOf("Java");
        if(javaIndex != -1) {
            System.out.println("Вырезанная подстрока: " +
                    str.substring(javaIndex, javaIndex + 4));
        }
    }

    public static void main(String[] args) {
        analyzeString("I like Java!!");
    }
}