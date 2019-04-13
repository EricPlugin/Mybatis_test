package test;

import bean.User;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class test_5 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //课堂示例
            //获得接口
        UserDao userDao=sqlSession.getMapper(UserDao.class);
            //操作数据库
        User user=userDao.findUserByUsername("111");
        System.out.printf(user.getPassword());

        //课堂作业
    }
}