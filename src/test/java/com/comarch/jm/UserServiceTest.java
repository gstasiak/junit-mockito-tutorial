package com.comarch.jm;

import com.comarch.jm.user.FirstNameCannotBeNullException;
import com.comarch.jm.user.User;
import com.comarch.jm.user.UserService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@RunWith(JUnitParamsRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
public class UserServiceTest {

    private UserService userService = new UserService();

    @BeforeClass
    public static void initBeforeClass() {
        System.out.println("initBeforeClass");
    }

    @Before
    public void initBefore() {
        System.out.println("initBefore");
    }

    @AfterClass
    public static void cleanAfterClass() {
        System.out.println("cleanAfterClass");
    }

    @Before
    public void cleanAfter() {
        System.out.println("cleanAfter");
    }

    @Test
    public void generatingLoginWorksAsExpected() {
        //given
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertNotNull(loginForUser);
        assertEquals("LAST-FIRST", loginForUser);
    }

    //1) czemu to jest problematyczne?
    @Test(expected = FirstNameCannotBeNullException.class)
    public void generatingLoginWithNullFirstNameCannotBeNull() {
        //given
        User user = new User();
        user.setFirstName(null);
        user.setLastName("last");

        //when
        userService.generateLogin(user);

        //then
    }

    //2) Testy do napisania
    //com.comarch.jm.user.UserService.getActivityInterval()
    //Zmienić nazwy!
    @Test
    public void test1() {
        //FIXME: czy zwróci interwał taki jak oczekujemy?
    }
    @Test
    public void test2() {
        //FIXME: czy rzuci wyjątkiem jak daty są w odrotnej kolejności (IllegalArgumentException)
    }
    @Test
    public void test3() {
        //FIXME: a co jeśli daty są nullowe?
    }

    //@Ignore
    @Test
    public void generatingLoginIgnoresWhitespaces() {
        //given
        User user = new User();
        user.setFirstName("first name");
        user.setLastName("last");

        //when
        String loginForUser = userService.generateLogin(user);

        //then
        assertNotNull(loginForUser);
        assertEquals("LAST-FIRSTNAME", loginForUser);
    }

}
