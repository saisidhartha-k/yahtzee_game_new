package YAHTZEE_GAME_NEW;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lowerpart {

    public static void choose_category(Map<Integer, Integer> dice_map) {
        int sum = 0;
        if (dice_map.size() == 5) {
            sum = sum + 40;
            Game.categorySums.put("Large straight", sum);
        } else if (dice_map.size() >= 4) {
            SortedSet<Integer> sorted_val = new TreeSet<>(dice_map.keySet());
            int count = 1;
            int prev = sorted_val.first();
            for (int value : sorted_val) {
                if (value - prev == 1) {
                    count++;
                    if (count == 4) {
                        sum = sum + 30; // Score will be 30 for small straight
                        Game.categorySums.put("Small straight", sum);
                        break;
                    }
                } else {
                    count = 1;
                }
                prev = value;
            }
        }
        boolean threeOfAKind = false;
        boolean twoOfAKind = false;
        for (Map.Entry<Integer, Integer> entry : dice_map.entrySet()) {
            if (entry.getValue() == 3) {
                threeOfAKind = true;
            } else if (entry.getValue() == 2) {
                twoOfAKind = true;
            }
        }
        if (threeOfAKind && twoOfAKind) {
            sum = sum + 25;
            Game.categorySums.put("Full house", sum);
        }

        for (Map.Entry<Integer, Integer> entry : dice_map.entrySet()) {
            if (entry.getValue() == 3) {
                sum = sum + entry.getKey() * entry.getValue();
                Game.categorySums.put("Three of a kind", sum);
            } else if (entry.getValue() == 4) {
                sum = sum + entry.getKey() * entry.getValue();
                Game.categorySums.put("Four of a kind", sum);
            } else if (entry.getValue() == 5) {
                sum = sum + 50;
                Game.categorySums.put("YAHTZEE", sum);
            } else {
                int ans = ChoiceCalculator.choice_category("choice", dice_map);
                sum = sum + ans;
                Game.categorySums.put("Choice", ans);
            }
        }

        List<String> all = Arrays.asList(Game.arr);
        for (String temp : all) {
            if (!Game.categorySums.containsKey(temp)) {
                Game.categorySums.put(temp, 0);
            }
        }
    }
}

