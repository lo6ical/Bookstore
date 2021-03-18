package fi.hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;
import fi.hh.swd20.bookstore.domain.Category;
import fi.hh.swd20.bookstore.domain.CategoryRepository;
import fi.hh.swd20.bookstore.domain.User;
import fi.hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) { 
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
			
			User user1 = new User("user", "$2a$10$Or.oucI98vA6bqMrTHdhmeVH7R7isyb2a0txTsYXE/tGy/FWVjmRS", "USER");
			User user2 = new User("admin", "$2a$10$VZcB06V5EX6utiAd5xllz.nb3m3CHb.AtH8uSBPgr37CtBYjFzwBu", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("Fetch all the categories");
			for (Category category : crepository.findAll()) {

					log.info(category.toString());
			}

			log.info("Fetch all the books");
			for (Book book : brepository.findAll()) {

				log.info(book.toString());
			}
			
			
		};
	}
}
