package com.spcbrasil.api.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

public class DateUtils {



	/*
		"2020-09-19 02:00",Constants.DB_FORMAT,"Asia/Kolkata"
	 */


		public static ZonedDateTime getCurrentDate(String timezone){
			ZoneId zid = ZoneId.of(timezone);
			return ZonedDateTime.now(zid);
		}

		public static ZonedDateTime getZonedDTFromDate(Date date, String timezone){
			ZoneId zid = ZoneId.of(timezone);
			return ZonedDateTime.ofInstant(date.toInstant(), zid);
		}

	public static Date getDateFromZoned(ZonedDateTime zonedDateTime, String timezone){


		ZoneId zid = ZoneId.of(timezone);

		ZonedDateTime convertedTime = zonedDateTime.withZoneSameInstant(zid);
		int hourOfDay = convertedTime.getHour();
		int minute = convertedTime.getMinute();
		int second = convertedTime.getSecond();
		int year = convertedTime.getYear();
		int month = convertedTime.getMonthValue()-1;
		int dayOfMonth = convertedTime.getDayOfMonth();

		//(year, month, dayOfMonth, hourOfDay, minute, second, 0);
		Calendar cal = new GregorianCalendar();

		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		cal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
		cal.set(Calendar.HOUR_OF_DAY,hourOfDay);
		cal.set(Calendar.MINUTE,minute);
		cal.set(Calendar.SECOND,second);


		return cal.getTime();
	}



}
