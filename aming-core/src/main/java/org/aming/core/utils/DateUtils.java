package org.aming.core.utils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;
import static java.time.temporal.ChronoUnit.WEEKS;

/**
 * @author daming
 * @version 2017/12/22.
 */
public class DateUtils {

    private static final DateTimeFormatter DATE_FORMAT_FULL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_FORMAT_DATE_NO_DELIMITER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter DATE_FORMAT_FULL_NO_DELIMITER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String format(Date date) {
        return format(date, ZoneId.systemDefault());
    }

    public static String format(Date date, ZoneId zoneId) {
        return format(date, zoneId, DATE_FORMAT_FULL);
    }

    private static String format(Date date, ZoneId zoneId, DateTimeFormatter formatter) {
        return format(date.toInstant(),zoneId, formatter);
    }

    private static String format(TemporalAccessor temporalAccessor, ZoneId zoneId, DateTimeFormatter formatter) {
        if(Objects.isNull(temporalAccessor)) {
            return null;
        }

        if (Objects.isNull(zoneId)) {
            zoneId = ZoneId.systemDefault();
        }

        return formatter.withZone(zoneId).format(temporalAccessor);
    }

    public static Date getDate(long days) {
        return Date.from(Instant.now().plus(days, DAYS));
    }

    public static Date getDate(Date startDate, long days) {
        return Date.from(startDate.toInstant().plus(days, DAYS));
    }

    public static Date getDateOffHours(long hours) {
        return Date.from(Instant.now().plus(hours, HOURS));
    }

    public static Date stringToDate(String date) {
        return Date.from(DATE_FORMAT_FULL.withZone(ZoneId.systemDefault()).parse(date, Instant::from));
    }

    public static Date stringToSimpleDate(String date) {
        return Date.from(DATE_FORMAT_FULL.withZone(ZoneId.systemDefault()).parse(date + " 00:00:00", Instant::from));
    }

    public static String dateToSimpleString(Date date) {
        return format(date, ZoneId.systemDefault(), DATE_FORMAT_DATE);
    }

    public static String dateToString(Date date) {
        return format(date, ZoneId.systemDefault(), DATE_FORMAT_FULL);
    }

    public static String currentDate() {
        return format(LocalDate.now(), ZoneId.systemDefault(), DATE_FORMAT_DATE);
    }

    public static String currentDateWithNoDelimiter() {
        return format(LocalDate.now(), ZoneId.systemDefault(), DATE_FORMAT_DATE_NO_DELIMITER);
    }

    public static String currentDateTime() {
        return format(LocalDateTime.now(), ZoneId.systemDefault(), DATE_FORMAT_FULL);
    }

    public static String currentDateTimeWithNoDelimiter() {
        return format(LocalDateTime.now(), ZoneId.systemDefault(), DATE_FORMAT_DATE_NO_DELIMITER);
    }

    public static Date getPreviousDay(long delay) {
        return Date.from(Instant.now().minus(delay, DAYS));
    }

    public static List<Date> getPreviousDays(long delay) {
        List<Date> days = new ArrayList<Date>();
        for (long i = delay; i >= 0; i--) {
            days.add(getPreviousDay(i));
        }
        return days;
    }

    public static int getYear(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).getYear();
    }

    public static int getYear() {
        return Year.now().getValue();
    }

    public static int getMonth(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).getMonth().getValue();
    }

    public static int getMonth() {
        return LocalDate.now().getMonthValue();
    }

    public static Date getEndOfNextNaturalYear() {
        return Date.from(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(getYear() + 1, 12, 31), LocalTime.MAX), ZoneId.systemDefault()).toInstant());
    }
    
    public static int getNaturalWeek(Date date) {
    	return LocalDateTime.ofInstant(date.toInstant(), ZoneId.ofOffset("GMT", ZoneOffset.ofHours(8))).get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }
    
    public static boolean isSameDay(Date date) {
    	if (Objects.isNull(date)) {
    		return false;
    	}
    	return LocalDate.now().isEqual(ChronoLocalDate.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
    }
    
    public static boolean isSameNaturalWeek(Date date) {
		return getNaturalWeek(date) == getNaturalWeek(new Date());
	}

	public static boolean isSameNaturalMonth(Date date) {
		LocalDate now = LocalDate.now();
		LocalDate  tempDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
		return now.getYear() == tempDate.getYear() && now.getMonthValue() == tempDate.getMonthValue();
	}
}
