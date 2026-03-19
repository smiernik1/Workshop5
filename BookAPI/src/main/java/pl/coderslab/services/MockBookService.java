package pl.coderslab.services;

import org.springframework.stereotype.Service;
import pl.coderslab.interfaces.BookService;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {

    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java","Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy,	Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy","Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        for  (Book book : list) {
            if (id != null && id.equals(book.getId())) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }


    @Override
    public void add(Book book) {
        list.add(book);
        System.out.println("Book has been added successfully");
    }

    @Override
    public void delete(Long id) {
        for   (Book book : list) {
            if (id != null && id.equals(book.getId())) {
                list.remove(book);
                System.out.println("Book has been deleted successfully");
            }
        }
    }

    @Override
    public void update(Book book) {
        Long id = book.getId();
        for   (Book bookToUpdate : list) {
            if (id.equals(bookToUpdate.getId())) {
                bookToUpdate.setIsbn(book.getIsbn());
                bookToUpdate.setTitle(book.getTitle());
                bookToUpdate.setAuthor(book.getAuthor());
                bookToUpdate.setPublisher(book.getPublisher());
                bookToUpdate.setType(book.getType());
                System.out.println("Book has been updated successfully");
                return;
            }
        }
        System.out.println("No book found with id: " + id);
    }
}
