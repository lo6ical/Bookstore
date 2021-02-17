package fi.hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository) { 
		return (args) -> {
			Book b1 = new Book("Title", "Author", 2021, 0, 0.0);
			Book b2 = new Book("Title", "Author", 2021, 0, 0.0);
			Book b3 = new Book("Title", "Author", 2021, 0, 0.0);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
