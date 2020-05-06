package com.company.springsecurityjwt.services;

import com.company.springsecurityjwt.model.User;
import com.company.springsecurityjwt.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private static Set<User> userList = new HashSet<>();

    static {
        userList.add(
                new User(1, "Yadigar", "Elekberli,", "alakbarli.yadigar@gmail.com",
                        "$2a$10$SuSC9Fafb5aWlhTyNEaosu4h8CaMvv0FHVxVjAHj6fdaIKflMxlWC", "Admin", true));

        userList.add(
                new User(2, "Sunel", "Huseynquliyev,", "sunel.huseynquluyev@gmail.com",
                        "$2a$10$AdNz5KybrClQy5l9e8PwC.F/ydO4/Hmo4gSCUW7hUtZopxvSEIpN.", "Moderator", true));

        userList.add(
                new User(3, "Alakbar", "Ibrahimov,", "alakbar.ibrahimov@gmail.com",
                        "$2a$10$/Fxf1nUcdh9.w5qyUnh57u8PBctf/nQwCPtmx6YaJCGNhPZG8tKh.", "User", true));

        userList.add(
                new User(4, "Ruslan", "Ibrahimov,", "ruslan.ibrahimov@gmail.com",
                        "$2a$10$M84bjzIirFcWjORJurpOpuhWYrQrkUyEBkMpEFzXkqei/hXA4ZgmK", "Admin", false));
    }

    public UserDetails loadUserByUsername(String email) {

        Iterator<User> userIterator = userList.iterator();
        User user;
        UserDetails userDetails;
        while (userIterator.hasNext()) {
            user = userIterator.next();
            if (user.getEmail().equals(email))
                return new CustomUserDetails(user);
        }
        return new CustomUserDetails(new User());
    }

}
