package com.hachiko.redisdemo.service;

import com.hachiko.redisdemo.model.Books;
import com.hachiko.redisdemo.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getAllBooks() {
        return (List<Books>) booksRepository.findAll();
    }

    public Books getBooksById(Long id ) {
        return booksRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the book by id."));
    }

    public Books createBooks(Books b) {
        return booksRepository.save(b);
    }

    public Books updateBooks(Long id, Books newBook) {
        Books oldBooks = getBooksById(id);
        oldBooks.setISBN(newBook.getISBN());
        oldBooks.setTitle(newBook.getTitle());

        return booksRepository.save(oldBooks);
    }

    public void deleteBooks(Long id) {
        Books book = getBooksById(id);
        booksRepository.delete(book);
    }
}
