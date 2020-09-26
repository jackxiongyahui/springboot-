package com.westone.springbootfirstdemo.mapper;

import com.westone.springbootfirstdemo.entities.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiongyahui
 */
@Repository
@Mapper
public interface EmployeeMapper {

    //查询employee的全部数据，为什么会返回空指针
    @Select("select * from employee")
    List<Employee> getAllEmployee();

    //查询某一条数据
    @Select("select * from employee where id = #{id}")
    Employee getEmployeeById(Integer id);

    @Insert("insert into employee(lastName, email, gender, department_id, birth) " +
            "values (#{lastName}, #{email}, #{gender}, #{department_id}, #{birth})")
    int InsertEmployee(Employee employee);

    @Update("update employee set lastName=#{lastName}, email=#{email}, gender=#{gender}, department_id=#{department_id}, birth=#{birth}" +
            "where id=#{id}")
    int UpateEmployee(Employee employee);

    @Delete("delete from employee where id=#{id}")
    int DeleteEmployeeById(Integer id);
}
