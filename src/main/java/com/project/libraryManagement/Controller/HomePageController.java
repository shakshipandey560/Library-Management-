package com.project.libraryManagement.Controller;

import com.project.libraryManagement.Object.Books;
import com.project.libraryManagement.Object.IssueBookDetails;
import com.project.libraryManagement.Object.Users;
import com.project.libraryManagement.Service.BookService;
import com.project.libraryManagement.Service.IssuesBookService;
import com.project.libraryManagement.Service.SignInUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class HomePageController {

    @Autowired
    SignInUserService signInUserService;
    @Autowired
    BookService bookService;
    @Autowired
    private IssuesBookService issuesBookService;

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }
    @RequestMapping("/index")
    public String getIndexV2() {
        return "index";
    }

    @RequestMapping("/bookManagement")
    public String getBookManagement(Model model) {
        model.addAttribute("books",bookService.getAllBookList());
        return "bookManagement";
    }

    @RequestMapping("/userManagement")
    public String getUserManagement(Model model) {
        model.addAttribute("users",signInUserService.getAllUserList());
        return "userManagement";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUserController(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        boolean status = signInUserService.deleteUserDetailsService(id);
        return "redirect:/userManagement";
    }

    @PostMapping("/deleteBook/{id}")
    public String deleteBookUserController(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        boolean status = bookService.deleteBookDetailsService(id);
        return "redirect:/bookManagement";
    }

    @RequestMapping("/signin")
    public String getSignIn() {
        return "logIn";
    }

    @RequestMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

    @RequestMapping("/forgotPassword")
    public String getForgotPassword() {
        return "forgotPassword";
    }

    @RequestMapping("/navBar")
    public String getCart() {
        return "NavBar";
    }

    @RequestMapping("/issueBook")
    public String getCheckout() {
        return "issueBook";
    }

    @RequestMapping("/studentDetail")
    public String getStudentDetailV1() {
        return "studentDetail";
    }

    @RequestMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @RequestMapping(value = {"/addUser", "/editUser/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getAddUser(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            Optional<Users> userData = signInUserService.getuserDataById(id);
            userData.ifPresent(user -> model.addAttribute("user", user));
            model.addAttribute("action", "editUser");
        } else {
            model.addAttribute("user", new Users());
            model.addAttribute("action", "newUser");
        }
        return "addUser";
    }

    @RequestMapping(value = {"/addBook", "/editBook/{id}"},  method = { RequestMethod.GET, RequestMethod.POST } )
    public String getAddBook(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            Optional<Books> bookData = bookService.getbookDataById(id);
            bookData.ifPresent(book -> model.addAttribute("book", book));
            model.addAttribute("date", bookData.get().getPDate());
            model.addAttribute("action", "editBook");
        } else {
            model.addAttribute("book", new Books());
            model.addAttribute("action", "newBook");
        }
        return "addBook";
    }

    @RequestMapping("/viewRecord")
    public String viewRecord(Model model) {
        model.addAttribute("issues",issuesBookService.getAllIssueList());
        return "viewRecord";
    }
    @RequestMapping(value = {"/returnBook/{id}"},   method = { RequestMethod.GET, RequestMethod.POST } )
    public String returnBookInit(Model model, @PathVariable int id) {
        
        Optional<IssueBookDetails> returnBookData = issuesBookService.returnBookDetail(id);
        int calculateFine = issuesBookService.getFine(returnBookData.get().getDueDate(),id);
        returnBookData.ifPresent(returnBook -> model.addAttribute("returnBook", returnBook));
        model.addAttribute("fine", calculateFine);
        return "returnIssuedBook";
    }
    
    @RequestMapping("/setting")
    public String getContact() {
        return "setting";
    }

    @RequestMapping("/news-events-detail")
    public String getNewsEventsDetail() {
        return "news-events-detail";
    }

    @RequestMapping("/news-events-list-view")
    public String getNewsEventsListView() {
        return "news-events-list-view";
    }

    @RequestMapping("/services")
    public String getServices() {
        return "services";
    }

    @RequestMapping("/blog")
    public String getBlog() {
        return "blog";
    }

    @RequestMapping("/blog-detail")
    public String getBlogDetails() {
        return "blog-detail";
    }

    @RequestMapping("/404")
    public String getError() {
        return "404";
    }

}
