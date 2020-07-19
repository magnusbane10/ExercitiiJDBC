import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class ProjectRepository {

    public static Project findById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Project project = session.find(Project.class, id);
        session.close();
        return project;
    }

    public  void save(Project project){
        Transaction transaction = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
        }catch(Exception e){
                if(transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
        }
    }
    public void delete(Project project){
        Transaction transaction = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            session.delete(project);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Project project){
        Transaction transaction = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Project> findAllProjects(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "from Project";
        Query query = session.createQuery(queryString);
        List<Project> projects = query.list();
        session.close();

        return projects;
    }

}

