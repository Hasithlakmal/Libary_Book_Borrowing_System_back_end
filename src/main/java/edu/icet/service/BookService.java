package edu.icet.service;

import edu.icet.model.Book;
import edu.icet.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    @Autowired

    BookRepository bookRepository;

    public void  add(){

        Book book=new Book(
                2L,
                "modolduwa",
                "matin_Wikrama",
                "hasith",
                "978-800-500-7",
                "shinhala",
                12



        );

        bookRepository.save(book);

    }

    public List<Book> getAll(){


        List<Book> all = bookRepository.findAll();

        return all;


    }

}
