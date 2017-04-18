/*package com.company.planning.models.pojo;

public class Product_old {
    private Integer id_product;
    private String name;
    private String description;
    private static long serialVersionUID = 1L;

    public Product_old(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof User_old))
            return false;

        if (!this.id_product.equals(((Product_old) obj).id_product))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id_product.hashCode();
    }

    @Override
    public String toString() {
        return "Product_old{" +
                "id_product=" + id_product +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Product_old getProduct(Integer id_product) {
        return new Product_old("asdf", "asdf");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId_product() {
        return id_product;
    }
}
*/