package com.java.JFSWE_2.Task3;

import java.util.Scanner;

public class Book {
	private int bookID;
	private String title;
	private String author;
	private boolean isAvailable;

	public Book(int bookID, String title, String author) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.isAvailable = true; // By default, a newly added book is available
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public static class Library {
		private Book[] books;
		private int totalBooks;

		public Library(int capacity) {
			books = new Book[capacity];
			totalBooks = 0;
		}

		public void addBook(Book book) {
			if (totalBooks < books.length) {
				books[totalBooks] = book;
				totalBooks++;
				System.out.println("Book added successfully.");
			} else {
				System.out.println("Library is full. Cannot add more books.");
			}
		}

		public void removeBook(int bookID) {
			for (int i = 0; i < totalBooks; i++) {
				if (books[i].getBookID() == bookID) {
					books[i].setAvailable(false);
					System.out.println("Book removed successfully.");
					return;
				}
			}
			System.out.println("Book with ID " + bookID + " not found.");
		}

		public void searchBook(int bookID) {
			for (int i = 0; i < totalBooks; i++) {
				if (books[i].getBookID() == bookID) {
					System.out.println("Book found:");
					System.out.println("ID: " + books[i].getBookID());
					System.out.println("Title: " + books[i].getTitle());
					System.out.println("Author: " + books[i].getAuthor());
					System.out.println("Availability: " + (books[i].isAvailable() ? "Available" : "Not Available"));
					return;
				}
			}
			System.out.println("Book with ID " + bookID + " not found.");
		}

		public void displayBooks() {
			if (totalBooks == 0) {
				System.out.println("No books in the library.");
			} else {
				System.out.println("Books in the library:");
				for (int i = 0; i < totalBooks; i++) {
					System.out.println("ID: " + books[i].getBookID() + ", Title: " + books[i].getTitle() + ", Author: "
							+ books[i].getAuthor() + ", Availability: "
							+ (books[i].isAvailable() ? "Available" : "Not Available"));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Library library = new Library(10); // Setting the library capacity to 10

		while (true) {
			System.out.println("\nLibrary Management System Menu:");
			System.out.println("1. Add Book");
			System.out.println("2. Remove Book");
			System.out.println("3. Search Book");
			System.out.println("4. Display Books");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Book ID: ");
				int bookID = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
				System.out.print("Enter Title: ");
				String title = scanner.nextLine();
				System.out.print("Enter Author: ");
				String author = scanner.nextLine();

				Book newBook = new Book(bookID, title, author);
				library.addBook(newBook);
				break;

			case 2:
				System.out.print("Enter Book ID to remove: ");
				int removeBookID = scanner.nextInt();
				library.removeBook(removeBookID);
				break;

			case 3:
				System.out.print("Enter Book ID to search: ");
				int searchBookID = scanner.nextInt();
				library.searchBook(searchBookID);
				break;

			case 4:
				library.displayBooks();
				break;

			case 5:
				System.out.println("Exiting Library Management System. Goodbye!");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}
}
