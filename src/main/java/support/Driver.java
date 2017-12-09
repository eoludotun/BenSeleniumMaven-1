package support;
import com.sun.javafx.runtime.SystemProperties;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {

    public static WebDriver aDriver;
    private static String currentDir;
    private static Logger _logger;

    public Driver(WebDriver aDriver) {

        this.aDriver = aDriver;

    }
    

    //Singleton Logger
    public static Logger log()
    {
    	if(_logger == null)
    		_logger = LogManager.getLogger();
    	return _logger;
    }



    public static void setSystemsProperties() {

        currentDir = System.getProperty("user.dir");

        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", currentDir
                    + "/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", currentDir
                    + "/drivers/chromedriver");
        }
    }

    public static WebDriver initialiseDriver() {
        setSystemsProperties();
        aDriver = new ChromeDriver();
        log().info("Current Browser is: " + aDriver);
        System.out.println(aDriver);
        aDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        return aDriver;
    }

    public static void quiteDriver() {

        try {

            aDriver.close();
            if (aDriver != null) {

                aDriver.quit();
                aDriver = null;
            }

        } catch (UnreachableBrowserException e) {

            System.out.println("Browser has already Shutdown");

        }


    }


    public static void screenShotOnFailure(Scenario scenario) {


        if (scenario.isFailed()) try {

            scenario.write(scenario.getName() + " ---- " + scenario.getId()
                    + " ------- " + scenario.getStatus() + "\n"
                    + aDriver.getCurrentUrl());

            byte[] screenshot = ((TakesScreenshot) aDriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        } catch (WebDriverException screenShotException) {
            System.err.println(screenShotException.getMessage());
        }
    }

}
