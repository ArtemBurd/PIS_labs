package ua.kpi.restaurant1.dao.interfaces;

import ua.kpi.restaurant1.entities.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void update(long id, String column, String newValue);

    void delete(long id);
}
