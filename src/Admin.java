import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User {
    private List<Book> books = new ArrayList<>();

    public Admin(String username) {
        super(username);
        // Start-Bücher

    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1: Show books");
            System.out.println("2: Add books");
            System.out.println("3: Delete books");
            System.out.println("4: End");

            choice = scanner.nextInt();
            scanner.nextLine(); // Puffer leeren

            switch (choice) {
                case 1 -> showBooks();
                case 2 -> addBook(scanner);
                case 3 -> deleteBook(scanner);
                case 4 -> System.out.println("End Admin Menu...");
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private void showBooks() {
        System.out.println("\n--- Book list ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void addBook(Scanner scanner) {
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Author:");
        String author = scanner.nextLine();
        System.out.println("Quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Puffer leeren

        int newId = books.size() + 1;
        books.add(new Book(newId, title, author, quantity));
        System.out.println(" Book added!");
    }

    private void deleteBook(Scanner scanner) {
        System.out.println("ID of the book to be deleted: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Puffer leeren

        books.removeIf(b -> b.getId() == id);
        System.out.println(" Book successfully deleted!");
    }
}