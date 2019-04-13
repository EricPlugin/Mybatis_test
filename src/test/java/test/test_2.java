package test;

import bean.Student;
import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class test_2 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

    //课堂示例
        //单参数查询
        /*List<User> list = sqlSession.selectList("findUserByUsername","111");
        for (User user:list){
            System.out.printf(user.getUsername()+user.getPassword());
        }
        sqlSession.close();*/

        //多参数查询
            //使用map传递参数
        /*Map<String,Object> cnd=new HashMap<>();
        cnd.put("username", "111");
        cnd.put("password", "222");
        List<Map> list = sqlSession.selectList("findUserByMap",cnd);
        for (Map map:list){
            System.out.printf((String) map.get("username"));
            System.out.printf((String) map.get("password"));

        }
        sqlSession.close();*/
            //使用自定义实体类传递参数
        /*User userCnd=new User();
        userCnd.setUsername("111");
        userCnd.setPassword("222");
        List<User> list = sqlSession.selectList("findUserByUsernameAndPassword",userCnd);
        for (User user:list){
            System.out.printf(user.getUsername());
            System.out.printf(user.getPassword());

        }
        sqlSession.close();*/
    //课堂作业
        Student studentCnd=new Student();
        studentCnd.setNo("001");
        studentCnd.setName("张三");
        List<Student> list=sqlSession.selectList("findStudentByClass",studentCnd);
        for (Student student:list){
            System.out.printf(student.getNo()+student.getName());
        }



    }
}
