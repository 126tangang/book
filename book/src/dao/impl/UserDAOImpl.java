package dao.impl;

import bean.User;
import dao.UserDAO;

import java.sql.Connection;

public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public User queryUserByUsername(Connection connection, String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(connection, sql, User.class, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(Connection connection, String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(connection, sql, User.class, username, password);
    }

    @Override
    public int saveUser(Connection connection, User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values (?, ?, ?);";
        return update(connection, sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
