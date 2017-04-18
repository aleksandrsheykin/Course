package com.company.tests;

import com.company.planningJaxb.dataBaseManager.DataBaseManager;
import com.company.planningJaxb.models.User;
import com.company.planningJaxb.models.Users;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.company.planningJaxb.dataBaseManager.DataBaseManager.initConnection;
import static org.junit.Assert.assertTrue;

/**
 * Created by admin on 17.04.2017.
 */
public class DataBaseManagerTest {
    @Test
    public void getUsersTest() {
        assertTrue(DataBaseManager.getUsers().getUsers().size() > 0);
    }
    @Test
    public void getProductsTest() {
        assertTrue(DataBaseManager.getProducts().getProducts().size() > 0);
    }
    @Test
    public void getPlansTest() {
        assertTrue(DataBaseManager.getPlans().getPlans().size() > 0);
    }

    public void saveUsersTest() {
        Users usersStandart = new Users();
        User userStandart = new User();
        userStandart.setIsAdmin(true);
        userStandart.setMail("testuser@mail.ru");
        userStandart.setPassword("123");
        userStandart.setFirstName("Oleg");
        userStandart.setLastName("Gazmanov");
        userStandart.setLimit(2050);
        userStandart.setIdUser(7777);
        usersStandart.getUsers().add(userStandart);

        assertTrue(DataBaseManager.getUsers().getUsers().contains(userStandart));
        assertTrue(true);

        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from users where user_id = 7777");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
