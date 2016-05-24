package tests;


public class Config {
    public static final String baseUrl = System.getProperty("baseUrl","http://the-internet.herokuapp.com");
    public static final String browser = System.getProperty("browser", "firefox");
    public static final String host = System.getProperty("host", "localhost");
    public static final String browserVersion = System.getProperty("browserVersion", "43");
    public static final String platform = System.getProperty("platform", "Windows 8");
    public static final String sauceUser = "clarkgroce";
    public static final String sauceKey = "321718b4-025e-422e-80d0-b71ce5c2a0c9";
}


