package ua.kpi.restaurant1;

import ua.kpi.restaurant1.dao.DishDao;
import ua.kpi.restaurant1.dao.OrderDao;
import ua.kpi.restaurant1.dao.OrderDishDao;
import ua.kpi.restaurant1.dao.UserDao;
import ua.kpi.restaurant1.entities.Dish;
import ua.kpi.restaurant1.entities.Order;
import ua.kpi.restaurant1.entities.OrderDish;
import ua.kpi.restaurant1.entities.User;

import java.sql.*;
import java.util.List;

public class Main {
    public static Connection connection = null;
    public static Statement statement = null;

    public static void main(String[] args){
        try{
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            System.out.println("Connect successfully\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAll();
        for (User user: userList){
            System.out.println(Long.toString(user.getId()) + ' ' + user.getName() + ' ' + user.getSurname()
            + ' ' + user.getPhone() + ' ' + user.getPassword());
        }

        System.out.println("\n");

        User user = userDao.findById(2);
        System.out.println(Long.toString(user.getId()) + ' ' + user.getName() + ' ' + user.getSurname()
                + ' ' + user.getPhone() + ' ' + user.getPassword());

        System.out.println("\n");

        userDao.save(new User(0, "Illia", "Kostiuk", "+380506325691", "0000"));
        userList = userDao.findAll();
        for (User user1: userList){
            System.out.println(Long.toString(user1.getId()) + ' ' + user1.getName() + ' ' + user1.getSurname()
                    + ' ' + user1.getPhone() + ' ' + user1.getPassword());
        }

        System.out.println("\n");

        userDao.update(4, "password", "9999");
        user = userDao.findById(4);
        System.out.println(Long.toString(user.getId()) + ' ' + user.getName() + ' ' + user.getSurname()
                + ' ' + user.getPhone() + ' ' + user.getPassword());

        System.out.println("\n");

        userDao.delete(4);
        userList = userDao.findAll();
        for (User user2: userList){
            System.out.println(Long.toString(user2.getId()) + ' ' + user2.getName() + ' ' + user2.getSurname()
                    + ' ' + user2.getPhone() + ' ' + user2.getPassword());
        }

        try{
            statement.close();
            connection.close();
            System.out.println("\nClosed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
