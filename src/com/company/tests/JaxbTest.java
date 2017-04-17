package com.company.tests;

import com.company.planningJaxb.jaxbManager.JaxbManager;
import com.company.planningJaxb.models.User;
import com.company.planningJaxb.models.Users;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by admin on 16.04.2017.
 */
public class JaxbTest {
    @BeforeClass
    public static void InitTest() {
        //
    }

    @Test
    public void testJaxbManagerFromXml() {
        Users usersXml = (Users) JaxbManager.fromXml(new Users(), Users.class);
        Users usersStandart = new Users();
        User userStandart = new User();
        usersStandart.getUsers().add(userStandart);

        assertTrue(usersXml instanceof Users);
        assertTrue(usersXml.getUsers().get(0) instanceof User);
        assertTrue(usersXml.getUsers().size()>0);
    }

    @Test
    public void testJaxbManagerToXml() {
        Users usersStandart = new Users();
        User userStandart = new User();
        usersStandart.getUsers().add(userStandart);

        //JaxbManager.toXml(usersStandart);
        assertTrue(false);
    }
}
