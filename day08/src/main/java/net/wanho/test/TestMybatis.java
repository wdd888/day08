package net.wanho.test;

import net.wanho.entity.User;
import net.wanho.mapper.UserMapper;
import net.wanho.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class TestMybatis {

    /*   private  SqlSession sqlSession;
     @Before
      public void before() {
          InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
          SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
           sqlSession = sessionFactory.openSession();

      }*/
    @Test
    public void testInsert() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = new User(1, "wdd", "1234", "0", 2);
        sqlSession.update("net.wanho.mapper.UserMapper.insert", user);
        sqlSession.commit();
        MybatisUtils.closeSession();
    }


    @Test
    public void testSelectAllUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("net.wanho.mapper.UserMapper.selectAllUser");
        System.out.println(users);
        sqlSession.commit();
        MybatisUtils.closeSession();
    }


    @Test
    public void testSelectUserById() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(17);
//        User user = sqlSession.selectOne("net.wanho.mapper.UserMapper.selectUserById", 17);
        System.out.println(user);
        sqlSession.commit();
        MybatisUtils.closeSession();


    }




    @Test
    public void testSelectUserByName() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUserByName("%w%");
        System.out.println(users);
        sqlSession.commit();
        MybatisUtils.closeSession();


    }


    @Test
    public void testSelectUserByName1() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername1("w");
        List<User> users = userMapper.selectUserByName1(user);
        System.out.println(users);
        sqlSession.commit();
        MybatisUtils.closeSession();


    }


    @Test
    public void testSelectUserByName2() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUserByName2("w");
        System.out.println(users);
        sqlSession.commit();
        MybatisUtils.closeSession();


    }


    @Test
    public void tsetInsertReturnKey() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "wdd", "1234", "0", 2);
        userMapper.insertReturnKey(user);
        sqlSession.commit();
        System.out.println(user.getId());
        MybatisUtils.closeSession();


    }




    @Test
    public void tsetInsertReturnKey1() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "wdd", "1234", "0", 2);
        userMapper.insertReturnKey1(user);
        sqlSession.commit();
        System.out.println(user.getId());
        MybatisUtils.closeSession();


    }



    @Test
    public void testUpdateUser() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "wdd", "1234", "0", 2);
        userMapper.updateUser("zhangsan","12345667",20);
        sqlSession.commit();

        MybatisUtils.closeSession();


    }



    @Test
    public void testUpdateUser1() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "wdd", "1234", "0", 2);
        userMapper.updateUser1(20,"lisi","12345667");
        sqlSession.commit();

        MybatisUtils.closeSession();


    }



    @Test
    public void testUpdateUser2() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "wangwu", "1111111", "0", 2);
        userMapper.updateUser2(user,20);
        sqlSession.commit();

        MybatisUtils.closeSession();


    }




    @Test
    public void testUpdateUser3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "silu", "1111111", "0", 2);
        userMapper.updateUser3(user,20);
        sqlSession.commit();

        MybatisUtils.closeSession();


    }

}
