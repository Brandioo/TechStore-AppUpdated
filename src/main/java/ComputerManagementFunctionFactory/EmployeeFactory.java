package ComputerManagementFunctionFactory;

import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Employee> employees;

    public EmployeeFactory(Session session) {
        this.session = session;
    }

    public EmployeeFactory() {
    }

    public ArrayList<Employee> getUsers() {
        return employees;
    }


    public void createEmployee(final Employee employee) {
        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
    }

    public Employee findAllEmployeesByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee by id: ");
        return session.find(Employee.class, Id);
    }

    public String findAllEmployees() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        session.createQuery("from Employee ").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Employee> findAllEmployeeList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        Query query = session.createQuery("from Employee ");

        List<Employee> employees = query.getResultList();
        session.close();
        return employees;

    }

    public Employee findEmployeeByName(String firstName) {

        Query query  = session.createQuery("select e from Employee e where e.firstName=:firstName");
        query.setParameter("firstName", firstName);
        List<Employee> employees = query.getResultList();

        Employee employee = null;

        if (!employees.isEmpty()) {
            return employees.get(0);
        }
        session.close();
        return employee;
    }

    public Employee logIn(String user, String password) {

        Query query  = session.createQuery("select e from Employee e where e.user=:user and e.password=:password");
        query.setParameter("user", user);
        query.setParameter("password", password);
        List<Employee> employees = query.getResultList();

        Employee employee = null;

        if (!employees.isEmpty()) {
            return employees.get(0);
        }
        session.close();
        return employee;
    }

    public boolean signUp(String firstName, String lastName, LocalDate dateOfBirth, String email,
                          String phoneNumber, String role, String user, String password, String verifiedPassword,
                          Integer salary, LocalDateTime createdOn) {
        if (password.equals(verifiedPassword) && password.length()>=8) {
            // the data are okay
            // create the user
            // password length bigger than 8
            Employee employee = new Employee( firstName, lastName, dateOfBirth, email, phoneNumber, role
                    , user, password, salary, createdOn);
            //this.employees.add(employee);
            createEmployee(employee);
            return true;
        }
        return false;
    }

    public void editEmployee(Employee updatedUser) {
        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedUser);

        transaction.commit();
    }

    public int countSalaries() {

        Query query = session.createQuery("select sum(c.salary) from Employee c");
        Integer cartels = Math.toIntExact((Long) query.getSingleResult());

        return cartels;

    }

    public int getLastID() {

        Query query = session.createQuery("select max(employeesId) from Employee");
        Integer employees = Math.toIntExact((Integer) query.getSingleResult());

        return employees;

    }

    public int getFirstID() {

        Query query = session.createQuery("select min(employeesId) from Employee ");
        Integer employeeID = Math.toIntExact((Integer) query.getSingleResult());

        return employeeID;

    }
}
