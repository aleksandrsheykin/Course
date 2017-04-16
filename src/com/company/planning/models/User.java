package com.company.planning.models;

import com.company.Main;
import com.company.planning.dataBaseManager.DataBaseManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


/**
 * Created by admin on 13.04.2017.
 */
public class User implements DataBaseManager {
    private Integer id_user;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private int limit;
    private static long serialVersionUID = 1L;

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    private static Logger logger = Logger.getLogger(Main.class);

    public User(String fistName, String lastName, String mail, String password, int limit) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.password = md.digest(password.getBytes("UTF-8")).toString();
        } catch (NoSuchAlgorithmException e) {
            logger.warn("NoSuchAlgorithmException User.java User()"+e.toString());
        } catch (UnsupportedEncodingException e) {
            logger.warn("UnsupportedEncodingException User.java User()"+e.toString());
        }
        this.firstName = fistName;
        this.lastName = lastName;
        this.mail = mail;
        this.limit = limit;
        this.id_user = save();
    }

    public User() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof User))
            return false;

        if (!this.id_user.equals(((User) obj).id_user))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id_user.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", limit=" + limit +
                '}';
    }

    public User getUser(String mail) {
        return new User("Ray", "Charles", "Ray@mail.ru", "asdfasdf", 10000);
    }

    public User getUser(int id) {
        return new User("Ray", "Charles", "Ray@mail.ru", "asdfasdf", 10000);
    }

    public int getId_user() {
        return id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public int save() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users(\n" +
                            " user_firstname, user_lastname, user_mail, user_password, user_limit)\n" +
                            " VALUES (?, ?, ?, ?, ?) RETURNING user_id");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, limit);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            logger.warn("SQLException on save User. User.java save()");
            return -1;
        }
    }

    @Override
    public boolean update() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET(" +
                            " user_firstname, user_lastname, user_mail, user_password, user_limit)" +
                            " = (?, ?, ?, ?, ?)"+
                            " WHERE user_id = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, limit);
            preparedStatement.setInt(6, id_user);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException on update User. User.java update()");
            return false;
        }
    }

    @Override
    public void load(int id) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select"+
                            " user_id, user_firstname, user_lastname,"+
                            " user_limit, user_mail, user_password from users"+
                            " where user_id = ?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            result.next();
            this.firstName = result.getString("user_firstname");
            this.id_user = result.getInt("user_id");
            this.lastName = result.getString("user_lastname");
            this.limit = result.getInt("user_limit");
            this.mail = result.getString("user_mail");
            this.password = result.getString("user_password");

        } catch (SQLException e) {
            logger.warn("SQLException on get User. User.java get()");
        }
    }

}
