import java.util.Scanner;

public class LibraryApp {
    private Library library;
    private Scanner scanner;
    private boolean running;

    public LibraryApp() {
        library = new Library();
        scanner = new Scanner(System.in);
        running = true;
    }

    public void start() {
        System.out.println("====================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM");
        System.out.println("====================================");

        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            processMainMenuChoice(choice);
        }

        scanner.close();
        System.out.println("Thank you for using Library Management System!");
    }

    private void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Book Management");
        System.out.println("2. User Management");
        System.out.println("3. Book Transactions");
        System.out.println("4. View Reports");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");
    }

    private void displayBookMenu() {
        System.out.println("\n=== BOOK MANAGEMENT ===");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. View Available Books");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose an option (1-4): ");
    }

    private void displayUserMenu() {
        System.out.println("\n=== USER MANAGEMENT ===");
        System.out.println("1. Add New User");
        System.out.println("2. View All Users");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option (1-3): ");
    }

    private void displayTransactionMenu() {
        System.out.println("\n=== BOOK TRANSACTIONS ===");
        System.out.println("1. Issue Book");
        System.out.println("2. Return Book");
        System.out.println("3. View User's Borrowed Books");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose an option (1-4): ");
    }

    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                handleBookManagement();
                break;
            case 2:
                handleUserManagement();
                break;
            case 3:
                handleTransactionManagement();
                break;
            case 4:
                viewReports();
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("Invalid option! Please choose 1-5.");
        }
    }

    private void handleBookManagement() {
        boolean inBookMenu = true;
        while (inBookMenu) {
            displayBookMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    library.viewAvailableBooks();
                    break;
                case 4:
                    inBookMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-4.");
            }
        }
    }

    private void handleUserManagement() {
        boolean inUserMenu = true;
        while (inUserMenu) {
            displayUserMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    library.addUser();
                    break;
                case 2:
                    library.viewAllUsers();
                    break;
                case 3:
                    inUserMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-3.");
            }
        }
    }

    private void handleTransactionManagement() {
        boolean inTransactionMenu = true;
        while (inTransactionMenu) {
            displayTransactionMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    library.issueBook();
                    break;
                case 2:
                    library.returnBook();
                    break;
                case 3:
                    library.viewUserBooks();
                    break;
                case 4:
                    inTransactionMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-4.");
            }
        }
    }

    private void viewReports() {
        System.out.println("\n=== LIBRARY REPORTS ===");
        library.viewAllBooks();
        library.viewAllUsers();
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.start();
    }
}