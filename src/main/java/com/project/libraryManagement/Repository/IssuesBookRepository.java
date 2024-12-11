package com.project.libraryManagement.Repository;

import com.project.libraryManagement.Object.IssueBookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface IssuesBookRepository extends JpaRepository<IssueBookDetails,Integer> {

//    @Query("Select i from  IssueBookDetails  i")
//    Object findAllIssueDetails();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="update Issue_Book_Details i set i.fine =:calculateFine  where i.issue_book_id = :id", nativeQuery = true)
    void updateFine(int calculateFine, int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="update Issue_Book_Details i set i.issue_status ='Return' , payment_status='PAID' where i.issue_book_id = :id", nativeQuery = true)
    void updateStatus(int id);
}
