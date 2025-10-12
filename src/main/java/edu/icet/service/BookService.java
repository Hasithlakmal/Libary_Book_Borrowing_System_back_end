package edu.icet.service;

import edu.icet.model.dto.Book;
import edu.icet.model.dto.Long_Id;
import edu.icet.model.entity.BookEntity;
import edu.icet.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class BookService {

    @Autowired

    BookRepository bookRepository;

    public void  add(Book book){

        // public void  add(BookEntity bookEntity){

//        Book book=new Book(
//                2L,
//                "modolduwa",
//                "matin_Wikrama",
//                "hasith",
//                "978-800-500-7",
//                "shinhala",
//                12
//
//
//
//        );

   //     bookRepository.save(bookEntity);


        bookRepository.save(new BookEntity(

                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getCategory(),
                book.getAvailableCopies()


        ));

    }

  //  public List<BookEntity> getAll(){
    public List<Book> getAll(){


   //     List<BookEntity> all = bookRepository.findAll();

//        return all;

        List<BookEntity> all = bookRepository.findAll();

        List<Book> books=new ArrayList<>() ;

        for (BookEntity bookEntity : all) {

            books.add(new Book(

                    bookEntity.getId(),
                    bookEntity.getTitle(),
                    bookEntity.getAuthor(),
                    bookEntity.getPublisher(),
                    bookEntity.getIsbn(),
                    bookEntity.getCategory(),
                    bookEntity.getAvailableCopies()


            ));

        }


        return books;


    }

    public void delete(Book book) {

        bookRepository.delete(new BookEntity(


                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getCategory(),
                book.getAvailableCopies()

        ));

    }

    public void deleteById(Long_Id id) {

        bookRepository.deleteById(id.getId());

    }

    public void update(Book book) {

        bookRepository.saveAndFlush(new BookEntity(

                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getCategory(),
                book.getAvailableCopies()

        ));

    }
}
