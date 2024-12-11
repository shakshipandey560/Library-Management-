package com.project.libraryManagement.Object;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Books {

    @Id
    @GeneratedValue(generator = "bookSeq", strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "bookSeq", sequenceName = "bookSequence",initialValue = 1,allocationSize = 1)
    private int bookId;
    private String bookTitle;
    private String author;
    private String bookPublisher;
    private String bookIsbn;
    private int qty;
    private double price;
    private String pDate;
    private String description;
    private String delete;

    public Books() {
    }

    public Books(int bookId, String bookTitle, String author, String bookPublisher, String bookIsbn, int qty, double price, String pDate, String description, String delete) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookPublisher = bookPublisher;
        this.bookIsbn = bookIsbn;
        this.qty = qty;
        this.price = price;
        this.pDate = pDate;
        this.description = description;
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", pDate='" + pDate + '\'' +
                ", description='" + description + '\'' +
                ", delete='" + delete + '\'' +
                '}';
    }
}
