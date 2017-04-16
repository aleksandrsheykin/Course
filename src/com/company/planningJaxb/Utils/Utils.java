package com.company.planningJaxb.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.company.Main.logger;

/**
 * Created by admin on 16.04.2017.
 */
public class Utils {

    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            logger.getLogger("DatatypeConfigurationException in Utils.java");
        }
        return xmlCalendar;
    }

    /*
     * Converts XMLGregorianCalendar to java.util.Date in Java
     */
    public static Date xMLGregorianCalendarToDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

}
