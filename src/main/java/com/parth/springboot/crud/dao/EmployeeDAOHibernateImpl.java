package com.parth.springboot.crud.dao;

import com.parth.springboot.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee theEmployee = currentSession.get(Employee.class,theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteId(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",theId);

        theQuery.executeUpdate();
    }
}
