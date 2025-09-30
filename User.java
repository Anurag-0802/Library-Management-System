import java.util.ArrayList;

public class User extends Person {
    public ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(int id, String name) {
        super(id, name);
    }
}
