package booklib.api;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import booklib.data.BookRepository;
import booklib.model.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/api/books",
    produces = "application/json")
@CrossOrigin(origins = "http://localhost:3000")
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

    @PutMapping(path = "/{id}", consumes = "application/json")
    public Book updateBook(
            @PathVariable("id") Long id,
            @RequestBody Book book) {
        book.setId(id);
        return bookRepo.save(book);
    }

    @DeleteMapping(path = "/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            bookRepo.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
