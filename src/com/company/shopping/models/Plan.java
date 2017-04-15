package com.company.shopping.models;

import java.util.Date;

/**
 * Created by admin on 13.04.2017.
 */
public class Plan {
    private Integer id_plan;
    private Date datePlan;
    private int quantity;
    private int cost;
    private User user;
    private Product product;
    private static long serialVersionUID = 1L;

    public Plan(Date datePlan, int quantity, int cost, User user, Product product) {
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

        if (!(obj instanceof Plan))
            return false;

        if (!this.id_plan.equals(((Plan) obj).id_plan))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id_plan.hashCode();
    }

    @Override
    public String toString() {
        return "Plan{" +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
