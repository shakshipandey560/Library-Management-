package com.project.libraryManagement.Object;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class IssueBookDetails {

    @Id
    @GeneratedValue(generator = "issueBookSeq", strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "issueBookSeq", sequenceName = "issueBookSequence",initialValue = 1,allocationSize = 1)
    private int issueBookId;
    private int bookId;
    private String bookName;
    private int studentId;
    private String studentName;
    private String issueDate;
    private String dueDate;
    private String issueStatus;
    private int fine;
    private String paymentStatus;

    public IssueBookDetails(int issueBookId, int bookId, String bookName, int studentId, String studentName, String issueDate, String dueDate, String issueStatus,int fine,String paymentStatus) {
        this.issueBookId = issueBookId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.issueStatus = issueStatus;
        this.fine = fine;
        this.paymentStatus=paymentStatus;
    }

    public IssueBookDetails() {

    }

    @Override
    public String toString() {
        return "IssueBookDetails{" +
                "issueBookId=" + issueBookId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", issueStatus='" + issueStatus + '\'' +
                ", fine=" + fine +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }

}
