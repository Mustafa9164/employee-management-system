 package com.jspider.project;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jspider.project.config.EmployeeConfig;
import com.jspider.project.dao.EmployeeDao;
import com.jspider.project.entity.Employee;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeDao employeeDao = ac.getBean("dao",EmployeeDao.class);
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1:save\n2:fetchById\n3:update\n4:delete\n5:AllEmployee");
			System.out.println("Eneter choice");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				System.err.println("Save Employee in DB");
				Employee e=new Employee();
				System.out.println("Enter Employee name");
				String name = sc.next();
				e.setName(name);
				System.out.println("Enete email");
				String email = sc.next();
				e.setEmail(email);
				System.out.println("Eneter experience");
				double exp = sc.nextDouble();
				e.setExp(exp);
				System.out.println("Enter password");
				String password = sc.next();
				e.setPassword(password);
				System.out.println("Enter mobile Number");
				long phone = sc.nextLong();
				e.setPhone(phone);
				System.out.println("Eneter Salary");
				double salary = sc.nextDouble();
				e.setSalary(salary);
				employeeDao.saveEmployee(e);
				break;
			case 2:
				System.err.println("Enter id to fetch all record");
				int id = sc.nextInt();
				Employee employee = employeeDao.getEmployee(id);
				System.err.println(employee);
				break;
			case 3:
				System.err.println("update Employee");
				Employee emp=new Employee();
				System.out.println("Enete employee id");
				int eid = sc.nextInt();
				emp.setId(eid);
				System.out.println("Enter Employee name");
				String ename = sc.next();
				emp.setName(ename);
				System.out.println("Enete email");
				String gmail = sc.next();
				emp.setEmail(gmail);
				System.out.println("Eneter experience");
				double experience = sc.nextDouble();
				emp.setExp(experience);
				System.out.println("Enter password");
				String pass = sc.next();
				emp.setPassword(pass);
				System.out.println("Enter mobile Number");
				long mobile = sc.nextLong();
				emp.setPhone(mobile);
				System.out.println("Eneter Salary");
				double sal = sc.nextDouble();
				emp.setSalary(sal);
				employeeDao.updateEmployee(eid, emp);
				break;
			case 4:
				System.out.println("remove Employee by Id");
				int empid = sc.nextInt();
				employeeDao.removeEmployee(empid);
				break;
			case 5:
				System.out.println("List of Employee");
				List<Employee> list = employeeDao.getAllEmployee();
				for (Employee empl : list) {
					System.err.println(empl);
				}
				System.exit(0);
				break;
				
			default:System.out.println("Invalid choice");
				break;
			}
		System.out.println("==================================");
		}
		//employeeDao.removeEmployee(2);
		
//		employeeDao.updateEmployee(1, e);
//		
		//Employee employee = employeeDao.getEmployee(1);
		
		 
//		Object bean = ac.getBean("emf");
//		System.out.println(bean);
	}
}
