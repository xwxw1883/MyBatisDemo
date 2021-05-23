package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();
//    根据id查询用户
    User getUserById(int i);
    //新增一个用户
    int addUser(User user);
    //修改一个客户
    int upDateUser(User user);
    int deleteUser(int id);
}
