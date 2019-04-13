package test;

import bean.Department;
import bean.Employee;
import bean.Student;
import bean.User;
import bean.Class;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class test_4 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //课堂示例
            //自定义映射查询
        /*User userCnd=new User();
        userCnd.setUsername("111");
        userCnd.setPassword("666");
        //User user=sqlSession.selectOne("findUserByUser",userCnd);
        User user=sqlSession.selectOne("findUserByUser1",userCnd);
        System.out.println(user.getUsername()+user.getPassword());*/
            //联合查询  多对一
        /*List<Employee> list=sqlSession.selectList("findEmployees");
        for (Employee employee:list){
            System.out.println(employee.getUsername()+employee.getPassword()+employee.getDept().getId()+employee.getDept().getDeptname());
        }*/
            //联合查询  一对多
        /*List<Department> list=sqlSession.selectList("findDepartments");
        for (Department department:list){
            System.out.println(department.getId()+department.getDeptname());
            List<Employee> list1=department.getEmployees();
            for (Employee employee:list1){
                System.out.println(employee.getUsername()+employee.getPassword());
            }
        }*/
        //课堂作业
            //多对一
        /*List<Student> list=sqlSession.selectList("findStudents");
        for (Student student:list){
            System.out.println(student.getNo()+student.getName()+student.getCla().getClassno()+student.getCla().getClassname());
        }*/
            //一对多
        /*List<Class> list=sqlSession.selectList("findClasses");
        for (Class cla:list){
            System.out.println(cla.getClassno()+cla.getClassname());
            List<Student> list1=cla.getStudents();
            for (Student student:list1){
                System.out.println(student.getNo()+student.getName());
            }
        }*/
    }
}