import java.util.Scanner;

public class BookService {
    private Book[] books;
    private int bookCount;

    public BookService() {
        books = new Book[10];
        books[0] = new Book(1, "Harry Potter", "J.K. Rowling", 3);
        books[1] = new Book(2, "Clean Code", "Robert C. Martin", 2);
        bookCount = 2;
    }

    public Book[] getBooks() {
        Book[] current = new Book[bookCount];
        System.arraycopy(books, 0, current, 0, bookCount);
        return current;
    }

    public void showBooks() {
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }

    public void addBook(Scanner sc) {
        if (bookCount >= books.length) {
            System.out.println("Maximum quantity reached!");
            return;
        }
        System.out.println("Title:");
        String title = sc.nextLine();
        System.out.println("Author:");
        String author = sc.nextLine();
        System.out.println("Quantity:");
        int qty = sc.nextInt();
        sc.nextLine();

        books[bookCount] = new Book(bookCount + 1, title, author, qty);
        bookCount++;
        System.out.println("Book added!");
    }

    public void deleteBook(Scanner sc) {
        System.out.println("Delete Book-ID:");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Book deleted!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void borrowBook(Scanner sc) {
        System.out.println("Borrow with Book-ID:");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                if (books[i].getQuantity() > 0) {
                    books[i].setQuantity(books[i].getQuantity() - 1);
                    System.out.println("Borrowed: " + books[i].getTitle());
                } else {
                    System.out.println("Not available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(Scanner sc) {
        System.out.println("Return Book with ID:");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                books[i].setQuantity(books[i].getQuantity() + 1);
                System.out.println("Returned: " + books[i].getTitle());
                return;
            }
        }
        System.out.println("Book not found.");
    }

}