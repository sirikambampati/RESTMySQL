package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

//To retreive all the data in table: book
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //To retrive all the data from specified id from table: book
    @GetMapping("/books/{id}")
    public Optional<Book> getAllBooksById(@PathVariable(value = "id") Integer id){
        return  bookRepository.findById(id);
    }

    //To save new record into table:book
    @PostMapping("/books")
    public @Valid Book createBook(@Valid @RequestBody Book book){
        return bookRepository.save(book);
    }

    //To update data for a given id
    @PutMapping("/books/{id}")
    public @Valid Book updateBook(@PathVariable(value = "id") Integer id, @Valid @RequestBody Book book)
            throws BookNotFoundException{
        Book bk = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        bk.setTitle(book.getTitle());
        bk.setPages(book.getPages());
        bk.setGenre(book.getGenre());
        Book updBook = bookRepository.save(bk);
        return updBook;

    }

    //To delete the data from given id
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Integer id)
            throws BookNotFoundException{
        bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        bookRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
