package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class SharedMapper {

    public XMLGregorianCalendar dateToXMLGregorianCalendar(String dateString) throws LucidSamsExecutionException {

        XMLGregorianCalendar xmlGregorianCalendar = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new LucidSamsExecutionException("Unable to convert date: ", e);
        } catch (ParseException e) {
            throw new LucidSamsExecutionException("Unable to parse date: ", e);
        }
        return xmlGregorianCalendar;
    }

    public XMLGregorianCalendar dateToXMLGregorianCalendar() throws LucidSamsExecutionException {

        XMLGregorianCalendar xmlGregorianCalendar = null;
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(new Date());
            xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new LucidSamsExecutionException("Unable to convert date: ", e);
        }
        return xmlGregorianCalendar;
    }
}