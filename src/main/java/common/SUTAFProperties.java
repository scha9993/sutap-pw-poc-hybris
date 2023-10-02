package common;

import com.syscolab.qe.core.common.LoggerUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SUTAFProperties {
    private static String defaultFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    private static Properties properties = null;
    private static String defaultEnvFilePath = System.getProperty("user.dir") + "/src/main/resources/" + getProperty("test.env") + "_config.properties";
    private static Properties envProperties = null;

    private SUTAFProperties() {
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream(defaultFilePath)){
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            LoggerUtil.logINFO(e.toString());
        }
    }

    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();

        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }

    private static void loadEnvProperties() {
        try (InputStream input = new FileInputStream(defaultEnvFilePath)){
            envProperties = new Properties();
            envProperties.load(input);
        } catch (IOException e) {
            com.syscolab.qe.core.common.LoggerUtil.logERROR(e.getMessage(), e);
        }
    }

    public static String getEnvProperty(String key) {
        if (envProperties == null)
            loadEnvProperties();

        String p = System.getProperty(key);
        return p != null ? p : envProperties.getProperty(key);
    }
}
