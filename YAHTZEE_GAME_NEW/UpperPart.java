package YAHTZEE_GAME_NEW;


import java.util.*;
class UpperPart {
    public static void upper_part(Map<Integer, Integer> dice_map) {
        for (Map.Entry<Integer, Integer> entry : dice_map.entrySet()) {
            if (entry.getKey() == 1) {
                Game.categorySums.put("one", entry.getKey() * entry.getValue());
            }

            if (entry.getKey() == 2) {
                Game.categorySums.put("two", entry.getKey() * entry.getValue());
            }

            if (entry.getKey() == 3) {
                Game.categorySums.put("three", entry.getKey() * entry.getValue());
            }

            if (entry.getKey() == 4) {
                Game.categorySums.put("four", entry.getKey() * entry.getValue());
            }

            if (entry.getKey() == 5) {
                Game.categorySums.put("five", entry.getKey() * entry.getValue());
            }

            if (entry.getKey() == 6) {
                Game.categorySums.put("six", entry.getKey() * entry.getValue());
            }

        }

        List<String> all = Arrays.asList(Game.nums);
        for (String temp : all) {
            if (!Game.categorySums.containsKey(temp)) {
                Game.categorySums.put(temp, 0);
            }
        }
    }
}