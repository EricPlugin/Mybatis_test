package test;

import bean.Student;
import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class test_3 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //课堂示例
        User user=new User();

        //新增操作  1-操作成功 0-操作失败
        /*user.setUsername("222");
        user.setPassword("444");
        int i=sqlSession.insert("insertUser", user);*/

        //修改操作  1-操作成功 0-操作失败
        /*user.setUsername("111");
        user.setPassword("666");
        int i=sqlSession.update("updateUser", user);*/

        //删除操作  1-操作成功 0-操作失败
        //int i=sqlSession.delete("deleteUser","王五");

        //提交并关闭数据库
        /*sqlSession.commit();
        sqlSession.close();
        System.out.println(i);*/

        //课堂作业
        Student student=new Student();
        student.setNo("003");
        student.setName("李斯");
        //int i=sqlSession.insert("insertStudent",student);
        //int i=sqlSession.update("updateStudent",student);
        //int i=sqlSession.delete("deleteStudent","003");
        sqlSession.commit();
        sqlSession.close();
        //System.out.println(i);

    }
}
