package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //PageFactory.initElements(driver,this);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    //Encuentra un web element usando wait hasta que es encontrado el elemento
    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    //Click sobre un WebElement buscandolo antes con find()
    public void clickElement(String locator){
        find(locator).click();
    }

    //Click sobre un WebElement
    public void clickElement(WebElement element){
        element.click();
    }

    //Escribe un texto sobre un web element
    public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);

    }

    public void dropDownSelectByValue(String dropDownlocator, String value){
        Select dropDonwList = new Select(find(dropDownlocator));
    }

    //Over sobre WebElement
    public void hoverOverElement(String locator){
        action.moveToElement(find(locator));
    }

    //Doble click sobre WebElement
    public void doubleClick(String locator){
        action.doubleClick(find(locator));
    }

    //Click derecho sobre Web element
    public void rightClick(String locator){
        action.contextClick(find(locator));
    }

    //Cambiar a iframe por id
    public void switcToIframe(int iframeindex){
        driver.switchTo().frame(iframeindex);
    }

    //Cambiar a parent frame
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    //si hay alerta o popup la revoca del dom
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromElement(String locator){
        return find(locator).getText();
    }

    //Verifica que el elemento se esta mostrano
    public boolean elementIsDisplayed(String locator){
        return find(locator).isDisplayed();
    }

    //Verifica que el elemento esta habilitado
    public boolean elementIsEnabled(String locator){
        return find(locator).isEnabled();
    }

    //En un checkbox, verifica que el elemento esta seleccionado
    public boolean elementIsSelected(String locator){
        return find(locator).isSelected();
    }

    public List<WebElement> getWebElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public List<WebElement> getWebElementsByXpath(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public String getValueFromTable(String locator,int row,int column){
        String cellINeedd = locator + "/table/tbody/tr["+row+"]"+"["+column+"]";

        return find(cellINeedd).getText();
    }

}
