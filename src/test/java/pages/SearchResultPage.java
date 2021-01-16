package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//*[@id='newBuyBoxPrice']")
    private WebElement secondPagePrice;

    @FindBy(xpath = "//div[contains(@data-component-props,'Index=0')]/div[@data-component-type='sp-sponsored-result']//h2/a")
    private WebElement firstElement;
    @FindBy(xpath = "//div[contains(@data-component-props,'Index=0')]/div[@data-component-type='sp-sponsored-result']//span[@class='a-price']")
    private WebElement firstPageElementPrice;
    @FindBy(xpath = "//span[@class='a-price']")
    private WebElement firstBookFromSearchList;
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;
    @FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
    private WebElement priceOfTheBookBeforeSelecting;
    @FindBy(xpath = "(//span[@class='a-size-medium'])[5]/span")
    private WebElement priceOfTheBookAfterSelecting;
    @FindBy(xpath = "//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    private WebElement priceAfterAddingCart;

    public String getFirstElementPrice(){

        return firstPageElementPrice.getText().replaceAll("\n", ".");
    }

    public WebElement getFirstElement() {

        return firstElement;
    }

    public WebElement getSecondPagePrice() {
        return secondPagePrice;
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getPriceAfterAddingToCart() {
        return priceAfterAddingCart.getText();
    }





}
