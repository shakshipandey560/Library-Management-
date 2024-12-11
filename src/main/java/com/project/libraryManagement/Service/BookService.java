package com.project.libraryManagement.Service;

import com.project.libraryManagement.Object.Books;
import com.project.libraryManagement.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void BookInterface(Books book) {
    }


    public boolean bookDetailsService(Books book, String action) {
        try{
            if(action.equals("editBook")) {
                System.out.println("id:: " + book.getBookId());
                bookRepository.editBookDetails(book.getQty(),book.getPrice(),book.getBookId());
            }else {
                bookRepository.save(book);
            }
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }


    public Object getAllBookList() {
        return bookRepository.findAllBook();
    }


    public boolean deleteBookDetailsService(int id) {
        try{
            System.out.println("deleteUserDetailsService:" + id);
            bookRepository.deleteBookById(id);
            return true;
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Books> getbookDataById(Integer id) {
        return bookRepository.findBookById(id);
//        return bookRepository.findById(id);
    }

}
