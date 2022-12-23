package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = entityManager.createQuery("from User").getResultList();
        return userList;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public User showUser (int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void update(int id, User user) {
        User userToBeUpdated = showUser(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setAge(user.getAge());
        entityManager.merge(userToBeUpdated);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(showUser(id));
    }
}
