package booklib;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import booklib.data.BookRepository;
import booklib.model.Book;

@SpringBootApplication
public class BookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner dataLoader(BookRepository bookRepo) {
		return args -> {
			
			Book book1 = new Book();
			book1.setTitle("T");
			book1.setAuthor("Pelevin");
			book1.setAvailable(true);
			bookRepo.save(book1);

			Book book2 = new Book();
			book2.setTitle("Spring in action");
			book2.setAuthor("Craig Walls");
			book2.setAvailable(true);
			bookRepo.save(book2);
		};
	}

}
