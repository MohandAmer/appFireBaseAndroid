package com.example.appfirebase.Class;

public class CustomerPendingOrders {
    private String ChefId;
    private String DishID;
    private String dishname;
    private String DishQuantity;
    private String  Price;
    private String totalprice;


    public CustomerPendingOrders() {
    }

    public CustomerPendingOrders(String chefId, String dishID, String dishName, String dishQuantity, String price, String totalProce) {
        ChefId = chefId;
        DishID = dishID;
        dishname = dishName;
        DishQuantity = dishQuantity;
        Price = price;
        totalprice = totalProce;
    }

    public String getChefId() {
        return ChefId;
    }

    public void setChefId(String chefId) {
        ChefId = chefId;
    }

    public String getDishID() {
        return DishID;
    }

    public void setDishID(String dishID) {
        DishID = dishID;
    }

    public String getDishName() {
        return dishname;
    }

    public void setDishName(String dishName) {
        dishname = dishName;
    }

    public String getDishQuantity() {
        return DishQuantity;
    }

    public void setDishQuantity(String dishQuantity) {
        DishQuantity = dishQuantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTotalProce() {
        return totalprice;
    }

    public void setTotalProce(String totalProce) {
        totalprice = totalProce;
    }
}
