package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(user);
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
       // Session session = sessionFactory.getCurrentSession();
        //return session.createQuery("from User").list();
        return entityManager
                .createQuery("select user from User user")
                .getResultList();
    }

    @Override
    public void deleteUser(Long id) {
        User delUser = entityManager.find(User.class, id);
        entityManager.remove(delUser);
    }
    @Override
    public User getByID(long id) {
        User getusr = entityManager.find(User.class, id);
        return getusr;
    }
    @Override
    public void updateUser(User user, Long id){
        User updateUser = entityManager.find(User.class, id);
        entityManager.detach(updateUser);
        updateUser.setName(user.getName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        entityManager.merge(updateUser);
    }
}
