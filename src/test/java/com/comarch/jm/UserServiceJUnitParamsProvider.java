package com.comarch.jm;

import com.comarch.jm.user.User;

public class UserServiceJUnitParamsProvider {

    public static Object[] provideFirst() {
        return new Object[]{new Object[]{new User("first", "last"), "LAST-FIRST"}, new Object[]{new User("first2", "last2"), "LAST2-FIRST2"}};

    }

    public static Object[] provideSecond() {
        return new Object[]{new Object[]{new User("1first", "last"), "LAST-1FIRST"}, new Object[]{new User("first2", "1last2"), "1LAST2-FIRST2"}};
    }
}
