package com.company.planningJaxb.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Date;
import java.util.GregorianCalendar;

import static com.company.Main.logger;

/**
 * Created by admin on 16.04.2017.
 */
public class Utils {

    /**
     * Конвертирует Data() в XMLGregorianCalendar()
     * @param date
     * @return
     */
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date){
        if (date == null) return null;
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

    /**
     * Конвертирует XMLGregorianCalendar() в Data()
     * @param calendar
     * @return
     */
     public static Date xMLGregorianCalendarToDate(XMLGregorianCalendar calendar){
         long time = calendar.toGregorianCalendar().getTime().getTime();
         return new Date(time);
    }

}
