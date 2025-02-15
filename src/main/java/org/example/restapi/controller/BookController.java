package org.example.restapi.controller;

import jakarta.validation.Valid;
import org.example.restapi.dto.BookDTO;
import org.example.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO newBookDTO = bookService.createBook(bookDTO);
        return new ResponseEntity<>(newBookDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> getAllBooks(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<BookDTO> bookDTOPage = bookService.getAllBooks(pageable);
        return new ResponseEntity<>(bookDTOPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        BookDTO updatedBookDTO = bookService.updateBook(id, bookDTO);
        return new ResponseEntity<>(updatedBookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
