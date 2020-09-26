package com.westone.springbootfirstdemo.Service;

import com.westone.springbootfirstdemo.entities.Employee;
import com.westone.springbootfirstdemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiongyahui
 */
@Service
public class EmployeeService {

    @Autowired
    //这里需要注入，简直是日了狗了，是idea的问题，他识别不了mapper的自动注入，不能自动装配
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee(){
        System.out.println("查询到了这条数据");
        return employeeMapper.getAllEmployee();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMapper.getEmployeeById(id);
    }

    public int InsertEmployee(Employee employee){
        return employeeMapper.InsertEmployee(employee);
    }

    public int UpdateEmployee(Employee employee){
        return employeeMapper.UpateEmployee(employee);
    }

    public int DeleteEmployeeById(Integer id){
        return employeeMapper.DeleteEmployeeById(id);
    }


}
