package calculator.history;

import java.util.*;

public class HistoryManager {

    private static final List<String> history = new ArrayList<>();

    // Add entry
    public static void add(String entry) {
        history.add(entry);
    }

    // Display history
    public static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No calculations yet.");
            return;
        }

        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    // Clear history (optional)
    public static void clear() {
        history.clear();
    }
}