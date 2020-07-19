import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {

    public Employee findById(int id){
        /**Session session = HibernateUtil.getSessionFactory().openSession()*/
        //This line replace the others 2 from below.
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee = session.find(Employee.class, id);
        session.close();
        return employee;
    }

    public  void save(Employee employee){
        Transaction transaction = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void delete(Employee employee){
        Transaction transaction = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Employee employee){
        Transaction transaction = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Employee> findAllEmployees(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "from Employee";
        Query query = session.createQuery(queryString);
        List<Employee> employees = query.list();
        session.close();

        return employees;
    }

    public List<Employee> findAllEmployeesWithLetterJ(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "from Employee where firstName like 'J%'";
        Query query = session.createQuery(queryString);
        List<Employee> employeesNameJ = query.list();
        session.close();

        return employeesNameJ;
    }

    public List<Employee> findAllEmployeesWorkingFinance(String department){
        List<Employee> employees = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String queryString = "from Employee e where e.department.name = : departmentName";
            Query query = session.createQuery(queryString);
            query.setParameter("departmentName",department);
            employees = query.list();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return employees;
    }


    public List<Employee> findEmployeeOrderedByFirstName(){
        List<Employee> employees = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String queryString = "from Employee e order by e.firstName desc";
            Query query = session.createQuery(queryString);

            employees = query.list();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return employees;
    }
}
