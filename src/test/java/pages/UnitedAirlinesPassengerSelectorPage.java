package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesPassengerSelectorPage {
    public UnitedAirlinesPassengerSelectorPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#passengerSelector button")
    public WebElement numberOfTravelerSelectorButton;

    @FindBy(css="#passengerMenuId div div button")
    public List<WebElement> addingAndSubtractingTravelerButtons;

    @FindBy(css = "div[class='app-components-PassengerSelector-passengers__passengerMenu__controls--1-kWM'] use")
    public WebElement closePanel;

    @FindBy(xpath= "//span[text()='Apply']/..")
    public WebElement applyButton;



}
