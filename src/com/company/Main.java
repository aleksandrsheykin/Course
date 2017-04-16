package com.company;

//import com.company.planning.models.User;
import com.company.planningJaxb.JaxbManagar.JaxbManager;
import com.company.planningJaxb.dataBaseManager.DataBaseManager;
import com.company.planningJaxb.models.Plans;
import com.company.planningJaxb.models.Products;
import com.company.planningJaxb.models.User;
import com.company.planningJaxb.models.Users;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.Data;
import java.io.File;
import java.sql.*;
import java.util.List;

public class Main {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //JaxbManager.toXml(DataBaseManager.getUsers());
        //JaxbManager.toXml(DataBaseManager.getProducts());
        //JaxbManager.toXml(DataBaseManager.getPlans());

        //DataBaseManager.saveUsers((Users) JaxbManager.fromXml(new Users(), Users.class));
        //DataBaseManager.saveProducts((Products) JaxbManager.fromXml(new Products(), Products.class));
        DataBaseManager.savePlans((Plans) JaxbManager.fromXml(new Plans(), Plans.class));


    }
}
