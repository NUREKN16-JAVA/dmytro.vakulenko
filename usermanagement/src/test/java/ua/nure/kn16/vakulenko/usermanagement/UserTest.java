package ua.nure.kn16.vakulenko.usermanagement;

import org.junit.Before;
import org.junit.Test;

import ua.nure.kn16.vakulenko.usermanagement.User;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;
    private static final long ID = 1L;
    private static final String FIRSTNAME = "Ivan";
    private static final String LASTNAME = "Ivanov";

    @Before
    public void setUp()  throws Exception {
        user = new User(ID, FIRSTNAME, LASTNAME, null);
    }

    @Test
    public void testGetFullName() throws Exception {
        assertEquals("Ivan, Ivanov", user.getFullName());
    }

    @Test
    public void testGetAgeAfter() throws Exception {
        LocalDate localDate =LocalDate.of(1998, 4, 8);
        User user = new User(ID, FIRSTNAME, LASTNAME, localDate);
        assertEquals(20, user.getAge());
    }

    @Test
    public void testGetAgeBefore() throws Exception {
        LocalDate localDate = LocalDate.of(1998, 12, 13);
        User user = new User(ID, FIRSTNAME, LASTNAME, localDate);
        assertEquals(19, user.getAge());
    }

    @Test
    public void testGetAgeSameMonthAfter() throws Exception {
        LocalDate localDate = LocalDate.of(1998, 10, 10);
        User user = new User(ID, FIRSTNAME, LASTNAME, localDate);
        assertEquals(20, user.getAge());
    }

    @Test
    public void testGetAgeSameMonthBefore() throws Exception {
        LocalDate localDate = LocalDate.of(1998, 10, 31);
        User user = new User(ID, FIRSTNAME, LASTNAME, localDate);
        assertEquals(19, user.getAge());
    }

    @Test
    public void testGetAgeSameDay () throws Exception {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.withYear(1998);
        User user = new User(ID, FIRSTNAME, LASTNAME, localDate);
        assertEquals(20, user.getAge());
    }
}
