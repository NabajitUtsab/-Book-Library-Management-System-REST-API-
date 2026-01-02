package com.example.Book.Library.Management.System.REST.API.repo;

import com.example.Book.Library.Management.System.REST.API.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
