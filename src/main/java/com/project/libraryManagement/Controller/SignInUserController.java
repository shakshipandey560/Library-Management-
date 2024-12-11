package com.project.libraryManagement.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.libraryManagement.Object.IssueBookDetails;
import com.project.libraryManagement.Object.Users;
import com.project.libraryManagement.Service.SignInUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class SignInUserController {

    @Autowired
    SignInUserService signInUserService;

    @PostMapping("/insertCustomerData")
    public String addNewUserController(@RequestBody String jsonData, Model model) {

        Users user = new Gson().fromJson(jsonData, Users.class);
        JsonObject json = new Gson().fromJson(jsonData, JsonObject.class);
        String action = json.get("action").getAsString();
        boolean status =signInUserService.userDetailsService(user,action);
        json.addProperty("status", status);
        return json.toString();
    }

    @GetMapping("/fetchCustomerData")
    public boolean fetchCustomerDataController(@RequestParam String jsonData, Model model) {
        Users users= new Gson().fromJson(jsonData, Users.class);
        List<Users> list =  signInUserService.isAuthorizedUser(users);
        if(list.size()<=0){
            return false;
        }else{
            return true;
        }
    }

    @PostMapping("/getStudentName")
    public String getStudentNameInit(@RequestBody String jsonData, Model model) {
        JsonObject json=new JsonObject();
        String studentName="";
        Optional<Users> data= signInUserService.getuserDataById(Integer.parseInt(jsonData));
        if(data.isPresent()) {
            studentName = data.get().getFirstName() + " " + data.get().getLastName();
        }
        json.addProperty("studentName", studentName);
        return json.toString();
    }

}
