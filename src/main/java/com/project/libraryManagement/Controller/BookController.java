package com.project.libraryManagement.Controller;

import com.google.gson.Gson;
//import com.project.libraryManagement.Object.Book;
import com.google.gson.JsonObject;
import com.project.libraryManagement.Object.Books;
import com.project.libraryManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    public BookService bookService;

    @PostMapping("/fetchBookData")
    public @ResponseBody String bookDetailsController(@RequestBody String jsonData, Model model) {
        JsonObject json=new JsonObject();
        Books book = new Gson().fromJson(jsonData, Books.class);
        json = new Gson().fromJson(jsonData, JsonObject.class);
        String action = json.get("action").getAsString();
        boolean status =bookService.bookDetailsService(book,action);
        json.addProperty("status", status);
        return json.toString();
    }

    @PostMapping("/getBookName")
    public @ResponseBody String getBookNameInit(@RequestBody String jsonData, Model model) {
        JsonObject json=new JsonObject();
        String bookTitle="";
        Optional<Books> data= bookService.getbookDataById(Integer.parseInt(jsonData));
        if(data.isPresent()) {
            bookTitle = data.get().getBookTitle();
        }
        json.addProperty("bookName", bookTitle);
        return json.toString();
    }
}
