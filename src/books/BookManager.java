package books;

import java.util.ArrayList;
import java.util.List;

public class BookManager{
	List<Book> bookList = new ArrayList<>();
	
	public List<Book> getBookList(){
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList=bookList;
	}
}
