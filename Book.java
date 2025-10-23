public class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getBookId() {
     return bookId; 
    }

    public String getTitle() {
     return title; 
    }

    public String getAuthor() {
     return author; 
    }

    public String getIsbn() {
     return isbn; 
    }

    public boolean isAvailable() {
     return isAvailable; 
    }

    public void setAvailable(boolean available) {
     this.isAvailable = available; 
    }

    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Issued";
        return String.format("ID: %-6s | Title: %-20s | Author: %-15s | ISBN: %-13s | Status: %s",
                bookId, title, author, isbn, status);
    }

    public String toShortString() {
        return title + " by " + author;
    }
}
