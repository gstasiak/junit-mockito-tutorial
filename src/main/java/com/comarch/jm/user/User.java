package com.comarch.jm.user;

import java.util.Date;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private Date activeFrom;
    private Date activeTo;

}
