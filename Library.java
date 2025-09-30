import java.util.ArrayList;

public class Library implements LibraryOperations {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void removeBook(int bookId) { books.removeIf(book -> book.getId() == bookId); }

    public void borrowBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    user.borrowedBooks.add(book);
                    System.out.println("Book borrowed successfully!");
                    return;
                } else {
                    System.out.println("Book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId, User user) {
        for (Book book : user.borrowedBooks) {
            if (book.getId() == bookId) {
                book.setBorrowed(false);
                user.borrowedBooks.remove(book);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("You have not borrowed this book.");
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No matching books found.");
    }

    public void listBooks() {
        for (Book book : books) System.out.println(book);
    }
}
