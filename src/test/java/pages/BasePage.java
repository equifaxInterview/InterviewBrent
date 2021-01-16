package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;


abstract public class BasePage {



     public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 25);




}
