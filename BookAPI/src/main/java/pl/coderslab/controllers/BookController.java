package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;
import pl.coderslab.services.MockBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService mockBookService;

    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping()
    public List<Book> get() {
        return mockBookService.getBooks();
    }

    @GetMapping(path = "/{id}", produces = "text/plain;charset=UTF-8")
    public Book getById(@PathVariable ("id") long id) {
        return mockBookService.get(id).orElse(null);
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
}

