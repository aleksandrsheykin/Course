package com.company.planningJaxb.dataBaseManager;

import com.company.Main;
import com.company.planningJaxb.models.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static com.company.Main.logger;

/**
 * Created by admin on 16.04.2017.
 */
public class DataBaseManager {
    public static User getUser(int id) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select"+
                    " user_id, user_firstname, user_lastname,"+
                    " user_limit, user_mail, user_password from users"+
                    " where user_id = ?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            result.next();
            User u = new User();
            u.setIdUser(result.getInt("user_id"));
            u.setLimit(result.getInt("user_limit"));
            u.setFirstName(result.getString("user_firstname"));
            u.setLastName(result.getString("user_lastname"));
            u.setMail(result.getString("user_mail"));
            u.setPassword(result.getString("user_password"));
            return u;

        } catch (SQLException e) {
            logger.warn("SQLException on get DataBaseManager. DataBaseManager.java getuser()");
            return new User();
        }
    }

    public static Users getUsers() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select"+
                    " user_id, user_firstname, user_lastname,"+
                    " user_limit, user_mail, user_password, user_is_admin from users");

            ResultSet result = preparedStatement.executeQuery();

            Users users = new Users();
            while (result.next()) {
                User u = new User();
                u.setIdUser(result.getInt("user_id"));
                u.setLimit(result.getInt("user_limit"));
                u.setFirstName(result.getString("user_firstname"));
                u.setLastName(result.getString("user_lastname"));
                u.setMail(result.getString("user_mail"));
                u.setPassword(result.getString("user_password"));
                u.setIsAdmin(result.getBoolean("user_is_admin"));
                users.getUsers().add(u);
            }
            return users;

        } catch (SQLException e) {
            logger.warn("SQLException on get DataBaseManager. DataBaseManager.java getuser()");
            return new Users();
        }
    }

    public static Products getProducts() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products");

            ResultSet result = preparedStatement.executeQuery();

            Products products = new Products();
            while (result.next()) {
                Product p = new Product();
                p.setIdProduct(result.getInt("product_id"));
                p.setDescription(result.getString("product_description"));
                p.setName(result.getString("product_name"));
                p.setIdUser(result.getInt("product_user_id"));
                products.getProducts().add(p);
            }
            return products;

        } catch (SQLException e) {
            logger.warn("SQLException on get DataBaseManager. DataBaseManager.java getProducts()");
            return new Products();
        }
    }

    public static Plans getPlans() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from plans");

            ResultSet result = preparedStatement.executeQuery();

            Plans plans = new Plans();
            while (result.next()) {
                Plan p = new Plan();
                p.setIdPlan(result.getInt("plan_id"));
                p.setIdUser(result.getInt("plan_user_id"));
                p.setIdProduct(result.getInt("plan_product_id"));
                p.setCost(result.getInt("plan_cost"));
                GregorianCalendar c = new GregorianCalendar();
                c.set(result.getDate("plan_data").getYear(),
                        result.getDate("plan_data").getMonth(),
                        result.getDate("plan_data").getDate());
                p.setDatePlan(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
                p.setQuantity(result.getInt("plan_quantity"));
                plans.getPlans().add(p);
            }
            return plans;

        } catch (SQLException e) {
            logger.warn("SQLException on get DataBaseManager. DataBaseManager.java getPlans()");
            return new Plans();
        } catch (DatatypeConfigurationException e) {
            logger.warn("DatatypeConfigurationException on get DataBaseManager. DataBaseManager.java getPlans()");
            return new Plans();
        }
    }

    public static void saveUser(User user) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users(" +
                            " user_firstname, user_lastname, user_mail, user_password, user_limit, user_id)" +
                            " VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getLimit());
            preparedStatement.setInt(6, user.getIdUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("SQLException on save User. DataBaseManager.java saveUser()");
        }
    }

    public static void saveUsers(Users users) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users(" +
                            " user_firstname, user_lastname, user_mail, user_password, user_limit, user_id, user_is_admin)" +
                            " VALUES (?, ?, ?, ?, ?, ?, ?)");
            int i = 0;
            for (User user: users.getUsers()) {
                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getMail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setInt(5, user.getLimit());
                preparedStatement.setInt(6, user.getIdUser());
                preparedStatement.setBoolean(7, user.isIsAdmin());
                preparedStatement.addBatch();
                if (i++ % 500 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            logger.warn("SQLException on save User. DataBaseManager.java saveUser()");
        }
    }

    public static void saveProducts(Products products) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO products(" +
                            " product_id, product_name, product_description, product_user_id)" +
                            " VALUES (?, ?, ?, ?)");
            int i = 0;
            for (Product product: products.getProducts()) {
                preparedStatement.setInt(1, product.getIdProduct());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setString(3, product.getDescription());
                preparedStatement.setInt(4, product.getIdUser());
                preparedStatement.addBatch();
                if (i++ % 500 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            logger.warn("SQLException on save User. DataBaseManager.java saveProducts()");
        }
    }

    public static Connection initConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/shopping_planning", "postgres", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
