import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }
    static WebDriver driver;
    static WebPage webPage;

    @BeforeClass
    public static void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        webPage = new WebPage(driver);
        driver.manage().window().maximize();
    }

    @Test(testName = "Storage Map Filter Validations")
    public static void openClusterPage(){
        driver.get(Utils.BASE_URL);
        webPage.selectMaps();
        webPage.filterMapName();
 /*       webPage.wrongFilter("test");
        webPage.trueFilter("default");
        webPage.checkColumn(webPage.entries, "100");
        webPage.checkColumn(webPage.names, "default");*/
    }


    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}