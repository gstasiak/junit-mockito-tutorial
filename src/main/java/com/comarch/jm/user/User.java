package com.comarch.jm.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String login;
    private Date activeFrom;
    private Date activeTo;

}
