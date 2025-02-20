package booklib.data;

import org.springframework.data.repository.CrudRepository;
import booklib.model.Book;

public interface BookRepository
        extends CrudRepository<Book, Long> {
}
