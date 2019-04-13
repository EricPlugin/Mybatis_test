package test;

import bean.Employee;
import bean.Student;
import cnd.EmployeeCnd;
import cnd.StudentCnd;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class test_7 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //课堂示例
        EmployeeCnd cnd=new EmployeeCnd();
        cnd.setUsername("张三");

        //trim标签实现
            //情况1：修改密码
        //cnd.setPassword("444");
            //情况2：修改性别
        //cnd.setSex(1);
            // 输出结果
        /*int i=sqlSession.update("updateEmployeeByUsername",cnd);
        sqlSession.commit();
        System.out.println(i);*/

        //foreach标签实现
        /*List<String> list=new ArrayList();
        list.add("张三");
        list.add("李四");
        List<Employee> employees= sqlSession.selectList("findSelectEmployees",list);
        //4.输出结果
        for(Employee item:employees){
            System.out.println(item.getPassword());
        }*/

        //课堂作业
            //(1)修改用户名为张三的学号、性别和班级编号，注意：有学号则修改学号，有性别修改性别，有班级编号则修改班级编号
        StudentCnd cnd1=new StudentCnd();
        cnd1.setName("张三");
        //cnd1.setClassno("003");
        //cnd1.setSex(0);
        cnd1.setClassno("002");
        int i=sqlSession.update("updateStudentByCnd",cnd1);
        sqlSession.commit();
        System.out.println(i);
            //(2)根据班级编号、性别、查询student表所有记录，输出用户名，注意：有几个查几个条件，没有条件查询所有
        /*StudentCnd cnd1=new StudentCnd();
        cnd1.setClassno("003");
        //cnd1.setSex(0);
        List<Student> list=sqlSession.selectList("findStudentByCnd",cnd1);
        for (Student student:list){
            System.out.printf(student.getName());
        }*/
            //(3)查张三和王五的所在班级名称。要求使用mybatis的foreach循环查询
        /*List<String> list=new ArrayList<>();
        list.add("张三");
        list.add("王五");
        List<Student> list1=sqlSession.selectList("findSelectStudents",list);
        for (Student student:list1){
            System.out.printf(student.getCla().getClassname());
        }*/
    }
}