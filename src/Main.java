import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("📊 Welcome to the Personal Finance & Budgeting App");

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    ExpenseManager.addExpense(date, category, amount);
                }
                case "2" -> ExpenseManager.viewExpenses();
                case "3" -> {
                    System.out.print("Enter index of expense to delete: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    ExpenseManager.deleteExpense(index);
                }
                case "4" -> {
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Source: ");
                    String source = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    IncomeManager.addIncome(date, source, amount);
                }
                case "5" -> IncomeManager.viewIncome();
                case "6" -> {
                    System.out.print("Enter monthly budget: ");
                    double budget = Double.parseDouble(scanner.nextLine());
                    BudgetManager.setBudget(budget);
                }
                case "7" -> BudgetManager.viewBudget();
                case "8" -> ReportGenerator.generateReport();
                case "9" -> {
                    System.out.println("👋 Exiting app. Goodbye!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid option. Please try again.");
            }

            System.out.println(); // Extra line for spacing
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("""
            ----------------------------------------
            1. Add Expense
            2. View Expenses
            3. Delete Expense
            4. Add Income
            5. View Income
            6. Set Monthly Budget
            7. View Budget
            8. Generate Report
            9. Exit
            ----------------------------------------
        """);
    }
}
