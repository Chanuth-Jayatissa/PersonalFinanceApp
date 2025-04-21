import java.util.List;

public class BudgetManager {
    private static final String FILE_NAME = "budget.txt";

    // Sets or updates the monthly budget
    public static void setBudget(double amount) {
        List<String> lines = List.of(String.valueOf(amount));
        FileHandler.overwriteFile(FILE_NAME, lines);
        System.out.println("✅ Monthly budget set to $" + String.format("%.2f", amount));
    }

    // Retrieves the current budget
    public static double getBudget() {
        List<String> lines = FileHandler.readFile(FILE_NAME);
        if (!lines.isEmpty()) {
            try {
                return Double.parseDouble(lines.get(0));
            } catch (NumberFormatException ignored) {}
        }
        return 0.0;
    }

    // Displays the current budget
    public static void viewBudget() {
        double budget = getBudget();
        System.out.println("📊 Current monthly budget: $" + String.format("%.2f", budget));
    }
}
