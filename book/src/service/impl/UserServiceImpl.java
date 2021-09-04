package service.impl;

import bean.User;
import dao.impl.UserDAOImpl;
import service.UserService;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            userDAO.saveUser(connection, user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
    }

    @Override
    public User login(User user) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return userDAO.queryUserByUsernameAndPassword(connection, user.getUsername(), user.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    @Override
    public boolean existsUsername(String username) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            if (userDAO.queryUserByUsername(connection, username) == null){
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }

        return true;
    }
}
