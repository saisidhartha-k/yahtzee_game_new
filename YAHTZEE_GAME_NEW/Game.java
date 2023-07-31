package YAHTZEE_GAME_NEW;
import java.util.*;

public class Game {
    public static final int max_round = 13;
    public int round;
    public int score_arr[];
    public static Map<String, Integer> categorySums = new HashMap<>();
    public static String arr[] = {"Three of a Kind", "Four of a kind", "Full house",
            "Small Straight", "Large Straight", "YAHTZEE", "Choice"};
    public static String nums[] = {"one", "two", "three", "four", "five", "six"};

    public static void play_game() {
        for (int i = 1; i <= max_round; i++) {
            play_round(i);
        }
    }

    public static void play_round(int round_number) {
        Dice dice = new Dice();
        dice.roll_dice();
        Lowerpart.choose_category(dice.dice_map);
        UpperPart.upper_part(dice.dice_map);
        System.out.println(categorySums);
        System.out.println();

        boolean two_of_a_kind = false;
        String suggestedCategory = "";
        int maxKey = 0;

        //over here the code is considering the possibility of having two of a kind values for the first 6 rounds
        //because even after the first 6 rounds we still have chance to get better scores 
        for (Map.Entry<Integer, Integer> entry : dice.dice_map.entrySet()) {
            if (entry.getValue() >= 2) {
                two_of_a_kind = true;
                if (entry.getKey() > maxKey) {
                    maxKey = entry.getKey();
                    suggestedCategory = nums[entry.getKey() - 1];
                }
            }
        }

        if (two_of_a_kind && round_number <= 6) {
            System.out.println("Suggested category: " + suggestedCategory + ", " + "round number"+ " "+ round_number);
        } else {
            suggestedCategory = Category_suggester.suggestCategory(categorySums, round_number);
            System.out.println("Suggested category: " + suggestedCategory + ", " + "round number"+ " "+ round_number);
        }
        System.out.println();
        categorySums.clear();
    }
}
