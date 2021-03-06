package com.comarch.jm;

import com.comarch.jm.user.FirstNameCannotBeNullException;
import com.comarch.jm.user.User;
import com.comarch.jm.user.UserService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

//@RunWith(JUnitParamsRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
@RunWith(ExtendedJUnitTestRunner.class)
public class UserServiceTest {

    private UserService userService = new UserService();

    @BeforeClass
    public static void initBeforeClass() {
        System.out.println("initBeforeClass");
    }

    @AfterClass
    public static void cleanAfterClass() {
        System.out.println("cleanAfterClass");
    }

    @Before
    public void initBefore() {
        System.out.println("initBefore");
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

        //assertTrue
        //assertFalse

        //assertNull

        //Referencje!
        //assertSame
        //assertNotSame
    }

    //czemu to jest problematyczne?
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

    @Test
    public void generatingLoginWithNullLastNameCannotBeNull() {
        //given
        User user = new User();
        user.setFirstName("first");
        user.setLastName(null);

        //when
        try {
            userService.generateLogin(user);
            //then
            fail();
        } catch (NullPointerException ex) {
        }
    }

    @Test(timeout = 1000)
    public void testCannotTakesLongerThanOneSecond() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    @Test
    public void testSomeFunctionalityOnlyOnLinux() {
        //Assume.assumeTrue(System.getProperty("os.name").contains("Linux"));
        //...
        fail();
    }

    //Cwiczenie 1
    //TODO: Testy do napisania
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
