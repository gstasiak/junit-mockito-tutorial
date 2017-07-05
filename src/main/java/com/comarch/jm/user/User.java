package com.comarch.jm.user;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private Date activeFrom;
    private Date activeTo;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
