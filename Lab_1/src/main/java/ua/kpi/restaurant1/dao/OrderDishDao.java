package ua.kpi.restaurant1.dao;

import ua.kpi.restaurant1.Main;
import ua.kpi.restaurant1.dao.interfaces.IOrderDishDao;
import ua.kpi.restaurant1.entities.OrderDish;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDishDao implements IOrderDishDao {
    public List<OrderDish> findAll(){
        String query = "select * from order_dish;";
        List<OrderDish> orderDishList = new ArrayList<OrderDish>();
        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()) {
                OrderDish orderDish = new OrderDish(resultSet.getLong("id"),
                        resultSet.getLong("orderId"),
                        resultSet.getLong("dishId"),
                        resultSet.getInt("numberOfDishes"));
                orderDishList.add(orderDish);
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orderDishList;
    }

    public OrderDish findById(long id){
        String query = "select * from order_dish where id=" + id + ";";
        OrderDish orderDish = null;
        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()) {
                orderDish = new OrderDish(resultSet.getLong("id"),
                        resultSet.getLong("orderId"),
                        resultSet.getLong("dishId"),
                        resultSet.getInt("numberOfDishes"));

            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orderDish;
    }

    public void save(OrderDish orderDish){
        String query = "insert into order_dish(orderId, dishId, numberOfDishes) values ('"
                + orderDish.getOrderId() + "', '" + orderDish.getDishId() + "', '"
                + orderDish.getNumberOfDishes() + "');";
        try {
            Main.statement.executeUpdate(query);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(long id, String column, String newValue){
        String query = "update order_dish set " + column + "='" + newValue + "'"
                + "where id =" + id + ";";
        try {
            Main.statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(long id){
        String query = "delete from order_dish where id=" + id;
        try {
            Main.statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
