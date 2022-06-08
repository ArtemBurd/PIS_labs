package ua.kpi.restaurant1.dao.interfaces;

import ua.kpi.restaurant1.entities.Order;

import java.util.List;

public interface IOrderDao {
    List<Order> findAll();

    Order findById(long orderId);

    void save(Order order);

    void update(long orderId, String column, String newValue);

    void delete(long orderId);
}
