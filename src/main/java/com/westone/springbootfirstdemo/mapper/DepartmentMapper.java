package com.westone.springbootfirstdemo.mapper;


import com.westone.springbootfirstdemo.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiongyahui
 */
@Repository
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id= #{id}")
    Department getDepartmentById(Integer id);

    @Select("select * from department")
    List<Department> getAllDepartment();

}
