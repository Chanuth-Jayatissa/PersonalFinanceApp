import java.util.*;

public class ReportGenerator {
    private static final String FILE_NAME = "report.txt";

    // Generates and displays a financial report
    public static void generateReport() {
        double totalIncome = IncomeManager.getTotalIncome();
        double totalExpenses = ExpenseManager.getTotalExpenses();
        double budget = BudgetManager.getBudget();
        double remaining = budget - totalExpenses;

        // Console output
        System.out.println("\n====== Monthly Finance Report ======");
        System.out.printf("Total Income   : $%.2f%n", totalIncome);
        System.out.printf("Total Expenses : $%.2f%n", totalExpenses);
        System.out.printf("Monthly Budget : $%.2f%n", budget);
        System.out.printf("Remaining Budget: $%.2f%n", remaining);
        System.out.println("====================================");

        // Prepare lines for file
        List<String> reportLines = new ArrayList<>();
        reportLines.add("====== Monthly Finance Report ======");
        reportLines.add(String.format("Total Income   : $%.2f", totalIncome));
        reportLines.add(String.format("Total Expenses : $%.2f", totalExpenses));
        reportLines.add(String.format("Monthly Budget : $%.2f", budget));
        reportLines.add(String.format("Remaining Budget: $%.2f", remaining));
        reportLines.add("====================================");

        FileHandler.overwriteFile(FILE_NAME, reportLines);
        System.out.println("📄 Report saved to " + FILE_NAME);
    }
}
