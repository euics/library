package eucis.libraryapp.controller;

import eucis.libraryapp.request.BookCreateRequest;
import eucis.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
    }
}
