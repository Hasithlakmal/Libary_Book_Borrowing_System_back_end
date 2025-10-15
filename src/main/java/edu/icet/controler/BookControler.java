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
    public String viwe() {

        return "madolduwa";
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {


        System.out.println(book);

        bookService.add(book);


        // return "modulduwa"+bookService.getAll();

        return "ok add";

    }

    @GetMapping("/{author}")
    public String getAutor(@PathVariable String author) {

        System.out.println(author);

        return author;
    }

    @GetMapping("/author")
    public String getAutor1(@PathVariable String author) {

        System.out.println(author);

        return author;
    }

    @GetMapping("/all")
    public List<Book> getallDetails() {

        List<Book> books = bookService.getAll();

        System.out.println(books);
        return books;

    }

    @DeleteMapping("/delo")
    public String delteBook(@RequestBody Book book) {

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

        return "delet sucsses full ok !!!";

    }


    @DeleteMapping("/delId")
    public String deletebyId(@RequestBody Long_Id id) {

        bookService.deleteById(id);


        return "delet sucsses full ok !!!";

    }


    @DeleteMapping("delUrlId/{id}")

    public String deletbyUrlId(@PathVariable String id){

        bookService.deletbyUrlId(id);

        return "delet sucsses full ok !!!";

    }


    @PutMapping("/update")
    public String Update(@RequestBody Book book) {

        bookService.update(book);

        return "update sucsses full ok !!!";

    }

    @GetMapping("/serchId")
    public Book serchById(@RequestBody Long_Id id) {

        return bookService.serchById(String.valueOf(id));


    }

    @GetMapping("serchId/{id}")
    public Book serchByID( @PathVariable String id) {

        return bookService.serchById(id);


    }


    @GetMapping("/details")
    public String ApiDetails() {

        return " Postmapping for add book \n" +
                "getmaping for viwe all detais \n" +
                " /delId for  by id delte \n" +
                "/delob for by object delete \n" +
                "/details  for about api";


    }


}
 