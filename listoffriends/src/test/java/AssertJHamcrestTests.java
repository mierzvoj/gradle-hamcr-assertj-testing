import org.example.Friendships;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJHamcrestTests {
    Friendships fs = new Friendships();

    @Before
    public void setUp() {
    }

    //Hamcrest
    @Test
    public void testListLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark"), hasSize(3));
    }

    @Test
    public void testListContent() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark"), contains("John", "Ewe", "Jon"));
    }

    @Test
    public void testListContentUnOrdered() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark"), containsInAnyOrder("Ewe", "John", "Jon"));
    }

    @Test
    public void testListContentEmpty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Friendships fs1 = new Friendships();
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "");
        assertTrue(fs.getFriendsList("Mark").size() == 1);
    }

    @Test
    public void testListContentEmptyCompletely() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Friendships fs1 = new Friendships();
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "", "");
        assertTrue(fs.getFriendsList("Mark").size() == 0);
    }

    //AssertJ
    @Test
    public void testListLengthAssertJ() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark")).hasSize(3).containsOnly("John", "Ewe", "Jon");
    }

    @Test
    public void testListContentAssertJ() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark")).hasSize(3).containsExactlyInAnyOrder("Ewe", "John", "Jon");
    }

    @Test
    public void testListContentNotNullAssertJ() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark")).hasSize(3).containsExactlyInAnyOrder("Ewe", "John", "Jon").doesNotContainNull();
    }

    @Test
    public void testListBeginsAssertJ() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark")).hasSize(3).containsExactlyInAnyOrder("Ewe", "John", "Jon").startsWith("John");
    }

    @Test
    public void testListContainsAssertJ() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        method.invoke(fs, "Mark", "Ewe");
        method.invoke(fs, "Mark", "Jon");
        assertThat(fs.getFriendsList("Mark")).hasSize(3).containsExactlyInAnyOrder("Ewe", "John", "Jon").contains("John");
    }

}
