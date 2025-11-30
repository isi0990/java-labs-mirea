package prac13;

public class Shirt {
    private String code;
    private String name;
    private String color;
    private String size;

    public Shirt(String code, String name, String color, String size) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Код: %s\nНазвание: %s\nЦвет: %s\nРазмер: %s\n",
                code, name, color, size);
    }

    public static Shirt[] fromStringArray(String[] shirts) {
        Shirt[] result = new Shirt[shirts.length];
        for(int i = 0; i < shirts.length; i++) {
            String[] parts = shirts[i].split(",");
            if(parts.length == 4) {
                result[i] = new Shirt(parts[0].trim(), parts[1].trim(),
                        parts[2].trim(), parts[3].trim());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        Shirt[] shirtObjects = Shirt.fromStringArray(shirts);
        for(Shirt shirt : shirtObjects) {
            System.out.println(shirt);
            System.out.println("----------");
        }
    }
}