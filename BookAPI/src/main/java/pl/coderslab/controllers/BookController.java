package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping( "/{id}")
    public Book getById(@PathVariable ("id") Long id) {
        if (mockBookService.get(id).isEmpty()) {
            return new Book();
        }
        return mockBookService.get(id).get();
    }

    @PostMapping()
    public String add(@RequestBody Book book) {
        mockBookService.add(book);
        return "Book has been added successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") long id) {
        mockBookService.delete(id);
        return "Book has been deleted successfully";
    }

    @PutMapping()
    public String update(@RequestBody Book book) {
        mockBookService.update(book);
        return "Book has been updated successfully";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
}

