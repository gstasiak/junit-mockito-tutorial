package com.comarch.jm;

import java.util.ArrayList;
import java.util.List;

import com.comarch.jm.user.FirstNameCannotBeNullException;
import com.comarch.jm.user.User;
import com.comarch.jm.user.UserService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(loginForUser).isNotNull();
        assertThat(loginForUser).isEqualTo("LAST-FIRST");
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
        assertThat(logins).isNotNull();
        assertThat(logins).hasSize(2);
        assertThat(logins).doesNotContain("LAST-FIRST");

        assertThat(Boolean.TRUE).isTrue();

        assertThat(logins).extracting(String::length).contains(12);
        //assertThat(object).extracting("someField").contains(someValues);

        assertThat(logins).filteredOn(login -> login.contains("2")).containsOnly("LAST2-FIRST2");
    }

    @Test
    public void generatedLoginIsCorrect() {
        //given
        User user3 = new User();
        user3.setFirstName("first3");
        user3.setLastName("last3");

        //when
        String login = userService.generateLogin(user3);

        //then
        //chain!
        assertThat(login).startsWith("LAS").endsWith("3").isEqualToIgnoringCase("LAST3-FIRST3");
    }

    @Test
    public void generatingLoginWithNullFirstNameCannotBeNull() {
        //given
        User user = new User();
        user.setFirstName(null);
        user.setLastName("last");

        //when
        //then
        assertThatThrownBy(() -> userService.generateLogin(user)).isExactlyInstanceOf(FirstNameCannotBeNullException.class);
    }

    @Test
    public void generatingLoginWithNullFirstNameReallyCannotBeNull() {
        //given
        User user = new User();
        user.setFirstName(null);
        user.setLastName("last");

        //when
        Throwable throwable = catchThrowable(() -> userService.generateLogin(user));

        //then
        assertThat(throwable).isExactlyInstanceOf(FirstNameCannotBeNullException.class);
        assertThat(throwable).hasMessageContaining("ups");
    }

    //TODO: Testy do napisania - to samo co poprzednio tylko z użyciem assertj
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
