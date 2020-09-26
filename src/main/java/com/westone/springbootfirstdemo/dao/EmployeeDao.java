package com.westone.springbootfirstdemo.dao;

import com.westone.springbootfirstdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * @author A
 */
@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;

	@Autowired
	private DepartmentDao departmentDao;

    //静态代码块，在对象初始化的时候就会调用
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, 101));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, 102));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, 103));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, 104));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, 105));
	}

	private static Integer initId = 1006;

	//将employee的数据保存到map中
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employees.put(employee.getId(), employee);
	}

	//返回所有Employee的值
	public Collection<Employee> getAll(){
		return employees.values();
	}

	public Employee get(Integer id){
		return employees.get(id);
	}

	public void delete(Integer id){
		employees.remove(id);
	}
}
