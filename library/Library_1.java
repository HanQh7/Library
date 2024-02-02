package library;
import java.util.*;
public class Library_1 {
	
		LinkedList<Book_1> books = new LinkedList<>(); // linked list is created
		public static void main(String[] args) {
			Library_1 library = new Library_1(); // object from library class
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
		System.out.println("\nMenu:");
		System.out.println("1) Add book details into the Library.");
		System.out.println("2) Remove a book from the Library.");
		System.out.println("3) Update book details.");
		System.out.println("4) Display the entire book.");
		System.out.println("5) Search a book based on the name.");
		System.out.println("6) Sort the entire book ascending.");
		System.out.println("7) Exit the program.");
		System.out.print("Enter your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1: // 1 to enter all books info
		System.out.print("Enter book name: ");
		String bookName = sc.nextLine();
		System.out.print("Enter author name: ");
		String authorName = sc.nextLine();
		System.out.print("Enter book section: ");
		String section = sc.nextLine();
		System.out.print("Enter book number: ");
		int bookNumber = sc.nextInt();
		sc.nextLine();
		library.addBook(bookName, authorName, section, bookNumber);
		break;
		case 2: // 2 to remove book by given number
		System.out.print("Enter book number to remove: ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		library.deleteBook(bookNum);
		break;
		case 3: // 3 to update book by given number
		System.out.print("Enter book number to update: ");
		int bookNumToUpdate = sc.nextInt();
		sc.nextLine();
		library.updateBook(bookNumToUpdate);
		break;
		case 4: // view all book info
		System.out.print("Enter book number to display: ");
		int bookNumToDisplay = sc.nextInt();
		sc.nextLine();
		library.displayBook(bookNumToDisplay);
		break;
		case 5:// search book info
		System.out.print("Enter book name to search: ");
		String bookNameToSearch = sc.nextLine();
		library.searchBook(bookNameToSearch);
		break;
		case 6: // sorting books
		library.sortBooks();
		break;
		case 7: // End the program
		System.out.println("Exiting the program.");
		System.exit(0);
		break;
		default:
		System.out.println("Invalid choice. Please try again.");
		}
		} while (choice != 7);
		}
		
		// THE METHODS
		
		void addBook(String bookName, String authorName, String section, int bookNumber) { // method to add book by adding all info
			Book_1 newBook = new Book_1(bookName, authorName, section, bookNumber);
		books.add(newBook); // add the book in stack
		System.out.println("Book added successfully.");
		waitForEnter();
		}
		void deleteBook(int bookNumber) { // method to remove book by deleting all info
		boolean found = false;
		Iterator<Book_1> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book_1 book = iterator.next();
		if (book.bookNumber == bookNumber) {
		found = true;
		iterator.remove();
		System.out.println("Book removed successfully.");
		break;
		}
		}
		if (!found) {
		System.out.println("Book not found.");
		}
		waitForEnter();
		}
		void updateBook(int bookNumber) { // method to update book info
		boolean found = false;
		Scanner sc = new Scanner(System.in);
		for (Book_1 book : books) { // books is the elements of linked list
		if (book.bookNumber == bookNumber) {
		found = true;
		System.out.print("Enter new book name: ");
		String newBookName = sc.nextLine();
		System.out.print("Enter new author name: ");
		String newAuthorName = sc.nextLine();
		System.out.print("Enter new book section: ");
		String newSection = sc.nextLine();
		book.bookName = newBookName;
		book.authorName = newAuthorName;
		book.section = newSection;
		System.out.println("Book updated successfully.");
		break;
		}
		}
		if (!found) {
		System.out.println("Book not found.");
		}
		waitForEnter();
		}
		void displayBook(int bookNumber) {// method to display all book info  
		boolean found = false;
		for (Book_1 book : books) { // book obj from class Book_Haneen1
		if (book.bookNumber == bookNumber) {
		found = true;
		System.out.println("Book Name: " + book.bookName);
		System.out.println("Author Name: " + book.authorName);
		System.out.println("Book Section: " + book.section);
		System.out.println("Book Number: " + book.bookNumber);
		break;
		}
		}
		if (!found) {
		System.out.println("Book not found.");
		}
		waitForEnter();
		}
		void searchBook(String bookName) { // method to search book by given name
		boolean found = false;
		for (Book_1 book : books) {
		if (book.bookName.equalsIgnoreCase(bookName)) {
		found = true;
		System.out.println("Book Name: " + book.bookName);
		System.out.println("Author Name: " + book.authorName);
		System.out.println("Book Section: " + book.section);
		System.out.println("Book Number: " + book.bookNumber);
		break;
		}
		}
		if (!found) {
		System.out.println("Book not found.");
		}
		waitForEnter();
		}
		void sortBooks() { // method to sort books by given name in ascending order
		books.sort(Comparator.comparing(book -> book.bookName));
		System.out.println("Books sorted in ascending order by name:");
		for (Book_1 book : books) {
		System.out.println("Book Name: " + book.bookName);
		System.out.println("Author Name: " + book.authorName);
		System.out.println("Book Section: " + book.section);
		System.out.println("Book Number: " + book.bookNumber);
		System.out.println("----------------------------");
		}
		waitForEnter();
		}
		void waitForEnter() { //method that waits for the user to press the Enter key before continuing execution
		Scanner sc = new Scanner(System.in);
		System.out.print("Press Enter to continue...");
		sc.nextLine();
		}
		}

	    
