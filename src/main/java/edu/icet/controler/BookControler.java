package edu.icet.controler;

import edu.icet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControler {

    @Autowired
    BookService bookService;
    @GetMapping

    public String getBook() {


        bookService.add();


        return "modulduwa"+bookService.getAll();


    }
}
