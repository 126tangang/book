package test;

import bean.User;
import org.junit.Test;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void registerUser() {
//        userService.registerUser(new User(null, "李四", "lisi", "lisi@169.com"));
        userService.registerUser(new User(null, "王麻子", "wangmazi", "wmz@169.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "李四", "lisier", null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("李四"));
    }
}