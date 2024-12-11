package com.project.libraryManagement.Object;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(generator = "userSeq", strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "userSeq", sequenceName = "userSequence",initialValue = 1,allocationSize = 1)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String userName;
    private String password;
    private String delete;

    public Users() {

    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", delete='" + delete + '\'' +
                '}';
    }

    public Users(int id, String firstName, String lastName, String address, String phoneNo, String userName, String password, String delete) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.userName = userName;
        this.password = password;
        this.delete = delete;
    }

}
