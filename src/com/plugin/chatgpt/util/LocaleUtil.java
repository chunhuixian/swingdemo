package com.plugin.chatgpt.util;

import org.apache.commons.lang.StringUtils;

import java.util.Locale;

public class LocaleUtil {
    private static final String CHINA = "CN";

    public LocaleUtil() {
    }

    public static String getCurrentCountry() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country;
    }

    public static Boolean isChina() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return StringUtils.equals(country, "CN");
    }
}
