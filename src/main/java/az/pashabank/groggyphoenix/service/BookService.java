package az.pashabank.groggyphoenix.service;

import az.pashabank.groggyphoenix.model.Book;

import org.instancio.Instancio;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<Integer, Book> DB;

    public BookService() {
        this.DB = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            var book = Instancio.create(Book.class);
            DB.put(book.getId(), book);
        }
    }

    public Collection<Book> getAllBooks() {
        return DB.values();
    }

    public Book updateBook(Integer id, Book book) {
        var existingBook = DB.get(id);
        existingBook.setAuthor(book.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setDescription(book.getDescription());
        existingBook.setYear(book.getYear());
        return existingBook;
    }

    public void deleteBook(Integer id) {
        DB.remove(id);
    }

    public Book createBook(Book book) {
        var id = Instancio.create(Integer.class);
        System.out.println("Id =" + id);
        book.setId(id);
        DB.put(id, book);
        return book;
    }
}
