package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


public class Friendships {
    Map<String, List<String>> friendships = new HashMap<String, List<String>>();

    public List<String> newFriendsList() {
        return new ArrayList<String>();
    }


    public Map<String, List<String>> getFriends() {
        return friendships;
    }

    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }


    public List<String> getFriendsList(String person) {
        List<String> friendsList = newFriendsList();
        if (getFriends().containsKey(person)) {
            friendsList = getFriends().get(person);
        } else {
            getFriends().put(person, friendsList);
        }
        return friendsList;
    }


    public boolean areFriends(String person1, String person2) {
        System.out.println(String.valueOf(getFriendsList(person1).contains(person2)));
        return getFriendsList(person1).contains(person2);
    }

    private void addFriend(String person, String friend) {
        getFriendsList(person).add(friend);

    }



}
