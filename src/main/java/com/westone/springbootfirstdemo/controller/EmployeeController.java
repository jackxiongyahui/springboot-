package com.westone.springbootfirstdemo.controller;

import com.westone.springbootfirstdemo.Service.DepartmentService;
import com.westone.springbootfirstdemo.Service.EmployeeService;
import com.westone.springbootfirstdemo.entities.Department;
import com.westone.springbootfirstdemo.entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author A
 */
@Api(tags = "员工管理")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    //显示employee的所有信息
    @ApiOperation(value = "显示员工列表")
    @GetMapping("/emps")
    public String list(Model model){
        //得到所有数据
        List<Employee> allEmployee = employeeService.getAllEmployee();
        //查询到部门的所有信息
        List<Department> allDepartment = departmentService.getAllDepartment();
        List<String> list = new ArrayList<>();

        for(Employee employee:allEmployee){
            for(Department department: allDepartment){
                if (employee.getDepartment_id().equals(department.getId())){
                    list.add(department.getDepartmentName());
                }
            }
        }
        System.out.println(list);
        HashMap<String,Employee> multiValueMap = new HashMap<>();

        for(int i=0;i<list.size();i++){
            multiValueMap.put(i+"_"+list.get(i), allEmployee.get(i));
            System.out.println(multiValueMap);
        }
        System.out.println(multiValueMap);
        //加查询到的数据传输到数据域model中
        model.addAttribute("emps",multiValueMap);
        //跳转到list页面，显示我有内容
        return "/emp/list";
    }

    //跳转到添加页面
    @ApiOperation(value = "跳转到员工添加页面",notes = "添加一条员工数据")
    @GetMapping("/emp")
    public String toAddEmployeePage(Model model){
        List<Department> allDepartment = departmentService.getAllDepartment();
        model.addAttribute("depts",allDepartment);
        return "/emp/add";
    }

    @ApiOperation(value = "员工数据添加操作")
    @PostMapping("/emp")
    //添加完成后提交数据
    public String InsertEmployee(Employee employee){
        //添加数据
//        System.out.println(employee);
        employeeService.InsertEmployee(employee);
        return "redirect:/emps";
    }

    @ApiOperation(value = "跳转到员工修改页面")
    @GetMapping("/emp/{id}")
    //跳转到修改页面
    public String toEditEmployeePage(@PathVariable("id") Integer id, Model model){
        //传递所有的部门供选择
        List<Department> allDepartment = departmentService.getAllDepartment();
        model.addAttribute("depts",allDepartment);
        //传递当前的员工信息
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp",employee);
        return "/emp/edit";
    }
    @ApiOperation(value = "员工数据修改操作")
    @PutMapping("/emp")
    //提交修改页面
    public String UpdateEmployee(Employee employee){
        //修改数据
        employeeService.UpdateEmployee(employee);
        return "redirect:/emps";
    }

    @ApiOperation(value = "跳转到员工删除页面")
    //跳转到删除界面
    @GetMapping("/delete/{id}")
    public String toDeleteEmployee(@PathVariable("id") Integer id,Model model){
        List<Department> allDepartment = departmentService.getAllDepartment();
        Employee employee = employeeService.getEmployeeById(id);
        for(int i=0;i<allDepartment.size();i++){
            if(allDepartment.get(i).getId().equals(employee.getDepartment_id())){
                model.addAttribute("dept",allDepartment.get(i).getDepartmentName());
            }
        }
        model.addAttribute("emp",employee);
        return "/emp/delete";
    }

    @ApiOperation(value = "员工数据删除操作")
    @DeleteMapping("/emp")
    //删除数据
    public String DeleteEmployee(Employee employee){
        //删除数据
        employeeService.DeleteEmployeeById(employee.getId());
        return "redirect:/emps";
    }


}
