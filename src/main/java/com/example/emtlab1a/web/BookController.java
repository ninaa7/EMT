package com.example.emtlab1a.web;

import com.example.emtlab1a.dto.CreateBookDto;
import com.example.emtlab1a.dto.DisplayBookCopyDto;
import com.example.emtlab1a.dto.DisplayBookDto;
import com.example.emtlab1a.service.application.BookApplicationService;
import com.example.emtlab1a.service.application.BookCopyApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Book API", description = "Endpoints for managing book categories")
public class BookController {

    private final BookApplicationService bookService;
    private final BookCopyApplicationService copyService;

    public BookController(BookApplicationService bookService, BookCopyApplicationService copyService) {
        this.bookService = bookService;
        this.copyService = copyService;
    }


    @GetMapping
    @Operation(summary = "Get all books", description = "Retrieves a list of all available books.")
    public List<DisplayBookDto> findAll () {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID", description = "Finds a book by its ID.")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookService.findById(id).map(b -> ResponseEntity.ok().body(b)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new book", description = "Creates a new book.")
    public ResponseEntity<DisplayBookDto> save (@RequestBody CreateBookDto book) {
        return bookService.save(book).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update an existing book", description = "Updates a book by ID.")
    public ResponseEntity<DisplayBookDto> update (@PathVariable Long id, @RequestBody CreateBookDto book) {
        return bookService.update(id,book).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a book", description = "Deletes a book by its ID.")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/rent/{id}")
    @Operation(summary = "Rent a book", description = "Rents a book copy")
    public ResponseEntity<DisplayBookCopyDto> rent(@PathVariable Long id){
        return copyService.markAsRented(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/loan/{id}")
    @Operation(summary = "Изнајми книга", description = "Означува одредена копија на книга како изнајмена.")
    public ResponseEntity<DisplayBookCopyDto> loanBook(@Parameter(description = "ID на копијата на книгата") @PathVariable Long id) {
        return copyService.markAsRented(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createCopy/{id}")
    //@PreAuthorize("hasRole('LIBRARIAN')")
    @Operation(summary = "Креирај копија на книга", description = "Создава нова копија на дадена книга.")
    public ResponseEntity<DisplayBookCopyDto> createCopy(@Parameter(description = "ID на книгата") @PathVariable Long id) {
        return copyService.createCopy(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/bookCopies/{id}")
    @Operation(summary = "Најди ги сите копии на книга", description = "Го враќа списокот на сите копии на дадена книга.")
    public List<DisplayBookCopyDto> findAllCopies(@Parameter(description = "ID на книгата") @PathVariable Long id) {
        return this.copyService.findByBook(id);
    }
}
