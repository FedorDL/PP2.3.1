package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User showUser(Long id) {
        return userDAO.showUser(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        User userToBeUpdated = showUser(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setAge(user.getAge());
        userDAO.update(userToBeUpdated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
