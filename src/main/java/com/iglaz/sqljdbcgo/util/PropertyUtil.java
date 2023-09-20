package com.iglaz.sqljdbcgo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyUtil {

    private static final Properties PROPERTIES = new Properties();

    private PropertyUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
