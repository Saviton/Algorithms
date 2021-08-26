package grokking_algorithms.chapter_5;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static void main(String[] args) {
        Map<String, Integer> phoneBook = new HashMap<>();

        phoneBook.put("Masha", 292019532);
        phoneBook.put("Anton", 298742311);
        phoneBook.put("Artem", 338745231);
        phoneBook.put("Elena", 256613542);

        System.out.println(phoneBook);
        System.out.println("Masha's number: " + phoneBook.get("Masha"));


    }
}
