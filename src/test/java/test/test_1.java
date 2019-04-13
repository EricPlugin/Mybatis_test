package test;

import bean.Student;
import bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.apache.ibatis.io.Resources.*;

public class test_1 {
    public static void main(String[] args) throws IOException{
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //课堂示例
        /*
        List<User> list = sqlSession.selectList("findAllUser");
        for (User user: list) {
            System.out.println("用户名："+user.getUsername()+"，密码："+user.getPassword());
        }
        sqlSession.close();*/


        //课堂作业
        List<Student> list = sqlSession.selectList("findAllStudent");
        for (Student student: list) {
            System.out.println("学号："+student.getNo()+"，姓名："+student.getName());
        }
        sqlSession.close();
    }
}
