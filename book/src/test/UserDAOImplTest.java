package test;

import bean.User;
import dao.impl.UserDAOImpl;
import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    @Test
    public void queryUserByUsername() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.queryUserByUsername(connection, "admin"));
        JdbcUtils.close(connection);
    }

    @Test
    public void queryUserByUsernameAndPassword() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.queryUserByUsernameAndPassword(connection, "admin", "admin"));
        JdbcUtils.close(connection);
    }

    @Test
    public void saveUser() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.saveUser(connection, new User(null, "张三", "zhangsan", "zs@qq.com")));
        JdbcUtils.close(connection);
    }
}