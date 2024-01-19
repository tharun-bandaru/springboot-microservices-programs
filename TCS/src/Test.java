import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class LibraryMangement {
	private String bookTitle;
	private String author;
	private boolean availability;
	private long price;
	private Date issueDate;
	private Date dueDate;

	// A list to store the library books
	private static List<LibraryMangement> libraryBooks = new ArrayList<>();

	public LibraryMangement(String bookTitle, String author, boolean availability, long price, Date issueDate, Date dueDate) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.availability = availability;
		this.price = price;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		libraryBooks.add(this); // Add the book to the library
	}

	// Method to retrieve book details based on author name
	public static List<LibraryMangement> getBooksByAuthor(String authorName) {
		List<LibraryMangement> booksByAuthor = new ArrayList<>();
		for (LibraryMangement book : libraryBooks) {
			if (book.getAuthor().equalsIgnoreCase(authorName)) {
				booksByAuthor.add(book);//lib1,lib2
			}
		}
		return booksByAuthor;
	}

	// Method to retrieve book details between two issue dates
	public static List<LibraryMangement> getBooksBetweenDates(Date startDate, Date endDate) {
		List<LibraryMangement> booksBetweenDates = new ArrayList<>();
		for (LibraryMangement book : libraryBooks) {
			if (book.getIssueDate().after(startDate) && book.getIssueDate().before(endDate)) {
				booksBetweenDates.add(book);
			}
		}
		return booksBetweenDates;
	}

	// Method to retrieve book details below a certain price
	public static List<LibraryMangement> getBooksBelowPrice(long maxPrice) {
		List<LibraryMangement> booksBelowPrice = new ArrayList<>();
		for (LibraryMangement book : libraryBooks) {
			if (book.getPrice() < maxPrice) {
				booksBelowPrice.add(book);
			}
		}
		return booksBelowPrice;
	}

	// Method to retrieve book details of available books
	public static List<LibraryMangement> getAvailableBooks() {
		List<LibraryMangement> availableBooks = new ArrayList<>();
		for (LibraryMangement book : libraryBooks) {
			if (book.isAvailability()) {
				availableBooks.add(book);
			}
		}
		return availableBooks;
	}

	// Method to update all fields of a book
	public void updateBook(String bookTitle, String author, boolean availability, long price, Date issueDate, Date dueDate) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.availability = availability;
		this.price = price;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}

	// Getters and setters for class attributes
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
public class Test
{
	public static void main(String[] args) {

		LibraryMangement lib1 = new LibraryMangement("The fire", "sam", true, 250,new Date(2000, 11, 21) ,new Date( 2010, 1, 3));
		LibraryMangement lib2 = new LibraryMangement("The God",
				
				"sam", true, 1050l,new Date(2004, 11, 22) ,new Date( 2005, 1, 3));

		List<LibraryMangement> booksByAuthors=LibraryMangement.getBooksByAuthor("sam");
		
		for(LibraryMangement lib: booksByAuthors)
		{
			System.out.println(lib.getAuthor()+" "+lib.getBookTitle());
		}
		
		//booksByAuthors.forEach((l) -> System.out.println(l.getBookTitle()) );
		/*
		 * List<LibraryMangement>
		 * bookBetween2dates=LibraryMangement.getBooksBetweenDates(new Date(2000, 11,
		 * 21) ,new Date( 2010, 1, 3)); bookBetween2dates.forEach((l) ->
		 * System.out.println(l.getBookTitle()) );
		 * 
		 * List<LibraryMangement>
		 * booksBelow500=LibraryMangement.getBooksBelowPrice(500);
		 * booksBelow500.forEach((l) -> System.out.println(l.getBookTitle()) );
		 * 
		 * List<LibraryMangement> availableBooks=LibraryMangement.getAvailableBooks();
		 * availableBooks.forEach((l) ->
		 * System.out.println(l.getBookTitle()+":"+l.getAuthor()) );
		 */
		
	}
}

