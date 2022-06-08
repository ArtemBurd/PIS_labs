package ua.kpi.restaurant1.dao.interfaces;


import ua.kpi.restaurant1.entities.OrderDish;

import java.util.List;

public interface IOrderDishDao {
    List<OrderDish> findAll();

    OrderDish findById(long id);

    void save(OrderDish order);

    void update(long id, String column, String newValue);

    void delete(long id);
}
