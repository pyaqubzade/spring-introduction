package az.pashabank.groggyphoenix.controller;

import az.pashabank.groggyphoenix.model.Book;
import az.pashabank.groggyphoenix.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class Controller {

    private final BookService bookService;

    @GetMapping
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping(path = "{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}

