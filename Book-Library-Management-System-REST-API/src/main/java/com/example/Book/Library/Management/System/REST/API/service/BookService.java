package com.example.Book.Library.Management.System.REST.API.service;

import com.example.Book.Library.Management.System.REST.API.model.Book;
import com.example.Book.Library.Management.System.REST.API.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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


    public Optional<Book> updateBookById(Long id,Book book) {
        return bookRepo.findById(id).map(existingBook ->
        {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPublication(book.getPublication());
            existingBook.setPublicationYear(book.getPublicationYear());
            existingBook.setAvailableCopies(book.getAvailableCopies());

            return bookRepo.save(existingBook);
        });
    }


    public boolean deleteBookById(Long id) {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }


    public boolean deleteAllBooks() {
        if(bookRepo.findAll().isEmpty()) {
            return false;
        }
        bookRepo.deleteAll();
        return true;
    }
}
