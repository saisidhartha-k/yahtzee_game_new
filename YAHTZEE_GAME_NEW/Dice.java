package YAHTZEE_GAME_NEW;
import java.util.*;

public class Dice {
    public static final int no_of_dice = 5;
    public static final int no_of_rolls = 3;
    public Map<Integer, Integer> dice_map = new HashMap<>();

    public void roll_dice() {
        for (int i = 0; i < 5; i++) {
            int temp_key = 1 + (int) (Math.random() * ((6 - 1) + 1));
            dice_map.put(temp_key, dice_map.getOrDefault(temp_key, 0) + 1);
        }
        System.out.println(dice_map);
    }
}
