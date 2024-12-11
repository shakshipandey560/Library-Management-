package com.project.libraryManagement.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.libraryManagement.Object.IssueBookDetails;
import com.project.libraryManagement.Service.IssuesBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IssuesBookController {

    @Autowired
    private IssuesBookService issuesBookService;

    @PostMapping("/newBookIssue")
    public @ResponseBody String issueBookInit(@RequestBody String jsonData, Model model) {
        JsonObject json=new JsonObject();
        IssueBookDetails issueBookDetails = new Gson().fromJson(jsonData, IssueBookDetails.class);
        issueBookDetails.setIssueStatus("Issued");
        boolean status = issuesBookService.issueBook(issueBookDetails);
        json.addProperty("status", status);
        return json.toString();
    }

    @PostMapping("/returnBookIssued")
    public @ResponseBody String returnBookInit(@RequestBody String jsonData, Model model) {
        JsonObject json=new JsonObject();
        IssueBookDetails issueBookDetails = new Gson().fromJson(jsonData, IssueBookDetails.class);
        int id = issueBookDetails.getIssueBookId();
        boolean status =issuesBookService.returnBookAndUpdateStatus(id);
        json.addProperty("status", status);
        return json.toString();
    }
}
