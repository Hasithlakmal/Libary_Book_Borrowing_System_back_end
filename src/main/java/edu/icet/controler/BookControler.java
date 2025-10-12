package edu.icet.controler;

import edu.icet.model.dto.Book;
import edu.icet.model.dto.Long_Id;
import edu.icet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookControler {

    @Autowired
    BookService bookService;

    @GetMapping
    public String viwe(){

        return "madolduwa";
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {


        System.out.println(book);

        bookService.add(book);


       // return "modulduwa"+bookService.getAll();


    }

    @GetMapping("/{author}")
    public String getAutor(@PathVariable String author){

        System.out.println(author);

        return author;
    }

    @GetMapping("/author")
    public String getAutor1(@PathVariable String author){

        System.out.println(author);

        return author;
    }

    @GetMapping("/all")
    public List<Book> getallDetails(){

       List<Book> books=bookService.getAll();

        System.out.println(books);
        return books;

    }

    @PostMapping("/delo")
    public void  delteBook(@RequestBody Book book){

        bookService.delete(book);


//        {
//            "id": 2,
//                "title": "modolduwa",
//                "author": "matin_Wikrama",
//                "publisher": "hasith",
//                "isbn": "978-800-500-7",
//                "category": "shinhala",
//                "availableCopies": 12
//        }


    }


@PostMapping("/delId")
    public void  deletebyId(@RequestBody Long_Id id){

        bookService.deleteById(id);


    }

    @PostMapping("/update")
    public void Update(@RequestBody Book book){

        bookService.update(book);

    }

}
 