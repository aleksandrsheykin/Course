package com.company.planningJaxb.jaxbThread;

import com.company.planningJaxb.dataBaseManager.DataBaseManager;
import com.company.planningJaxb.jaxbManagar.JaxbManager;
import com.company.planningJaxb.models.Plans;
import com.company.planningJaxb.models.Products;
import com.company.planningJaxb.models.Users;

import static com.company.Main.logger;

/**
 * Created by admin on 16.04.2017.
 */
public class JaxbUpLoadThread  extends Thread {
    Thread s;
    private Object obj;

    public JaxbUpLoadThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        switch (obj.getClass().getSimpleName()) {
            case "Users":
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DataBaseManager.saveUsers((Users) JaxbManager.fromXml(new Users(), Users.class));
                break;
            case "Products":
                DataBaseManager.saveProducts((Products) JaxbManager.fromXml(new Products(), Products.class));
                break;
            case "Plans":
                DataBaseManager.savePlans((Plans) JaxbManager.fromXml(new Plans(), Plans.class));
                break;
            default:
                logger.info("XML Class is not defined");
                break;
        }
    }
}
