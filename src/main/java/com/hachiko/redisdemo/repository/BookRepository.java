package com.hachiko.redisdemo.repository;

import com.hachiko.redisdemo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByTitle(String title);

}
