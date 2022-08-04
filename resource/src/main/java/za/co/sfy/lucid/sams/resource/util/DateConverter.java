package za.co.sfy.lucid.sams.resource.util;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author muzim
 */
public class DateConverter {

    private static final String DATEFORMAT = "dd/MM/yyyy";

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

    public java.util.Date getUtilDate(XMLGregorianCalendar xmlGregorianCalendar) {
        java.util.Date utilDate = xmlGregorianCalendar.toGregorianCalendar().getTime();
        return utilDate;
    }

    public java.util.Date getFirstDayAfterDate(java.time.DayOfWeek targetDay, java.util.Date submittedDate) {
        LocalDate date = submittedDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        TemporalAdjuster nextTargetDay = TemporalAdjusters.next(targetDay);

        LocalDate firstDayAfterDate = date.with(nextTargetDay);

        java.time.Instant instant = firstDayAfterDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        java.util.Date convertedFirstDayAfterDate = java.util.Date.from(instant);

        return convertedFirstDayAfterDate;
    }

    public Boolean isTargetDay(Integer targetDay, java.util.Date submittedDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(submittedDate);
        Integer dayOfWeekValue = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeekValue.equals(targetDay)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getStringDate(java.util.Date date) {
        DateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
        String stringDate = dateFormat.format(date);
        return stringDate;
    }

    public Long getDifferenceInDays(Date dateOne, Date dateTwo) {
        Long dateOneMillis = dateOne.getTime();
        Long dateTwoMillis = dateTwo.getTime();

        Long timeDifference = Math.abs(dateOneMillis - dateTwoMillis);

        Long daysDifference = TimeUnit.DAYS.convert(timeDifference, TimeUnit.MILLISECONDS);

        return daysDifference;
    }

}
