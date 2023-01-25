package repository;

import config.DBConn;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;

public class EmployeeRepository {

    private SessionFactory sessionFactory;

    public EmployeeRepository() {
        this.sessionFactory = DBConn.getSessionFactory();
    }

    public List<Employee> getAllEmployees(){
        Session session=sessionFactory.openSession();
        List<Employee> result = session.createQuery("FROM Employee",Employee.class).list();
        session.close();
        return result;

    }
    public Employee getById(Long id){
        Session session=sessionFactory.openSession();
        Employee result = session.get(Employee.class,id);
        session.close();
        return result;
    }
    public Employee addEmployee(Employee employee){
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }
    public Employee updateEmployee(Employee employee){
        return addEmployee(employee);
    }
    public void deleteEmployee(Employee employee){
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();

    }
    public void deleteEmployeeId(Long id){
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete Employee where id="+id).executeUpdate();
        transaction.commit();
        session.close();
    }
}
