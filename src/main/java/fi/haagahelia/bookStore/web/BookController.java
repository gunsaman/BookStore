package fi.haagahelia.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bookStore.domain.Book;
import fi.haagahelia.bookStore.domain.BookRepository;
import fi.haagahelia.bookStore.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;


@Controller
public class BookController {
    
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	
	@RequestMapping(value="/") /// It's working but if i use (value="/login") WHY IS THIS NOT DIRECTING TO login.html ----> correct this issue
	public String login() {
		return "login";
	}   
	
		
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        
        return "booklist";
    }
    
    //RESTful service to get all the books:
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest(){
    	return (List<Book>) repository.findAll();
    }
    
    // RESTful service For searching book by Id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id){
    	return repository.findById(id);
    }
    
    // add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }  
    //save book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }  
    
    //delete book
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }    
    //modify book
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyBook(@PathVariable("id") Long bookId, Model model) {
    	Optional<Book> book = repository.findById(bookId);
    	model.addAttribute("categories", crepository.findAll());
    	model.addAttribute("book", book);
        return "modifybook";
    }   
}
