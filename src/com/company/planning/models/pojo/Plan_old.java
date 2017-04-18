/*package com.company.planning.models.pojo;

import java.util.Date;


public class Plan_old {
    private Integer id_plan;
    private Date datePlan;
    private int quantity;
    private int cost;
    private User_old user;
    private Product_old product;
    private static long serialVersionUID = 1L;

    public Plan_old(Date datePlan, int quantity, int cost, User_old user, Product_old product) {
        this.datePlan = datePlan;
        this.quantity = quantity;
        this.cost = cost;
        this.user = user;
        this.product = product;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Plan_old))
            return false;

        if (!this.id_plan.equals(((Plan_old) obj).id_plan))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id_plan.hashCode();
    }

    @Override
    public String toString() {
        return "Plan_old{" +
                "id_plan=" + id_plan +
                ", datePlan=" + datePlan +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", user=" + user +
                ", product=" + product +
                '}';
    }

    public Date getDatePlan() {
        return datePlan;
    }

    public void setDatePlan(Date datePlan) {
        this.datePlan = datePlan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public User_old getUser() {
        return user;
    }

    public void setUser(User_old user) {
        this.user = user;
    }

    public Product_old getProduct() {
        return product;
    }

    public void setProduct(Product_old product) {
        this.product = product;
    }
}
*/