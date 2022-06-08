package ua.kpi.restaurant1.dao;

import ua.kpi.restaurant1.Main;
import ua.kpi.restaurant1.dao.interfaces.IUserDao;
import ua.kpi.restaurant1.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {

    public List<User> findAll(){
        String querry = "select * from users;";
        List<User> userList = new ArrayList<User>();
        try {
            ResultSet resultSet = Main.statement.executeQuery(querry);
            while (resultSet.next()) {
                User user = new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone"),
                        resultSet.getString("password"));
                userList.add(user);
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public User findById(long id){
        String querry = "select * from users where id=" + id + ";";
        User user = null;
        try {
            ResultSet resultSet = Main.statement.executeQuery(querry);
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone"),
                        resultSet.getString("password"));
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public void save(User user){
        String querry = "insert into users(name, surname, phone, password) values ('"
                + user.getName() + "', '" + user.getSurname() + "', '" + user.getPhone()
                + "', '" + user.getPassword() + "');";
        try {
            Main.statement.executeUpdate(querry);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(long id, String column, String newValue){
        String querry = "update users set " + column + "='" + newValue + "'"
                + "where id =" + id + ";";
        try {
            Main.statement.executeUpdate(querry);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(long id){
        String querry = "delete from users where id=" + id;
        try {
            Main.statement.executeUpdate(querry);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
