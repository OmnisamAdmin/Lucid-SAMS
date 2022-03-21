package za.co.sfy.lucid.sams.resource.util;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author muzim
 */
public class DateConverter {

    public java.sql.Date getSQLDate(java.util.Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public java.util.Date getUtilDate(java.sql.Date sqlDate) {
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        return utilDate;
    }

    public java.sql.Date getSQLDate(XMLGregorianCalendar xmlGregorianCalendar) {
        java.util.Date utilDate = xmlGregorianCalendar.toGregorianCalendar().getTime();
        java.sql.Date sqlDate = getSQLDate(utilDate);
        return sqlDate;
    }
}
