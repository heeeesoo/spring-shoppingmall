package exercise.etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sport_stars = new ArrayList<>();

        // add 5
        for (int i = 0; i < 5; i++) {
            sport_stars.add("hi");
        }
//        for (int i = 0; i < sport_stars.size(); i++) {
//            System.out.println(sport_stars.get(i));
//        }

        Iterator<String> sports_star_iterator = sport_stars.iterator();

        while (sports_star_iterator.hasNext()) {
            System.out.println(sports_star_iterator.next());
        }

        Map<Integer, String> fruits = new HashMap<>();

        fruits.put(1, "a");
        fruits.put(2, "b");
        fruits.put(3, "c");
        fruits.put(4, "d");
        fruits.put(5, "e");


        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i + 1));
        }

        Iterator<String> fruits_interator = fruits.values().iterator();

        while (fruits_interator.hasNext()) {
            System.out.println(fruits_interator.next());
        }

        for (Map.Entry<Integer, String> fruit : fruits.entrySet()) {
            System.out.println(fruit.getKey() + ": " + fruit.getValue());
        }

    }
}
