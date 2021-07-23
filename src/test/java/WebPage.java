import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.time.Duration;

public class WebPage extends PageObjects{

    @FindBy(xpath = "//a[contains(text(),'Select')]")
    private WebElement active_cluster;

    @FindBy(xpath = "//div[contains(text(),'dev')]")
    private WebElement cluster_header;

    @FindBy(xpath = "//a[@data-test='menu-maps']/span[contains(text(),'Maps')]")
    private WebElement storage_maps;

    @FindBy(css = "#mc > div > div.__App-module___sidebar > div > nav > ul:nth-child(9) > li:nth-child(1) > a")
    private WebElement bjk;

    @FindBy(css = "div.rt-tbody div.rt-tr-group div.rt-td.core-components-HzTable-__HzTable-module___left.core-components-HzTable-__HzTable-module___box")
    WebElement names;

    @FindBy(css = "div.rt-tbody div.rt-tr-group div.rt-td.core-components-HzTable-__HzTable-module___left.core-components-HzTable-__HzTable-module___box + div > div")
    WebElement entries;

    @FindBy(xpath = "//span[contains(text(),'No data available in table')]")
    private WebElement no_data_filter;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement name_filter;

    public WebPage(WebDriver driver) {
        super(driver);
    }

    public void selectCluster(){
        this.active_cluster.isDisplayed();
        this.active_cluster.click();
    }

    public void validateClusterHeader(){
        this.cluster_header.isDisplayed();
    }

    public void selectMaps(){
        Actions action = new Actions(driver);
        action.moveToElement(storage_maps).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.storage_maps.isDisplayed();
        this.storage_maps.click();
    }

    public void filterMapName(){
        this.name_filter.isDisplayed();
    }

    public void trueFilter(String name){
        this.name_filter.clear();
        this.name_filter.sendKeys(name);
        String map_names;
        map_names = this.names.getText();
        Assert.assertEquals(map_names, name);
    }

    public void wrongFilter(String name){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.name_filter.clear();
        this.name_filter.sendKeys(name);
        this.no_data_filter.isDisplayed();
    }

    public void checkColumn(WebElement columnPath, String value){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(columnPath.getText(), value);
    }

}
