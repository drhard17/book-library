package booklib.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import booklib.data.BookRepository;
import booklib.model.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/books",
    produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")    
public class BookController {
    
    private BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public Iterable<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

}
