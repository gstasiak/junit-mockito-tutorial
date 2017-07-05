package com.comarch.jm.user;

import lombok.Getter;

@Getter
public class FirstNameCannotBeNullException extends RuntimeException {

    private final String msg;

    FirstNameCannotBeNullException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
