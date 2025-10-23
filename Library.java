import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;
    private List<User> users;
    private Scanner scanner;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeSampleData();
    }

    // Book Management
    public void addBook() {
        System.out.println("\n=== ADD NEW BOOK ===");

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        if (findBookById(bookId) != null) {
            System.out.println("Error: Book with ID " + bookId + " already exists!");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(bookId, title, author, isbn);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void viewAllBooks() {
        System.out.println("\n=== ALL BOOKS ===");
        if (books.isEmpty()) {
            System.out.println("No books available in the library!");
            return;
        }

        System.out.println("Total Books: " + books.size());
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void viewAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        boolean found = false;

        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books at the moment!");
        }
    }

    public void addUser() {
        System.out.println("\n=== ADD NEW USER ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        if (findUserById(userId) != null) {
            System.out.println("Error: User with ID " + userId + " already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        User user = new User(userId, name, email);
        users.add(user);
        System.out.println("User added successfully!");
    }

    public void viewAllUsers() {
        System.out.println("\n=== ALL USERS ===");
        if (users.isEmpty()) {
            System.out.println("No users registered!");
            return;
        }

        System.out.println("Total Users: " + users.size());
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
    }

    public void issueBook() {
        System.out.println("\n=== ISSUE BOOK ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already issued to someone else!");
            return;
        }

        if (user.getBorrowedCount() >= 5) {
            System.out.println("User has reached the maximum limit of 5 books!");
            return;
        }

        if (user.borrowBook(book)) {
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' issued successfully to " + user.getName());
        } else {
            System.out.println("Failed to issue book!");
        }
    }

    public void returnBook() {
        System.out.println("\n=== RETURN BOOK ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!user.hasBook(book)) {
            System.out.println("This book is not issued to this user!");
            return;
        }

        if (user.returnBook(book)) {
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' returned successfully by " + user.getName());
        } else {
            System.out.println("Failed to return book!");
        }
    }

    public void viewUserBooks() {
        System.out.print("\nEnter User ID to view borrowed books: ");
        String userId = scanner.nextLine();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        List<Book> borrowedBooks = user.getBorrowedBooks();
        System.out.println("\n=== BOOKS BORROWED BY " + user.getName().toUpperCase() + " ===");

        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
            return;
        }

        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooks.get(i).toShortString());
        }
    }

    private Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }
        return null;
    }

    private User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equalsIgnoreCase(userId)) {
                return user;
            }
        }
        return null;
    }

    private void initializeSampleData() {
        books.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        books.add(new Book("B002", "To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        books.add(new Book("B003", "1984", "George Orwell", "978-0451524935"));
        books.add(new Book("B004", "Pride and Prejudice", "Jane Austen", "978-0141439518"));

        users.add(new User("U001", "John Smith", "john.smith@email.com"));
        users.add(new User("U002", "Emma Wilson", "emma.wilson@email.com"));
        users.add(new User("U003", "Mike Johnson", "mike.johnson@email.com"));
    }
}
