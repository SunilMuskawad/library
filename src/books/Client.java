package books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

	static BookManager bookManager = new BookManager();
	public static void main(String[] args) {
		addBookToLibrary(createBook("book1","author1","p1"));
		addBookToLibrary(createBook("book2","author2","p2"));
		addBookToLibrary(createBook("book3","author1","p1"));
		addBookToLibrary(createBook("book4","author3","p1"));
		print(getBooks(FieldName.Book.name(),"book1"));
		print(getBooks(FieldName.Author.name(),"author1"));
		print(getBooks(FieldName.Publisher.name(),"p1"));

	}
	public static void print(List<Book> book) {
		for(Book b:book) {
			System.out.println("Book:" + b.getBookName());
			System.out.println("Author:" + b.getAuthorName());
			System.out.println("Publisher:" + b.getPublisher());
			System.out.println();
		}
	}
	public static Book createBook(String bookName,String authorName, String publisher) {
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthorName(authorName);
		book.setPublisher(publisher);
		return book;
	}
	public static void addBookToLibrary(Book book) {
		bookManager.getBookList().add(book);
	}
	public static List<Book> getBooks(String fieldName,String value){
		List<Book> list = new ArrayList<>();
		if(fieldName==FieldName.Author.name()) {
			list = bookManager.getBookList().stream().filter(b -> b.getAuthorName().equalsIgnoreCase(value)).collect(Collectors.toList());
		}
		else if(fieldName==FieldName.Book.name()) {
			list = bookManager.getBookList().stream().filter(b -> b.getBookName().equalsIgnoreCase(value)).collect(Collectors.toList());
		}
		else if(fieldName==FieldName.Publisher.name()) {
			list = bookManager.getBookList().stream().filter(b -> b.getPublisher().equalsIgnoreCase(value)).collect(Collectors.toList());
		}
		if(list.isEmpty()) {
			System.out.println(fieldName + "Not Found");
		}
		return list;
	}
}
