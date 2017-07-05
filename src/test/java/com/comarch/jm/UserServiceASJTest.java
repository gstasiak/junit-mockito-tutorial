package com.comarch.jm;

import java.util.ArrayList;
import java.util.List;

import com.comarch.jm.user.User;
import com.comarch.jm.user.UserService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class UserServiceASJTest {

    private UserService userService = new UserService();

    @Test
    public void generatingLoginWorksAsExpected() {
        //given
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertThat(loginForUser, is(notNullValue()));

        //to to samo
        assertThat(loginForUser, equalTo("LAST-FIRST"));
        assertThat(loginForUser, is(equalTo("LAST-FIRST")));
        assertThat(loginForUser, is("LAST-FIRST"));

        assertThat(loginForUser, anyOf(is(nullValue()), is("LAST-FIRST")));
    }

    @Test
    public void generatedLoginsDoesNotContainSomeString() {
        //given
        User user = new User();
        user.setFirstName("first1");
        user.setLastName("last1");
        User user2 = new User();
        user2.setFirstName("first2");
        user2.setLastName("last2");

        //when
        List<String> logins = new ArrayList<>();
        logins.add(userService.generateLogin(user));
        logins.add(userService.generateLogin(user2));

        //then
        assertThat(logins, is(notNullValue()));
        assertThat(logins, hasSize(2));
        assertThat(logins, not(contains("LAST-FIRST")));

        assertThat(Boolean.TRUE, is(true));

        assertThat(logins.get(0), startsWith("L"));

        assertThat(logins, contains("LAST2-FIRST2", "LAST1-FIRST1"));
        assertThat(logins, containsInAnyOrder("LAST1-FIRST1", "LAST2-FIRST2"));

        //assertThat(value, everyItem(hasProperty("param", is(not((someValue))))));
    }

    //Cwiczenie 2
    //TODO: Testy do napisania - to samo co poprzednio tylko z użyciem hamcresta
    //com.comarch.jm.user.UserService.getActivityInterval()
    //Zmienić nazwy!
    @Test
    public void test1() {
        //FIXME: czy zwróci interwał taki jak oczekujemy?
    }

    @Test
    public void test2() {
        //FIXME: czy rzuci wyjątkiem jak daty są w odwrotnej kolejności (IllegalArgumentException)
    }

    @Test
    public void test3() {
        //FIXME: a co jeśli daty są nullowe?
    }

}
