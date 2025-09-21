package edu.icet.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControler {

    @GetMapping
    public String getBook() {

         return "modulduwa";

    }
}
