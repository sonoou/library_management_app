# Library Management System

A comprehensive Java-based Library Management System that provides a command-line interface for managing books, users, and library transactions. This application demonstrates core Object-Oriented Programming principles through a practical, real-world system.

## 📚 Overview

The Library Management System is a multi-class Java application that allows librarians to efficiently manage book inventory, user registrations, and book lending operations through an intuitive CLI interface.

## ✨ Features

### Book Management
- **Add New Books**: Register new books with unique IDs, titles, authors, and ISBNs
- **View All Books**: Display complete book catalog with availability status
- **View Available Books**: Filter and show only books currently available for borrowing

### User Management
- **User Registration**: Add new library users with unique user IDs
- **User Directory**: View all registered users and their borrowing statistics
- **User Validation**: Prevent duplicate user registrations

### Book Transactions
- **Book Issuing**: Lend books to registered users with validation checks
- **Book Returns**: Process book returns and update availability status
- **Borrowing Limits**: Enforce maximum of 5 books per user
- **Borrow History**: View books currently borrowed by specific users

### System Features
- **Data Validation**: Comprehensive input validation and error handling
- **Duplicate Prevention**: Automatic check for duplicate book and user IDs
- **Availability Tracking**: Real-time book availability status
- **Sample Data**: Pre-loaded with sample books and users for testing

## 🏗️ System Architecture

### Class Structure

```
LibraryManagementSystem/
├── Book.java          # Represents book entity with properties and behaviors
├── User.java          # Manages user data and book borrowing operations
├── Library.java       # Core business logic and library operations
└── LibraryApp.java    # Main application with user interface
```

### Class Responsibilities

- **Book Class**: Encapsulates book properties (ID, title, author, ISBN, availability status)
- **User Class**: Manages user information and tracks borrowed books with borrowing limits
- **Library Class**: Handles all library operations including CRUD operations and transactions
- **LibraryApp Class**: Provides user interface and menu navigation system

## 🚀 Installation & Execution

### Prerequisites
- Java JDK 8 or higher
- VS Code, IntelliJ IDEA, or any Java-compatible IDE
- Terminal/Command Prompt

### Running the Application

#### Using VS Code
1. Create a new Java project in VS Code
2. Copy all four Java files into directory
3. Run `LibraryApp.java`

#### Using IntelliJ IDEA
1. Create a new Java project
2. Add all four Java classes to your project
3. Execute the `main` method in `LibraryApp.java`

#### Using Terminal/Command Line
```bash
# Compile all Java files
javac *.java

# Run the application
java LibraryApp
```

## 📖 User Guide

### Main Menu Navigation

The system features a hierarchical menu system:

1. **Book Management**
   - Add new books to the library catalog
   - View complete book inventory
   - Check available books for borrowing

2. **User Management**
   - Register new library users
   - View all registered users
   - Monitor user borrowing statistics

3. **Book Transactions**
   - Issue books to users (with validation checks)
   - Process book returns
   - View books borrowed by specific users

4. **View Reports**
   - Comprehensive overview of books and users
   - Quick system status check

### Key Operations

#### Adding a Book
- Provide unique Book ID, title, author, and ISBN
- System automatically sets book as available

#### Registering a User
- Create unique User ID, name, and email
- Users can borrow up to 5 books simultaneously

#### Issuing Books
- Verify user exists and hasn't reached borrowing limit
- Confirm book exists and is available
- Update book status and user's borrowed list

#### Returning Books
- Validate user and book existence
- Confirm book was actually borrowed by the user
- Update availability status

## 🛠️ Technical Implementation

### Object-Oriented Programming Principles

- **Encapsulation**: All classes use private fields with public getters/setters
- **Abstraction**: Complex operations simplified through method interfaces
- **Composition**: Library composed of Book and User collections
- **Modularity**: Separate concerns across different classes
- **Data Hiding**: Internal implementation details protected from external access

### Data Structures
- **ArrayList**: Dynamic collections for books and users
- **List Operations**: Efficient book and user management
- **Scanner Class**: Robust user input handling

### Validation & Error Handling
- Input type validation
- Duplicate ID prevention
- Business rule enforcement (borrowing limits, availability checks)
- User-friendly error messages

## 🎯 Learning Outcomes

This project demonstrates:
- Real-world OOP implementation
- Class design and relationships
- Collection management with ArrayList
- User input handling and validation
- Menu-driven application architecture
- Business logic implementation
- Error handling and data validation

## 🔧 Extensibility

The system can be enhanced with:
- Data persistence using file I/O or databases
- Advanced search and filtering capabilities
- Due date tracking and fine calculation
- Email notifications for overdue books
- Multiple user roles (librarian, member, admin)
- Statistical reporting and analytics
- Web-based or GUI interface

## 🤝 Contributing

Contributions are welcome! Feel free to fork this project and submit pull requests for any improvements or additional features.