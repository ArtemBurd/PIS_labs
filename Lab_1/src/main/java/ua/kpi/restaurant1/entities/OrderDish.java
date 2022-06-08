package ua.kpi.restaurant1.entities;

public class OrderDish {
    private long id;
    private long orderId;
    private long dishId;
    private int numberOfDishes;

    public OrderDish(long id, long orderId, long dishId, int numberOfDishes) {
        this.id = id;
        this.orderId = orderId;
        this.dishId = dishId;
        this.numberOfDishes = numberOfDishes;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    public void setNumberOfDishes(int numberOfDishes) {
        this.numberOfDishes = numberOfDishes;
    }

    public long getId() {
        return id;
    }
}
