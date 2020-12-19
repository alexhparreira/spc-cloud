package com.spcbrasil.api.converters;

import org.springframework.core.convert.converter.Converter;
import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {

    @Override
    public Date convert(ZonedDateTime zonedDateTime) {

        Date date = Date.from(zonedDateTime.toInstant());
        return date;
    }

}