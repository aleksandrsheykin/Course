package com.company.planning.models.dao;

import com.company.Main;
import com.company.planning.models.pojo.Product;
import com.company.planning.models.pojo.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.company.planning.models.connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public class ProductDaoImpl implements ProductDao {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }
    private static Logger logger = Logger.getLogger(Main.class);

    @Override
    public List<Product> getAll() {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from products");

            ResultSet result = preparedStatement.executeQuery();

            List<Product> listProduct = null;
            while (result.next()) {
                listProduct.add(new Product(
                        result.getInt("product_id_"),
                        result.getString("product_name"),
                        result.getString("product_description"),
                        result.getInt("product_user_id"))

                );
            }
            return listProduct;

        } catch (SQLException e) {
            logger.warn("SQLException in Product.getAll()");
            return null;
        }
    }

    @Override
    public Product get(int id) {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from products where product_id=?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Product(
                    result.getInt("product_id_"),
                    result.getString("product_name"),
                    result.getString("product_description"),
                    result.getInt("product_user_id")
            );

        } catch (SQLException e) {
            logger.warn("SQLException in Product.get()");
            return null;
        }
    }

    @Override
    public boolean update(Product product) {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET(" +
                    " product_name, product_description, product_user_id)" +
                    " = (?, ?, ?) WHERE product_id = ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getUser_id());
            preparedStatement.setInt(4, product.getId_product());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in Product.update()");
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from products " +
                    " WHERE product_id = ?");
            preparedStatement.setInt(1, product.getId_product());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in Product.delete()");
            return false;
        }
    }
}
