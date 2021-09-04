package dao;

import bean.User;

import java.sql.Connection;

public interface UserDAO {

    /**
     * 根据用户名查询用户信息
     * @param username  用户名
     * @return  如果返回null，则用户不存在！
     */
    public User queryUserByUsername(Connection connection, String username);

    /**
     * 根据用户名和密码查询用户
     * @param username  用户名
     * @return  如果返回null，则用户不存在！
     */
    public User queryUserByUsernameAndPassword(Connection connection, String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(Connection connection, User user);



}
