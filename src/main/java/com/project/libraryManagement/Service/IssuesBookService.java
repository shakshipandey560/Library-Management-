package com.project.libraryManagement.Service;

import com.project.libraryManagement.Object.IssueBookDetails;
import com.project.libraryManagement.Repository.IssuesBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
public class IssuesBookService {

    @Autowired
    private IssuesBookRepository issuesBookRepository;

    public boolean issueBook(IssueBookDetails issueBookDetails) {
        try{
            issuesBookRepository.save(issueBookDetails);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    public Object getAllIssueList() {
        return issuesBookRepository.findAll();
    }


    public Optional<IssueBookDetails> returnBookDetail(int id) {
        return issuesBookRepository.findById(id);
    }

    public int getFine(String dueDate, int id) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDateParsed = LocalDate.parse(dueDate, formatter);
        int calculateFine=0;
        if(currentDate.isAfter(dueDateParsed)){
            long daysLate = ChronoUnit.DAYS.between(dueDateParsed, currentDate);
            calculateFine = (int) (daysLate * 5);
            issuesBookRepository.updateFine(calculateFine,id);
        }
        return calculateFine;
    }

    public boolean returnBookAndUpdateStatus(int id) {
        try{
            issuesBookRepository.updateStatus(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }
}
