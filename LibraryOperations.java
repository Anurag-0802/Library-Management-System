public interface LibraryOperations {
    void borrowBook(int bookId, User user);
    void returnBook(int bookId, User user);
    void searchBook(String keyword);
}
