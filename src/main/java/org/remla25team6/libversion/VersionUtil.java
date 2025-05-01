package org.remla25team6.libversion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VersionUtil {

    private static final String PROPERTIES = "version.properties";
    private static String libraryVersion = null;

    /**
     * Gets the version of this library.
     * Only attempts to read file if it was not successfully retrieved before.
     *
     * @return The library version string or null if not found.
     */
    public static String getVersion() {
        if (libraryVersion == null) {
            libraryVersion = findVersion();
        }
        return libraryVersion;
    }

    /**
     * Retrieves the version of the library from the version.properties file, which is populated by maven filtering.
     *
     * @return The library version string or null if not found.
     */
    public static String findVersion() {
        Properties props = new Properties();
        try (InputStream input = VersionUtil.class.getClassLoader().getResourceAsStream(PROPERTIES)) {
            if (input == null) {
                return null;
            }

            props.load(input);
            String version = props.getProperty("library.version");
            return version;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
