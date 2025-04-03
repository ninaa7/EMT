package com.example.emtlab1a.repository;

import com.example.emtlab1a.model.domain.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {
}
