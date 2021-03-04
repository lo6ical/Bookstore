package fi.hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;
import fi.hh.swd20.bookstore.domain.Category;
import fi.hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository) { 
		return (args) -> {
			Book b1 = new Book("Example", "Max", 2001, "1234567891011", 20.5);
			Book b2 = new Book("Title", "Author", 1998, "1234567891011", 15.0);
			Book b3 = new Book("Title", "Author", 2008, "1234567891011", 25.0);
			
			
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}
	
	@Bean
	public CommandLineRunner category(CategoryRepository repository) {
		return (args) -> {
			Category c1 = new Category("Sci-Fi");
			Category c2 = new Category("Comedy");
			Category c3 = new Category("Horror");
			
			repository.save(c1);
			repository.save(c2);
			repository.save(c3);
		};
	}

}
