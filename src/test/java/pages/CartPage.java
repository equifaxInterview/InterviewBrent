package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    @FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
    private WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//a[@data-action='page-spinner-show']")
    private WebElement adressConfirmationButton;

    @FindBy(className = "a-color-price")
    private WebElement checkOutPrice;

    public WebElement getCheckOutPrice() {
        return checkOutPrice;
    }

    public void addressConfirmationButton(){

        wait.until(ExpectedConditions.elementToBeClickable(adressConfirmationButton)).click();
    }

    public void clickProceedToCheckOut() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton)).click();
    }




}
