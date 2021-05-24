package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();
    //获取全部用户
    List<User> getUserLike(String value);
//    根据id查询用户
    User getUserById(int i);
    //新增一个用户
    int addUser(User user);
    int addUser2(Map<String,Object> map);
    //修改一个客户
    int upDateUser(User user);
    int deleteUser(int id);
}
