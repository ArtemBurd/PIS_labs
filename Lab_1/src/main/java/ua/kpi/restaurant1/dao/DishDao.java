package ua.kpi.restaurant1.dao;

import ua.kpi.restaurant1.Main;
import ua.kpi.restaurant1.dao.interfaces.IDishDao;
import ua.kpi.restaurant1.entities.Dish;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao implements IDishDao {
    public List<Dish> findAll(){
        String query = "select * from dishes;";
        List<Dish> dishList = new ArrayList<Dish>();
        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()) {
                Dish dish = new Dish(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"));

                dishList.add(dish);
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dishList;
    }

    public Dish findById(long id){
        String query = "select * from dishes where id=" + id + ";";
        Dish dish = null;
        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()) {
                dish = new Dish(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"));

            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dish;
    }

    public void save(Dish dish){
        String query = "insert into dishes(name, price) values ('"
                + dish.getName() + "', '" + dish.getPrice() + "');";
        try {
            Main.statement.executeUpdate(query);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(long id, String column, String newValue){
        String query = "update dishes set " + column + "='" + newValue + "'"
                + "where id =" + id + ";";
        try {
            Main.statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(long id){
        String query = "delete from dishes where id=" + id;
        try {
            Main.statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
