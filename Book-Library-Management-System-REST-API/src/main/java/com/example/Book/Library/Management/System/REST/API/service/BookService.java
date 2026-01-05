package com.example.Book.Library.Management.System.REST.API.service;

import com.example.Book.Library.Management.System.REST.API.model.Book;
import com.example.Book.Library.Management.System.REST.API.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {

    @Autowired
    private  BookRepo bookRepo;


    public List<Book> gettingAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }
}
