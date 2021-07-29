import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class WebPage extends PageObjects{

    @FindBy(xpath = "//a[contains(text(),'Select')]")
    private WebElement active_cluster;
    
    @FindBy(xpath = "//button[contains(text(),'Add Cluster Config')]")
    private WebElement cluster_config;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement save_config;

    @FindBy(xpath = "//a[@data-test='menu-maps']/span[contains(text(),'Maps')]")
    private WebElement storage_maps;

    @FindBy(css = "div.rt-tbody div.rt-tr-group div.rt-td.core-components-HzTable-__HzTable-module___left.core-components-HzTable-__HzTable-module___box > div")
    WebElement names;

    @FindBy(css = "div.rt-tbody div.rt-tr-group div.rt-td.core-components-HzTable-__HzTable-module___left.core-components-HzTable-__HzTable-module___box + div > div")
    WebElement entries;

    
    @FindBy(xpath = "//span[contains(text(),'ENABLE')]")
    private WebElement enable_dev_mode;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public WebPage(WebDriver driver) {
        super(driver);
    }

    public void selectCluster(){
        wait.until(ExpectedConditions.elementToBeClickable(this.active_cluster));
        this.active_cluster.click();
    }

    public void clusterConfig(){
        wait.until(ExpectedConditions.elementToBeClickable(this.cluster_config));
        this.cluster_config.click();
    }
    
    public void saveConfig(){
        wait.until(ExpectedConditions.elementToBeClickable(this.save_config));
        this.save_config.click();    
    }

    public void selectMaps(){
        wait.until(ExpectedConditions.elementToBeClickable(this.storage_maps));
        Actions action = new Actions(driver);
        action.moveToElement(storage_maps).perform();
        this.storage_maps.click();
    }
    
    public void enableDevMode() {
        wait.until(ExpectedConditions.elementToBeClickable(this.enable_dev_mode));
        this.enable_dev_mode.click();
    }


    public void checkColumn(@org.jetbrains.annotations.NotNull WebElement columnPath, String value){
        Assert.assertEquals(columnPath.getText(), value);
    }

}
