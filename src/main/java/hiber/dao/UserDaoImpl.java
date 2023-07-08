package hiber.dao;

import org.springframework.stereotype.Repository;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        //sessionFactory.getCurrentSession().persist(user);
        entityManager.persist(user);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user", User.class);
        return query.getResultList();
    }
//    @Override
//    public List<User> getUsersByCar(String carModel, int carSeries) {
//        String hql = "from User where car.model = :model and car.series = :series";
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
//        query.setParameter("model", carModel);
//        query.setParameter("series", carSeries);
//        return query.getResultList();
//    }
}
