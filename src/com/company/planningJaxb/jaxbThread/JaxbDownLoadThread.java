package com.company.planningJaxb.jaxbThread;

import com.company.planningJaxb.jaxbManager.JaxbManager;

/**
 * Created by admin on 16.04.2017.
 */
public class JaxbDownLoadThread extends Thread {
    Thread s;
    private Object obj;

    public JaxbDownLoadThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        JaxbManager.toXml(obj);
    }
}
