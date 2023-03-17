package com.hachiko.redisdemo.service;

import com.hachiko.redisdemo.model.Book;
import com.hachiko.redisdemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(Long id ) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the book by id."));
    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book newBook) {
        Book oldBook = getBookById(id);
        oldBook.setISBN(newBook.getISBN());
        oldBook.setTitle(newBook.getTitle());

        return bookRepository.save(oldBook);
    }

    public Book deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
        return book;
    }
}
