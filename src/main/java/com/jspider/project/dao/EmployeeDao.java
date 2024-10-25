package com.jspider.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspider.project.entity.Employee;

@Component(value = "dao")
public class EmployeeDao {
	
	@Autowired
	//private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public void saveEmployee(Employee employee) {
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("Employee saved");
	}
	
	
	public Employee getEmployee(int id) {
		String query="select e from Employee e where e.id=?1";
		Query q=entityManager.createQuery(query);
		q.setParameter(1, id);
		return (Employee) q.getSingleResult();
	}

	public void updateEmployee(int id,Employee newEmployee) {
		try {
			Employee e = getEmployee(id);
			EntityTransaction et=entityManager.getTransaction();
			et.begin();
			newEmployee.setId(id);
			entityManager.merge(newEmployee);
			et.commit();
		} catch (NoResultException e) {
			System.out.println("Id not found");
		}
	}
	public void removeEmployee(int id) {
		Employee employee = getEmployee(id);
		EntityTransaction trx = entityManager.getTransaction();
		trx.begin();
		entityManager.remove(employee);
		trx.commit();
	}

	public List<Employee> getAllEmployee(){
		String query="select e from Employee e";
		Query q = entityManager.createQuery(query);
		List<Employee> list = q.getResultList();
		return list;
	}
	

}
