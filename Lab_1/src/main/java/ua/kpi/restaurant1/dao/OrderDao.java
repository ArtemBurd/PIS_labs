package ua.kpi.restaurant1.dao;

import ua.kpi.restaurant1.Main;
import ua.kpi.restaurant1.dao.interfaces.IOrderDao;
import ua.kpi.restaurant1.entities.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    public List<Order> findAll(){
        String query = "select * from orders;";
        List<Order> orderList = new ArrayList<Order>();
        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()) {
                Order order = new Order(resultSet.getLong("orderId"),
                        resultSet.getLong("userId"),
                        resultSet.getString("orderStatus"));
                orderList.add(order);
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orderList;
    }

    public Order findById(long orderId){
        String query = "select * from orders where orderId=" + orderId + ";";
        Order order = null;
        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()) {
                order = new Order(resultSet.getLong("orderId"),
                        resultSet.getLong("userId"),
                        resultSet.getString("orderStatus"));

            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }

    public void save(Order order){
        String query = "insert into orders(userId, orderStatus) values ('"
                + order.getUserId() + "', '" + order.getOrderStatus() + "');";
        try {
            Main.statement.executeUpdate(query);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(long orderId, String column, String newValue){
        String query = "update orders set " + column + "='" + newValue + "'"
                + "where orderId =" + orderId + ";";
        try {
            Main.statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(long orderId){
        String query = "delete from orders where orderId=" + orderId;
        try {
            Main.statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
