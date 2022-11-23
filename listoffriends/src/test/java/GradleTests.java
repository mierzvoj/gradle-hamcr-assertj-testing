import org.example.Friendships;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class GradleTests {

    Friendships fs = new Friendships();

    @Test
    public void testPrivateMethodUsingReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        assertTrue(fs.areFriends("Mark", "John"));
    }

    @Test
    public void testAddingFriends() {
        fs.makeFriends("Ala", "Marek");
        assertTrue(fs.areFriends("Ala", "Marek"));
    }

    @Test
    public void testListNotEmpty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Friendships.class.getDeclaredMethod("addFriend", String.class, String.class);
        method.setAccessible(true);
        method.invoke(fs, "Mark", "John");
        Assertions.assertNotEquals(Collections.EMPTY_LIST, fs);

    }

    @Test
    public void testEmptyFriendsList() {
        Friendships fs1 = new Friendships();
        fs1.makeFriends("Mike", "");
        assertTrue(fs1.getFriendsList("Mike").size()== 1);
    }


    @Test
    public void testEmptyFriendsList1() {
        Friendships fs1 = new Friendships();
        fs1.makeFriends("", "");
        assertTrue(fs1.getFriendsList("Mike").size()== 0);
    }

}
