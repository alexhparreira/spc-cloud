package com.spcbrasil.api.util;

import org.springframework.data.domain.PageRequest;

public class Constants {
    public static final String ENGLISH_DATE_FORMATE = "yyyy-MM-dd"; //yyyy-MM-dd
    public static final String DB_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String MONGO_DATE_FORMATE = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    public static final int MAX_USER_IMAGE_SIZE = 2048;
    public static final String DATE_FORMAT_PT_BR = "dd/MM/yyyy" ;
    public static final String DATE_TIME_FORMAT_PT_BR_SHORT = "dd/MM/yy HH:mm" ;
    public static final String DATE_TIME_FORMAT_PT_BR = "dd/MM/yyyy HH:mm" ;
    public static final String OK = "OK" ;
    public static final String UTC = "UTC";
    public static PageRequest pageableOne = PageRequest.of(0, 1);
    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";

    public static final String DETAILS = "details";
    public static final String PLAYERS = "players";
    public static final String BOTH = "both";
}
