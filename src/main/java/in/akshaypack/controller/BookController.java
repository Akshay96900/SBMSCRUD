package in.akshaypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.akshaypack.entity.BookNew;
import in.akshaypack.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books")
	public ModelAndView getAllBooks()
	{
		ModelAndView mav = new ModelAndView();
		List<BookNew> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("bookView");
		return mav;
	}

	@GetMapping("/index")
	public ModelAndView showBooks()
	{
		ModelAndView mav = new ModelAndView();
		//sending empty obj for form binding ----to map object with the form
		mav.addObject("book",  new BookNew());	
		mav.setViewName("index");
		return mav;
	}
	

	@PostMapping("/book")
	public ModelAndView saveBook(BookNew book)
	{
		System.out.println("Akshh"+book);
		ModelAndView mav = new ModelAndView();
		boolean status = bookService.saveBook(book);
		if(status)
		{
			mav.addObject("SuccessMsg", "Book Saved");
		}else
		{
			mav.addObject("ErrorMsg", "Failed TO Save");

		}
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId") Integer bookId)
	{
		bookService.deleteBook(bookId);
		
		ModelAndView mav = new ModelAndView();
		List<BookNew> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("bookView");
		return mav;
	}
	

}
