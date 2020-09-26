package com.westone.springbootfirstdemo.Service;

import com.westone.springbootfirstdemo.entities.Department;
import com.westone.springbootfirstdemo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDepartmentById(Integer id){
        return departmentMapper.getDepartmentById(id);
    }

    public List<Department> getAllDepartment(){
        return departmentMapper.getAllDepartment();
    }
}
