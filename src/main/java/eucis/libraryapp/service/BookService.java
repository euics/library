package eucis.libraryapp.service;

import eucis.libraryapp.entity.Book;
import eucis.libraryapp.repository.BookRepository;
import eucis.libraryapp.request.BookCreateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(BookCreateRequest request){
        if(request.getName() == null)
            throw new IllegalStateException(String.format("잘못된 name(%s)이 들어왔습니다.", request.getName()));

        bookRepository.save(new ModelMapper().map(request, Book.class));
    }
}
