import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class IncomeManager {
    private static final String FILE_NAME = "income.txt";

    // Adds a new income entry
    public static void addIncome(String date, String source, double amount) {
        try {
            LocalDate.parse(date); // Validates date format
            String formatted = date + "," + source + "," + amount;
            FileHandler.appendToFile(FILE_NAME, formatted);
            System.out.println("✅ Income added successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid date format. Use YYYY-MM-DD.");
        }
    }

    // Displays all income entries
    public static void viewIncome() {
        List<String> incomeEntries = FileHandler.readFile(FILE_NAME);
        if (incomeEntries.isEmpty()) {
            System.out.println("No income recorded.");
        } else {
            System.out.println("\n--- All Income ---");
            for (int i = 0; i < incomeEntries.size(); i++) {
                String[] parts = incomeEntries.get(i).split(",");
                if (parts.length == 3) {
                    System.out.printf("[%d] Date: %s | Source: %s | Amount: $%.2f%n",
                            i + 1, parts[0], parts[1], Double.parseDouble(parts[2]));
                }
            }
        }
    }

    // Returns total income (used by ReportGenerator)
    public static double getTotalIncome() {
        List<String> incomeEntries = FileHandler.readFile(FILE_NAME);
        double total = 0;
        for (String line : incomeEntries) {
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
