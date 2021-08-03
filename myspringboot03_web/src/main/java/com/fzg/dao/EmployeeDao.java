package com.fzg.dao;

import com.fzg.pojo.Department;
import com.fzg.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> emlpoyees = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        emlpoyees = new HashMap<Integer, Employee>();
        emlpoyees.put(1001,new Employee(1001,"AA","1840633803@qq.com",1,new Department(101,"教学部")));
        emlpoyees.put(1002,new Employee(1002,"BB","1810633803@qq.com",0,new Department(102,"市场部")));
        emlpoyees.put(1003,new Employee(1003,"CC","1820633803@qq.com",0,new Department(103,"教研部")));
        emlpoyees.put(1004,new Employee(1004,"DD","1830633803@qq.com",1,new Department(104,"运营部")));
        emlpoyees.put(1005,new Employee(1005,"EE","1850633803@qq.com",1,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initid=1006;
    //增加一个员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        emlpoyees.put(employee.getId(), employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return emlpoyees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return emlpoyees.get(id);
    }
    //删除员工
    public void delete(Integer id){
        emlpoyees.remove(id);
    }
}
