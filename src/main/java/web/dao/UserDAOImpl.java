package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        EntityManager entityManager = factory.createEntityManager();
        List<User> userList = entityManager.createQuery("from User", User.class).getResultList();
        return userList;
    }
}
