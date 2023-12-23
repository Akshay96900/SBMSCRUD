package in.akshaypack.service;

import java.util.List;

import in.akshaypack.entity.BookNew;

public interface BookService {
	
	public List<BookNew> getAllBooks();
	
	public boolean saveBook(BookNew book);
	
	public void deleteBook(Integer bookId);

}
