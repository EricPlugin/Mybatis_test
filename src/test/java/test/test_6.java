package test;

import bean.Employee;
import cnd.EmployeeCnd;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class test_6 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //课堂示例
        EmployeeCnd cnd=new EmployeeCnd();

        //if标签
            //sex!=null
        //cnd.setSex(1);
        /*cnd.setSex(0);
        List<Employee> list=sqlSession.selectList("findEmployeesBySex",cnd);
        for (Employee employee:list){
            System.out.printf(employee.getUsername()+employee.getPassword()+employee.getDept().getId()+employee.getDept().getDeptname());
        }*/
            //sex==null
       /* List<Employee> list1=sqlSession.selectList("findEmployeesBySex");
        for (Employee employee:list1){
            System.out.printf(employee.getUsername()+employee.getPassword()+employee.getDept().getId()+employee.getDept().getDeptname());
        }*/

        //choose标签
            //情况1，有用户名
        //cnd.setUsername("王五");
            //情况2，有部门名
        //cnd.setDeptname("开发一部");
            //情况3，有性别
        //cnd.setSex(1);
            // 4.输出结果
        /*List<Employee> list= sqlSession.selectList("findEmployeesByCnd",cnd);
        for (Employee employee:list){
            System.out.printf(employee.getUsername()+employee.getPassword()+employee.getDept().getId()+employee.getDept().getDeptname());
        }*/

        //where标签
        //情况1，有部门号
        //cnd.setDeptid(1);
        //情况3，有性别
        //cnd.setSex(1);
        // 4.输出结果
        /*List<Employee> list= sqlSession.selectList("findEmployeeByParam",cnd);
        for (Employee employee:list){
            System.out.printf(employee.getUsername()+employee.getPassword());
        }*/

        //set标签
        //cnd.setUsername("张三");

            //情况1：修改密码
        //cnd.setPassword("444");
            //情况2：修改性别
        //cnd.setSex(1);
            // 输出结果
        /*int i=sqlSession.update("updateEmployeeByUsername",cnd);
        sqlSession.commit();
        System.out.println(i);*/

        //课堂作业
    }
}