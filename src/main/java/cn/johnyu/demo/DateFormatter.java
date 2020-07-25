package cn.johnyu.demo;


import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 中需要把它变成一个Bean即可以使用
 * 但要注意：它只在Form表单中起作用
 */
@Component
public class DateFormatter implements Formatter<Date> {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        Date d=null;
        synchronized (this){
            d=sdf.parse(text);
        }
        return d;
    }

    @Override
    public String print(Date object, Locale locale) {
        String s=null;
        s=sdf.format(object);
        return s;
    }
}
