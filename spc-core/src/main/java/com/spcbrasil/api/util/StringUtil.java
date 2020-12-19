package com.spcbrasil.api.util;


import com.spcbrasil.api.shared.UserDTO;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class StringUtil {

    public static final String YEAR_MONTH_DAY_MASK = "yyyy-MM-dd";
    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

    public static final Long ACTIVE_PLAYER = 9L;
    public static final Long INACTIVE_PLAYER = 7L;
    private static final Random random = new Random();
    private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$";

    public static final String UTF8_BOM = "\uFEFF";
    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";
    //'\uFEFF' 65279

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return o != null;
    }

    public static Object returnIfNotNull(Object o) {
        return isNotNull(o) ? o : null;
    }

    public static Long returnIfNotNull(Long o) {
        return isNotNull(o) ? o : null;
    }

    public static String returnIfNotNull(String o) {
        return isNotNull(o) ? o : null;
    }


    public static boolean isNotNullOrEmpty(String s) {
        return isNotNull(s) && !s.isEmpty();
    }

    public static boolean isNullOrEmpty(String s) {
        return isNull(s) || s.isEmpty();
    }

    public static boolean isNullOrEmpty(List s) {
        return isNull(s) || s.isEmpty();
    }

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_FORMAT_PT_BR = "dd/MM/yyyy";

    public static final String DATE_FORMAT_MONTH_YEAR = "MM/yyyy";

    public static final String TIME_FORMAT = "H:m:s";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd H:m:s";

    public static final String DATE_TIME_HOUR_MIN_FORMAT = "yyyy-MM-dd H:m";

    public static final String DATE_TIME_JAVA_SCRIPT = "yyyy-MM-ddTHH:mm:ssZ";

    public static final String DATE_ISO_DATE = "yyyyMMdd'T'HHmmss.SSSZ";


    public static Date addOrSubtractDaysToDate(Date date, int numberOfDays) {

        Date addSubtractedDate = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, numberOfDays);
        addSubtractedDate.setTime(c.getTime().getTime());

        return addSubtractedDate;
    }

    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
        try {
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(date);
            XMLGregorianCalendar xg = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {
            return null;
        }
    }


    public static XMLGregorianCalendar defaultXMLGregorianCalendar() {
        try {
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.set(1900, 0, 1, 0, 0, 0);
            XMLGregorianCalendar xg = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateToString(Date date, String formato) {
        if (date == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(formato);
        String reportDate = df.format(date);
        return reportDate;
    }

    public static Date stringToDate(String data, String formato) {
        if ((data == null) || (data.equals(""))) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat(formato);
            date = formatter.parse(data);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static XMLGregorianCalendar timestampToXMLGregorianCalendar(Date date) {
        try {
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {
            return null;
        }
    }


    public static java.util.Date xmlGregorianCalendarToDate(XMLGregorianCalendar gc) {
        try {
            return gc.toGregorianCalendar().getTime();
        } catch (Exception e) {
            return null;
        }

    }

    public static boolean convertIntToBoolean(int value) {
        return value == 1;
    }

    public static boolean getBooleanValue(Boolean value) {
        return isNull(value) ? false : value;
    }



    public static String getToken(int length,int numberOfStrings) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< numberOfStrings; i++){
            sb.append(getRamdomString(length)).append("-");
        }

        return sb.toString().trim();
    }

    public static String getRamdomString(int length) {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            token.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return token.toString();
    }


    public static long diferenceInDays(Calendar inicio, Calendar fim) {
        long m1 = inicio.getTimeInMillis();
        long m2 = fim.getTimeInMillis();

        return ((m2 - m1) / 1000 / 60 / 60 / 24);
    }

    public static long diferenceInDays(Date dataInicial, Date dataFinal) {

        Calendar inicio = new GregorianCalendar();
        inicio.setTime(dataInicial);

        Calendar fim = new GregorianCalendar();
        fim.setTime(dataFinal);


        return diferenceInDays(inicio, fim);
    }

    public static Date setDateAttribute(Date date, int day, int attribute){

        Calendar baseDateCal = new GregorianCalendar();
        baseDateCal.setTime(date);
        baseDateCal.set(attribute,day);

        return baseDateCal.getTime();
    }

    public static String removeUTF8BOM(String s) {
        while (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }


}