package com.example.demo.util;

/**
 * @author sksingh created on 18/01/24
 */
public class ConfigUtil {

    public static String getClusterType() {
        return "preprod_cloud";
    }

    public static String configId() {
        return String.join("_", "HONDA", "ACURA_NEW", "0", "0");
    }
}
