package com.subokson.pp3Boot.dao;

import com.subokson.pp3Boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User updatedUser = getUserById(id);
        if (updatedUser == null) {
            throw new EntityNotFoundException("Не удалось удалить пользователя");
        }
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(Long id, User user) {
        User updatedUser = getUserById(id);
        try {
            updatedUser.setName(user.getName());
            updatedUser.setSurName(user.getSurName());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Не удалось изменить данные");
        }

    }

    @Override
    public User getUserById(Long id) {
        try {
            return entityManager.find(User.class, id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
    }
}
