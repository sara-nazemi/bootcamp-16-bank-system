package ir.bootcamp.java.banksystem.sftp.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ResourceBundleUtil {

    Map<String, String> locales = new HashMap<>() {{
        put("fa", "IR");
        put("en", "US");
    }};

    public String getMessage(String code, String language) {
        String country = locales.get(language);
        if (country == null) {
            country = "IR";
            language = "fa";
        }

        Locale locale = new Locale(language, country);

        ResourceBundle bundle = ResourceBundle.getBundle("exception", locale);

        String message = "";
        try {
            message = bundle.getString(code);
        } catch (NullPointerException | MissingResourceException ex) {
        }
        return message;
    }

}
