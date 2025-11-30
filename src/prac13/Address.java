package prac13;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    // Реализация через split()
    public void parseSplit(String address, String delimiter) {
        String[] parts = address.split(delimiter);
        if(parts.length >= 7) {
            this.country = parts[0].trim();
            this.region = parts[1].trim();
            this.city = parts[2].trim();
            this.street = parts[3].trim();
            this.house = parts[4].trim();
            this.building = parts[5].trim();
            this.apartment = parts[6].trim();
        }
    }

    // Реализация через StringTokenizer
    public void parseTokenizer(String address, String delimiters) {
        StringTokenizer tokenizer = new StringTokenizer(address, delimiters);
        if(tokenizer.countTokens() >= 7) {
            this.country = tokenizer.nextToken().trim();
            this.region = tokenizer.nextToken().trim();
            this.city = tokenizer.nextToken().trim();
            this.street = tokenizer.nextToken().trim();
            this.house = tokenizer.nextToken().trim();
            this.building = tokenizer.nextToken().trim();
            this.apartment = tokenizer.nextToken().trim();
        }
    }

    @Override
    public String toString() {
        return String.format("Страна: %s, Регион: %s, Город: %s, Улица: %s, Дом: %s, Корпус: %s, Квартира: %s",
                country, region, city, street, house, building, apartment);
    }

    public static void main(String[] args) {
        Address addr1 = new Address();
        addr1.parseSplit("Россия, Московская область, Москва, Ленина, 15, 2, 25", ",");
        System.out.println("Split: " + addr1);

        Address addr2 = new Address();
        addr2.parseTokenizer("Россия; Московская область; Москва; Ленина; 15; 2; 25", ";");
        System.out.println("Tokenizer: " + addr2);


    }
}