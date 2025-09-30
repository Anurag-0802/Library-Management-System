import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample books
        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(2, "Java Programming", "Herbert Schildt"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        User user = new User(101, "Alice");
        Admin admin = new Admin(1, "Admin");

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. List all books");
            System.out.println("2. Search book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Add book (Admin)");
            System.out.println("6. Remove book (Admin)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> library.listBooks();
                case 2 -> {
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                }
                case 3 -> {
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    library.borrowBook(borrowId, user);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId, user);
                }
                case 5 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully.");
                }
                case 6 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    library.removeBook(removeId);
                    System.out.println("Book removed if existed.");
                }
                case 0 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
