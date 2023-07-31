package YAHTZEE_GAME_NEW;
import java.util.*;

public class Category_suggester {
        public static String suggestCategory(Map<String, Integer> categorySums, int currentRound) {

        if (currentRound <= 6) {
            List<String> specialCategories = Arrays.asList("Full house", "YAHTZEE", "Small straight", "Large straight");
            int max_score = 0;
            String best_special_category = "";
            for (String category : specialCategories) {
                int score = categorySums.getOrDefault(category, 0);
                if (score > max_score) {
                    max_score = score;
                    best_special_category = category;
                }
            }

            if (max_score > 0) {
                return best_special_category;
            }

            int min_score = Integer.MAX_VALUE;
            String bestCategory = "";
            for (Map.Entry<String, Integer> entry : categorySums.entrySet()) {
                if (entry.getValue() < min_score && entry.getValue() > 0) {
                    min_score = entry.getValue();
                    bestCategory = entry.getKey();
                }
            }
            return bestCategory;
        } 
        else {
            int maxScore = 0;
            String bestCategory = "";
            for (Map.Entry<String, Integer> entry : categorySums.entrySet()) {
                if (entry.getValue() > maxScore) {
                    maxScore = entry.getValue();
                    bestCategory = entry.getKey();
                }
            }
            return bestCategory;
        }
    }
}