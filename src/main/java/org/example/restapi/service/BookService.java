package org.example.restapi.service;

import org.example.restapi.dto.BookDTO;
import org.example.restapi.exception.ResourceNotFoundEx;
import org.example.restapi.entity.Book;
import org.example.restapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private BookDTO entityToDTO(Book book) {
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getIsbn());
    }

    private Book dtoToEntity(BookDTO bookDTO) {
        return new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getIsbn());
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = dtoToEntity(bookDTO);
        book = bookRepository.save(book);
        return entityToDTO(book);
    }

    public Page<BookDTO> getAllBooks(Pageable pageable) {
         return bookRepository.findAll(pageable)
                .map(this::entityToDTO);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundEx("Book not found with id: " + id));

        return entityToDTO(book);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundEx("Book not found with id: " + id));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book = bookRepository.save(book);
        return entityToDTO(book);
    }

    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundEx("Book not found with id: " + id));

        bookRepository.delete(book);
    }
}
