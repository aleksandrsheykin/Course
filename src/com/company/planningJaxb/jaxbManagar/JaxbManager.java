package com.company.planningJaxb.jaxbManagar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.company.Main.logger;

/**
 * Created by admin on 16.04.2017.
 */
public class JaxbManager {

    /**
     * <p>Сохраняет Object в *.xml имя файлу присваивает соответствующее имени класса </p>
     * @param obj
     */
    public static void toXml(Object obj) {
        try {

            File file = new File(obj.getClass().getSimpleName()+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, file);
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.warn("JaxbException in JaxbManager.java toXml()");
        }
    }

    /**
     * <p>Вытягивает из *.xml объекты, имя файла берет из имени объектов лежащих в файла </p>
     * @param obj - объекты которые ищем в файле
     * @param cls - класс объекта
     * @return объект нужного класса (Users, Products, Plans)
     */
    public static Object fromXml(Object obj, Class cls) {
        try {

            File file = new File(obj.getClass().getSimpleName()+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(cls);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object r = (Object) jaxbUnmarshaller.unmarshal(file);
            return r;
        } catch (JAXBException e) {
            logger.warn("JaxbException in JaxbManager.java fromXml()");
            return new Object();
        }
    }
}
