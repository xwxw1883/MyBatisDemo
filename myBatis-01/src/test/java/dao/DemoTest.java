package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import until.MyBatisUntil;

import java.util.List;

public class DemoTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){

        }finally {
            sqlSession.close();

        }
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int hhh = mapper.addUser(new User(2, "hhh", "890"));
        System.out.println(hhh);
        //JDBC 提交事物 增删改查
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int hhh = mapper.upDateUser(new User(2, "www", "1000"));
        System.out.println(hhh);
        //JDBC 提交事物 增删改查
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void deleteUser(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(1);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

}
