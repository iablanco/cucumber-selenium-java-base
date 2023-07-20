package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComputerDBPage extends BasePage{


    private String filterTxtBoxLocator = "//*[@id='searchbox']";
    private String resultList = "//*[@id=\"main\"]/table/tbody/*";
    private String filterByNameLocator="//*[@id='searchsubmit']";

    public ComputerDBPage() {
        super(driver);
    }

    public void navigateToSite() {
        navigateTo("https://computer-database.gatling.io/");
    }

    public void enterComputerName(String cname) {
        write(filterTxtBoxLocator,cname);
    }

    private List<String> getComputerListNames(){

        List<WebElement> weList = getWebElementsByXpath(resultList);
        List<String> nameList = new ArrayList<>();

        for (WebElement e : weList){
            nameList.add(e.getText().replaceAll("[^A-Za-z0-9]",""));
        }

        return nameList;
    }



    public boolean isTheComputerInTheList(String cname) {

       return getComputerListNames().contains(cname.replaceAll("[^A-Za-z0-9]",""));

    }

    public void clickFilterBtn() {
        clickElement(filterByNameLocator);
    }

    public boolean computerListIsEmpty() {
        return getWebElementsByXpath(resultList).isEmpty();
    }
}
