package ua.kpi.restaurant1.dao.interfaces;

import ua.kpi.restaurant1.entities.Dish;

import java.util.List;

public interface IDishDao {
    List<Dish> findAll();

    Dish findById(long id);

    void save(Dish user);

    void update(long id, String column, String newValue);

    void delete(long id);
}
