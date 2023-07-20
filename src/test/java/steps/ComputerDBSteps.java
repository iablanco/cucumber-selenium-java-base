package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.ComputerDBPage;

public class ComputerDBSteps {

    ComputerDBPage computerDBPage = new ComputerDBPage();

    @Given("I navigate to the computer db site")
    public void iNavigateToTheComputerDbSite() {
        computerDBPage.navigateToSite();
    }


    @When("I enter (.*) computer$")
    public void enterComputer(String cname) {
        computerDBPage.enterComputerName(cname);
    }

    @When("I click filter by name button")
    public void iClickFilterByNameButton() {
        computerDBPage.clickFilterBtn();

    }

    @Then("I get the computer I wanted (.*)$")
    public void getComputerIWanted(String cname){
        Assert.assertTrue("The computer "+cname+" is not in the list",computerDBPage.isTheComputerInTheList(cname));
    }


    @Then("The not listed computer should not appear")
    public void theNotListedComputerShouldNotAppear(String cname) {
        Assert.assertFalse("The computer "+cname+" is not in the list", computerDBPage.computerListIsEmpty());
    }
}
