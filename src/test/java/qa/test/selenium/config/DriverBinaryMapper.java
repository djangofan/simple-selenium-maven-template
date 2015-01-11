package qa.test.selenium.config;

import java.util.HashMap;
import java.util.Map;

public class DriverBinaryMapper {
    private static final Map<DriverBinaryContext, String> binaryLocation = new HashMap<DriverBinaryContext, String>() {{
        put(DriverBinaryContext.binaryFor(DriverType.CHROME, OperatingSystem.WINDOWS, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/windows/googlechrome/64bit/2.10/chromedriver.exe"));
        put(DriverBinaryContext.binaryFor(DriverType.CHROME, OperatingSystem.MAC, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/osx/googlechrome/64bit/2.10/chromedriver"));
        put(DriverBinaryContext.binaryFor(DriverType.CHROME, OperatingSystem.LINUX, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/linux/googlechrome/64bit/2.10/chromedriver"));
        put(DriverBinaryContext.binaryFor(DriverType.CHROME, OperatingSystem.WINDOWS, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/windows/googlechrome/32bit/2.10/chromedriver.exe"));
        put(DriverBinaryContext.binaryFor(DriverType.CHROME, OperatingSystem.MAC, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/osx/googlechrome/32bit/2.10/chromedriver"));
        put(DriverBinaryContext.binaryFor(DriverType.CHROME, OperatingSystem.LINUX, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/linux/googlechrome/32bit/2.10/chromedriver"));
        put(DriverBinaryContext.binaryFor(DriverType.PHANTOMJS, OperatingSystem.WINDOWS, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/windows/phantomjs/64bit/1.9.2/phantomjs.exe"));
        put(DriverBinaryContext.binaryFor(DriverType.PHANTOMJS, OperatingSystem.MAC, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/osx/phantomjs/64bit/1.9.7/phantomjs"));
        put(DriverBinaryContext.binaryFor(DriverType.PHANTOMJS, OperatingSystem.LINUX, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/linux/phantomjs/64bit/1.9.7/phantomjs"));
        put(DriverBinaryContext.binaryFor(DriverType.PHANTOMJS, OperatingSystem.WINDOWS, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/windows/phantomjs/32bit/1.9.7/phantomjs.exe"));
        put(DriverBinaryContext.binaryFor(DriverType.PHANTOMJS, OperatingSystem.MAC, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/osx/phantomjs/32bit/1.9.7/phantomjs"));
        put(DriverBinaryContext.binaryFor(DriverType.PHANTOMJS, OperatingSystem.LINUX, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/linux/phantomjs/32bit/1.9.7/phantomjs"));
        put(DriverBinaryContext.binaryFor(DriverType.IE, OperatingSystem.WINDOWS, SystemArchitecture.ARCHITECTURE_64_BIT), DriverBinaryContext.binaryPath("/windows/internetexplorer/64bit/2.42.0/IEDriverServer.exe"));
        put(DriverBinaryContext.binaryFor(DriverType.IE, OperatingSystem.WINDOWS, SystemArchitecture.ARCHITECTURE_32_BIT), DriverBinaryContext.binaryPath("/windows/internetexplorer/32bit/2.42.0/IEDriverServer.exe"));

    }};

    static void configureBinary(DriverType driverType, OperatingSystem operatingSystem, SystemArchitecture systemArchitecture) {
        if (!DriverType.useRemoteWebDriver) {
            final String binarySystemProperty = driverType.getWebDriverSystemPropertyKey();

            if (null != binarySystemProperty && binarySystemProperty.length() != 0) {
                final String binaryConfiguration = binaryLocation.get(DriverBinaryContext.binaryFor(driverType, operatingSystem, systemArchitecture));
                System.out.println("Setting System Property '" + binarySystemProperty + "'='" + binaryConfiguration + "'");
                System.setProperty(binarySystemProperty, binaryConfiguration);
            }
        }
    }

    static String getBinaryPath(DriverType browserType, OperatingSystem osName, SystemArchitecture systemArch) {
        return binaryLocation.get(DriverBinaryContext.binaryFor(browserType, osName, systemArch));
    }
}