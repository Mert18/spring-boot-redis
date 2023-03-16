package com.hachiko.redisdemo.repository;

import com.hachiko.redisdemo.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
