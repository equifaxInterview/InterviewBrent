package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultPage;
import utilities.ConfigurationReader;
import utilities.Driver;



public class StepDefinitions {

    String  firstPageElementPrice = "";
    String priceAfterAddingToCart = "";
    String secondPagePrice = "";
    HomePage hP = new HomePage();
    CartPage cP = new CartPage();
    SearchResultPage sR = new SearchResultPage();


    @Given("User on the home page and login as an authorized user")
    public void User_on_the_home_page_and_login_as_an_authorized_user() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        hP.loginToAmazon();

    }


    @When("User search {string}")
    public void user_search_under_category(String input ) {


        hP.enterBooksName(input);
        hP.clickSubmitButton();



    }
    @And("User selects the first search results")
    public void user_clicks_on_the_first_search_results() throws InterruptedException {

        firstPageElementPrice = sR.getFirstElementPrice();
        sR.getFirstElement().click();
        secondPagePrice = sR.getSecondPagePrice().getText();


    }
    @Then("Price under search result and Product's detail page should match")
    public void price_under_search_result_and_product_s_detail_page_should_match() {

        Assert.assertEquals(firstPageElementPrice,secondPagePrice);

    }

    @And("User clicks on Add to cart button")
    public void userClicksOnAddToCartButton() {

        sR.clickAddToCart();


    }
    @Then("under search result price and cart price should match")
    public void underSearchResultPriceAndCartPriceShouldMatch() {

        priceAfterAddingToCart = sR.getPriceAfterAddingToCart();
        Assert.assertEquals(firstPageElementPrice,priceAfterAddingToCart);
    }

    @When("user clicks on proceed to check out")
    public void userClicksOnProceedToCheckOut() {

        cP.clickProceedToCheckOut();
        cP.addressConfirmationButton();
    }


    @Then("Check out price and search page price should match")
    public void checkOutPriceAndSearchPagePriceShouldMatch() {

        Assert.assertEquals(firstPageElementPrice,cP.getCheckOutPrice().getText());

    }





}
