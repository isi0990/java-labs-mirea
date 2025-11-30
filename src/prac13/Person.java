package prac13;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder(lastName);

        if(firstName != null && !firstName.isEmpty()) {
            sb.append(" ").append(firstName.charAt(0)).append(".");
        }

        if(middleName != null && !middleName.isEmpty()) {
            sb.append(middleName.charAt(0)).append(".");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        Person person2 = new Person("Петров", "Петр", null);
        Person person3 = new Person("Сидоров", null, "Сидорович");

        System.out.println(person1.getFullName()); // Иванов И.И.
        System.out.println(person2.getFullName()); // Петров П.
        System.out.println(person3.getFullName()); // Сидоров С.
    }
}