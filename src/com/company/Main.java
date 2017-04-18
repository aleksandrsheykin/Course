package com.company;

//import com.company.planning.models.User;
import com.company.planningJaxb.jaxbManager.JaxbManager;
import com.company.planningJaxb.jaxbThread.JaxbDownLoadThread;
import com.company.planningJaxb.dataBaseManager.DataBaseManager;
import com.company.planningJaxb.jaxbThread.JaxbUpLoadThread;
import com.company.planningJaxb.models.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }
    public static Logger logger = Logger.getLogger(Main.class);
    public static ConcurrentLinkedQueue<User> positiveUsersQueue = new ConcurrentLinkedQueue<>();
    public static ConcurrentLinkedQueue<Product> positiveProductsQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        if (false) {
            Thread downLoadUsersThread = new JaxbDownLoadThread(DataBaseManager.getUsers());
            downLoadUsersThread.start();
            Thread downLoadProductsThread = new JaxbDownLoadThread(DataBaseManager.getProducts());
            downLoadProductsThread.start();
            Thread downLoadPlansThread = new JaxbDownLoadThread(DataBaseManager.getPlans());
            downLoadPlansThread.start();
        } else {
            DataBaseManager.saveUsers((Users) JaxbManager.fromXml(new Users(), Users.class));
            DataBaseManager.saveProducts((Products) JaxbManager.fromXml(new Products(), Products.class));
            DataBaseManager.savePlans((Plans) JaxbManager.fromXml(new Plans(), Plans.class));

            /*Thread upUsersThread = new JaxbUpLoadThread(DataBaseManager.getUsers());
            upUsersThread.start();
            Thread upProductThread = new JaxbUpLoadThread(DataBaseManager.getProducts());
            upProductThread.start();
            Thread upPlansThread = new JaxbUpLoadThread(DataBaseManager.getPlans());
            upPlansThread.start();*/
        }
    }
}
