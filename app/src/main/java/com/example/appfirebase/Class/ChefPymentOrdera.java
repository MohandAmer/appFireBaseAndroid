package com.example.appfirebase.Class;

public class ChefPymentOrdera {
    private String ChefId;
    private String DishId
            ;
    private String DishName;

    private String dishQuntity;
    private String price;
    private String totalprice;
    private String UserId;



    public ChefPymentOrdera() {
    }

    public ChefPymentOrdera(String chefId, String dishId, String dishname, String dishQuntity, String price, String totalprice, String userId) {
        ChefId = chefId;
        DishId
                = dishId;
        this.DishName
                = dishname;
        this.dishQuntity = dishQuntity;
       this.price = price;
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
        return DishId
                ;
    }

    public void setDishId(String dishId) {
        DishId
                = dishId;
    }

    public String getDishname() {
        return DishName
                ;
    }

    public void setDishname(String dishname) {
        this.DishName
                = dishname;
    }

    public String getDishQuntity() {
        return dishQuntity;
    }

    public void setDishQuntity(String dishQuntity) {
        this.dishQuntity = dishQuntity;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
