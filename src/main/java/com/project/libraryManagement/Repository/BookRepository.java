package com.project.libraryManagement.Repository;

import com.project.libraryManagement.Object.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

    @Query("Select b from  Books b  where b.delete <> 'NO'")
    Object findAllBook();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="update Books b set b.delete = 'NO' where b.book_id = :id", nativeQuery = true)
    void deleteBookById(int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="update Books b set b.qty = :qty, b.price= :price where b.book_id = :id", nativeQuery = true)
    void editBookDetails(int qty, double price, int id);
    
    @Query("Select b from  Books b  where b.bookId = :id and b.delete <> 'NO'")
    Optional<Books> findBookById(Integer id);
}
