package com.example.appfirebase.Class;

public class ChefPendingOrders {
    private String ChefId;
    private String DishId;
    private String dishname;
    private String dishQuntity;
    private String Price;
    private String totalprice;
    private String UserId;



    public ChefPendingOrders() {
    }

    public ChefPendingOrders(String chefId, String dishId, String dishname, String dishQuntity, String price, String totalprice, String userId) {
        ChefId = chefId;
        DishId = dishId;
        this.dishname = dishname;
        this.dishQuntity = dishQuntity;
        Price = price;
        this.totalprice = totalprice;
        UserId = userId;
    }

    public String getChefId() {
        return ChefId;
    }

    public void setChefId(String chefId) {
        ChefId = chefId;
    }

    public String getDishId() {
        return DishId;
    }

    public void setDishId(String dishId) {
        DishId = dishId;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDishQuntity() {
        return dishQuntity;
    }

    public void setDishQuntity(String dishQuntity) {
        this.dishQuntity = dishQuntity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
