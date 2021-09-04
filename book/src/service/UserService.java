package service;

import bean.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return  返回true表示用户名已存在，参会false表示用户名不存在
     */
    public boolean existsUsername(String username);
}
