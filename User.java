import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
     return userId; 
    }

    public String getName() {
     return name;
    }

    public String getEmail() {
     return email; 
    }

    public List<Book> getBorrowedBooks() {
     return borrowedBooks; 
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < 5) { 
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    public boolean hasBook(Book book) {
        return borrowedBooks.contains(book);
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-15s | Email: %-20s | Books Borrowed: %d",
                userId, name, email, borrowedBooks.size());
    }
}
