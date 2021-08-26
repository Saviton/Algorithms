package grokking_algorithms.chapter_5;

import java.util.HashMap;
import java.util.Map;

public class CheckVoter {

    private static Map<String, Boolean> voted = new HashMap<>();

    public static void checkVoter(String name) {
        if (voted.containsKey(name.toLowerCase()))
            System.out.println("kick them out!");
        else {
            voted.put(name.toLowerCase(), true);
            System.out.println("let them vote");
        }
    }

    public static void main(String[] args) {
        checkVoter("Tom");
        checkVoter("Mike");
        checkVoter("Mike");
        checkVoter("Janna");
    }
}
