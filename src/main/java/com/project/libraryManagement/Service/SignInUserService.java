package com.project.libraryManagement.Service;

import com.project.libraryManagement.Object.IssueBookDetails;
import com.project.libraryManagement.Object.Users;
import com.project.libraryManagement.Repository.BookRepository;
import com.project.libraryManagement.Repository.SignInUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignInUserService {

    @Autowired
    SignInUserRepository signInUserRepository;

    public List<Users> isAuthorizedUser(Users users) {
        return null;
    }

    public boolean userDetailsService(Users user, String action) {
        try{
            if(action.equals("editUser")){
                signInUserRepository.updateUserDetails(user.getFirstName(), user.getLastName(), user.getAddress(), user.getId());
            }else {
                signInUserRepository.save(user);
            }
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    public List<Users> getAllUserList() {
        try {
            return signInUserRepository.findAllUser();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUserDetailsService(int id) {
        try{
            signInUserRepository.deleteBookById(id);
            return true;
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return false;
    }


    public Optional<Users> getuserDataById(int id) {
        return signInUserRepository.findStudentById(id);
    }
    
}
