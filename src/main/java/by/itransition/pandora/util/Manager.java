package by.itransition.pandora.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class Manager {


    private static final Logger LOGGER = LogManager.getLogger(Manager.class);

    public final static ResourceBundle mailPropertiesRB = ResourceBundle.getBundle("properties.mail");

    public static String getProperty(String key, ResourceBundle resourceBundle) {
        if (resourceBundle.containsKey(key)) {
            return resourceBundle.getString(key);
        } else {
            LOGGER.log(Level.INFO, "Manager cant find " + key + " in " + resourceBundle.getBaseBundleName());
        }
        return null;
    }
}
