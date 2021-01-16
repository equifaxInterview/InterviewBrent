package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ConfigurationReader;

public class HomePage extends BasePage {


    @FindBy(id = "nav-search-dropdown-card")
    private WebElement category;

    @FindBy(xpath = "//a[@data-nav-ref='nav_ya_signin']")
    private WebElement signInTab;

    @FindBy(id = "ap_email")
    private WebElement emailInputTab;

    @FindBy(id = "ap_password")
    private WebElement passwordInputTab;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(className = "s-result-item s-asin sg-col-0-of-12 sg-col-16-of-of-20")
    private WebElement firstElement;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(id="nav-search-submit-button")
    private WebElement submitButton;


    public void enterBooksName(String bookName){

        searchBar.sendKeys(bookName);
    }
    public void clickSubmitButton(){

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void loginToAmazon() throws InterruptedException {
        signInTab.click();
        emailInputTab.sendKeys(ConfigurationReader.getProperty("username")+ (Keys.ENTER));
        passwordInputTab.sendKeys(ConfigurationReader.getProperty("password")+(Keys.ENTER));

    }





}
