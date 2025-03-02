package booklib;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import booklib.data.BookRepository;
import booklib.model.Book;
import booklib.service.ClientService;

@SpringBootApplication
public class BookLibraryApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ClientService clientService;
	public static void main(String[] args) {
		SpringApplication.run(BookLibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner dataInitializer() {
		return args -> {
			bookRepository.saveAll(Arrays.asList(
				new Book("1984", "George Orwell"),
				new Book("To Kill a Mockingbird", "Harper Lee"),
				new Book("How to build a car", "Adrian Newey")
			));
			clientService.createClient("drhard", "123", "dr_hard@mail.ru", "ROLE_ADMIN");
			clientService.createClient("Alex", "234", "alex@gmail.ru", "ROLE_USER");
			clientService.createClient("Daria", "345", "daria@daria.ru", "ROLE_USER");
		};
	}
}
