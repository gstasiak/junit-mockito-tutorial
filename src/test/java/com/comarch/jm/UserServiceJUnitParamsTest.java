package com.comarch.jm;

import com.comarch.jm.user.User;
import com.comarch.jm.user.UserService;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.StrictAssertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UserServiceJUnitParamsTest {

    private UserService userService = new UserService();

    @Test
    //Tylko Stringi i coś co można zmapować
    @Parameters({"first, last, LAST-FIRST", "first2, last2, LAST2-FIRST2", "first3, last3, LAST3-FIRST3", "first4, last3, LAST3-FIRST3"})
    public void generatingLoginWorksAsExpected(String first, String last, String expectedLogin) {
        //given
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertThat(loginForUser).isNotNull();
        assertThat(loginForUser).isEqualTo(expectedLogin);
    }

    @Test
    @Parameters
    @TestCaseName("user({0}) with expected login {1}")
    public void generatingLoginWorksAsExpectedWithUserPassed(User user, String expectedLogin) {
        //given

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertThat(loginForUser).isNotNull();
        assertThat(loginForUser).isEqualTo(expectedLogin);
    }

    @Test
    @Parameters(method = "getParams")
    public void generatingLoginWorksAsExpectedWithUserPassedSecond(User user, String expectedLogin) {
        //given

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertThat(loginForUser).isNotNull();
        assertThat(loginForUser).isEqualTo(expectedLogin);
    }

    @Test
    @Parameters(source = UserServiceJUnitParamsProvider.class)
    public void generatingLoginWorksAsExpectedWithUserPassedThird(User user, String expectedLogin) {
        //given

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertThat(loginForUser).isNotNull();
        assertThat(loginForUser).isEqualTo(expectedLogin);
    }

    private Object[] parametersForGeneratingLoginWorksAsExpectedWithUserPassed() {
        return new Object[]{new Object[]{new User("first", "last"), "LAST-FIRST"}, new Object[]{new User("first2", "last2"), "LAST2-FIRST2"},
                            new Object[]{new User("first3", "last3"), "LAST3-FIRST3"}, new Object[]{new User("first4", "last4"), "LAST3-FIRST4"}};
    }

    @SuppressWarnings("unused")
    private Object[] getParams() {
        return parametersForGeneratingLoginWorksAsExpectedWithUserPassed();
    }

    //Cwiczenie 4
    //TODO: Testy do napisania - to samo co poprzednio tylko, ale z większą ilością danych
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
