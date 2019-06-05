package net.wanho.utils;

import net.wanho.test.TestMybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/6/5.
 */
public class MybatisUtils {

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    private static SqlSessionFactory sessionFactory;

    static {
        InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }


}
