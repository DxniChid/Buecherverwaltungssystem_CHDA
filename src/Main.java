import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookService service = new BookService();
        int choice = 0;

        while (choice != 3) {
            System.out.println("\n=== Login Menu ===");
            System.out.println("1: Login as Admin");
            System.out.println("2: Login as Customer");
            System.out.println("3: Exit");
            System.out.print("Your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> adminMenu(service, sc);
                case 2 -> customerMenu(service, sc);
                case 3 -> System.out.println("Program ended.");
                default -> System.out.println("Invalid input!");
            }
        }
        sc.close();
    }

    private static void adminMenu(BookService service, Scanner sc) {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1: Show Books");
            System.out.println("2: Add Books");
            System.out.println("3: Delete Books");
            System.out.println("4: Back to Login");
            System.out.print("Your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.showBooks();
                case 2 -> service.addBook(sc);
                case 3 -> service.deleteBook(sc);
                case 4 -> System.out.println("Admin Logout...");
                default -> System.out.println("Invalid input!");
            }
        }
    }

    private static void customerMenu(BookService service, Scanner sc) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1: Show Books");
            System.out.println("2: Borrow Book");
            System.out.println("3: Return Book");
            System.out.println("4: Search Book");
            System.out.println("5: Back to Login");
            System.out.print("Your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.showBooks();
                case 2 -> service.borrowBook(sc);
                case 3 -> service.returnBook(sc);
                case 4 -> searchBook(service, sc);
                case 5 -> System.out.println("Customer Logout...");
                default -> System.out.println("Invalid input!");
            }
        }
    }

    private static void searchBook(BookService service, Scanner sc) {
        System.out.println("Enter book title to search:");
        String title = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Book b : service.getBooks()) {
            if (b.getTitle().toLowerCase().contains(title)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with that title.");
        }
    }
}