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
	public CommandLineRunner bookstore(BookRepository brepository, CategoryRepository crepository) { 
		return (args) -> {
			Category c1 = new Category("Sci-Fi");
			crepository.save(c1);
			Category c2 = new Category("Comedy");
			crepository.save(c2);
			Category c3 = new Category("Horror");
			crepository.save(c3);
			
			brepository.save(new Book("Example", "Max", 2001, "1234567891011", 20.5, c1));
			brepository.save(new Book("Example", "Mike", 2006, "1234567891011", 38.5, c2));
			brepository.save(new Book("Example", "Max", 2003, "1234567891011", 24.5, c3));
			
			
			
			
		};
	}
}
