package ua.kpi.restaurant1.entities;

public class Order {
    private long orderId;
    private long userId;
    private String orderStatus;

    public Order(long orderId, long userId, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getOrderId() {
        return orderId;
    }
}
