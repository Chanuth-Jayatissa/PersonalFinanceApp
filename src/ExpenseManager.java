import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ExpenseManager {
    private static final String FILE_NAME = "expenses.txt";

    // Adds a new expense to the file
    public static void addExpense(String date, String category, double amount) {
        try {
            // Validate date format
            LocalDate.parse(date); // Will throw exception if format is invalid
            String formatted = date + "," + category + "," + amount;
            FileHandler.appendToFile(FILE_NAME, formatted);
            System.out.println("✅ Expense added successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid date format. Use YYYY-MM-DD.");
        }
    }

    // Displays all expenses
    public static void viewExpenses() {
        List<String> expenses = FileHandler.readFile(FILE_NAME);
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n--- All Expenses ---");
            for (int i = 0; i < expenses.size(); i++) {
                String[] parts = expenses.get(i).split(",");
                if (parts.length == 3) {
                    System.out.printf("[%d] Date: %s | Category: %s | Amount: $%.2f%n",
                            i + 1, parts[0], parts[1], Double.parseDouble(parts[2]));
                }
            }
        }
    }

    // Deletes an expense by its index (1-based)
    public static void deleteExpense(int index) {
        List<String> expenses = FileHandler.readFile(FILE_NAME);
        if (index < 1 || index > expenses.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }
        expenses.remove(index - 1);
        FileHandler.overwriteFile(FILE_NAME, expenses);
        System.out.println("✅ Expense deleted successfully.");
    }

    // Returns total expenses (used by ReportGenerator)
    public static double getTotalExpenses() {
        List<String> expenses = FileHandler.readFile(FILE_NAME);
        double total = 0;
        for (String line : expenses) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                try {
                    total += Double.parseDouble(parts[2]);
                } catch (NumberFormatException ignored) {}
            }
        }
        return total;
    }
}
