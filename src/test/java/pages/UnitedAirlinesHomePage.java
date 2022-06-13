package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesHomePage {
    public UnitedAirlinesHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[starts-with(@id,'headerNav')]")
    public List<WebElement> mainMenuItems ;

    @FindBy (css = ".app-components-BookTravel-bookTravel__travelNav--3RNBj li")
    public List<WebElement> bookTravelMenuItems;

    @FindBy(id="roundtrip")
    public WebElement roundTripButton;

    @FindBy(xpath= "//input[@id='roundtrip']/../span")
    public WebElement roundTripLabel;

    @FindBy(xpath = "//input[@id='oneway']/../span")
    public WebElement oneWayLabel;

    @FindBy(id="oneway")
    public WebElement oneWayButton;

    @FindBy(id="award")
    public WebElement bookWithMilesCheckBox;

    @FindBy(xpath="//span[text()='Book with miles']")
    public WebElement bookWithMilesLabel;

    @FindBy(css= "#flexibleDates")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id="flexDatesLabel")
    public WebElement flexibleDatesLabel;

    @FindBy(id="bookFlightOriginInput")
    public WebElement fromFlightInputBox;

    @FindBy(id="bookFlightDestinationInput")
    public WebElement toFlightInputBox;

    @FindBy(id= "DepartDate")
    public WebElement oneWayDateInputBox;

    @FindBy(css = "button[class*='app-containers-BookCalendar-bookCalendar__next']")
    public WebElement dateSelectorTableButton;

    @FindBy(css = "td[aria-label='Monday, January 30, 2023']")
    public WebElement jan30;


    @FindBy(id= "cabinType")
    public WebElement cabinTypeButton;

    @FindBy(xpath="//li[starts-with(@id,'cabinType')]")
    public List<WebElement> cabinTypes;

    @FindBy(xpath= "//span[text()='Find flights']/..")
    public WebElement findFlightsButton;







}
