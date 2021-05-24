package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import until.MyBatisUntil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //用map传递
    @Test
    public void addUser2(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String,Object> ();
        map.put ("userid",6);
        map.put ("username","1234");
        map.put ("userpwd","1234");
        int hhh = mapper.addUser2(map);
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
    @Test
    public  void getUserLike(){
        SqlSession sqlSession = MyBatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> x = mapper.getUserLike ("X");
        for (User user : x) {
            System.out.println (user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
