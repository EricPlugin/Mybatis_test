package dao;

import bean.User;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * resultType对应返回值
     * parameterType对应参数
     * id对应方法名
     * @param username
     * @return User
     */
    public User findUserByUsername(String username);
}
