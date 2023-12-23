package in.akshaypack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.akshaypack.entity.BookNew;
import in.akshaypack.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookrepo;

	@Override
	public List<BookNew> getAllBooks() {
			
		return bookrepo.findAll();
	}

	@Override
	public boolean saveBook(BookNew book) {
		BookNew saveBook = bookrepo.save(book);
		
		if(saveBook.getBookId() != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public void deleteBook(Integer bookId) {
		
		bookrepo.deleteById(bookId);
		
	}

}
