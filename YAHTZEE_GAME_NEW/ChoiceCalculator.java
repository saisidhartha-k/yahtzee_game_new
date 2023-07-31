package YAHTZEE_GAME_NEW;
import java.util.*;

public class ChoiceCalculator {
    public static int choice_category(String category, Map<Integer, Integer> dice_map) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : dice_map.entrySet()) {
            if (entry.getValue() > 1) {
                sum = sum + entry.getKey() * entry.getValue();
            } else {
                sum = sum + entry.getKey();
            }
        }
        return sum;
    }
}