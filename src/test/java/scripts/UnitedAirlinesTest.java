package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base{
    /*
    Test Case 1: Validate "Main menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see “Main menu” navigation items
|BOOK                              |
|MY TRIPS                          |
|TRAVEL INFO            |
|MILEAGEPLUS® PROGRAM|
|DEALS                             |
|HELP                              |
     */

    @Test(priority = 1, description = "TC:1 - Validate Main Menu")
    public void mainMenuValidation(){
        driver.get("https://www.united.com/en/us");
            String[] mainMenuTexts = {"BOOK","MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};
            for (int i = 0; i < 6; i++) {
                Assert.assertTrue(unitedAirlinesHomePage.mainMenuItems.get(i).isDisplayed());
                Assert.assertEquals(unitedAirlinesHomePage.mainMenuItems.get(i).getText(), mainMenuTexts[i]);
            }

        }

    /*
        Test Case 2: Validate "Book travel menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see "Book travel menu" navigation items
|Book             |
|Flight Status|
|Check-in       |
|My trips        |
     */

    @Test(priority = 2, description =" TC 2: Validate book travel menu")
    public void bookTravelMenuValidation(){
        driver.get("https://www.united.com/en/us");

        String[] bookTravelMenuTexts = {"Book","Flight status", "Check-in", "My trips"};
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(unitedAirlinesHomePage.bookTravelMenuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesHomePage.bookTravelMenuItems.get(i).getText(), bookTravelMenuTexts[i]);
        }

    }
    /*
    Test Case 3: Validate "Round-trip" and "One-way" radio buttons
Given user is on "https://www.united.com/en/us"
Then validate "Roundtrip" radio button is displayed, is enabled and is selected
And validate "One-way" radio button is displayed, is enabled but is not selected
When user clicks on "One-way" radio button
Then validate "One-way" radio button is selected while "Roundtrip" radio button is
deselected
     */

    @Test(priority = 3, description= "TC 3: Validate Round-trip and One-way radio buttons")
    public void roundTripAndOneWayButtonValidation(){
        driver.get("https://www.united.com/en/us");

        unitedAirlinesHomePage.roundTripButton.click();
        Assert.assertTrue(unitedAirlinesHomePage.roundTripLabel.isDisplayed());
        Assert.assertEquals(unitedAirlinesHomePage.roundTripLabel.getText(), "Roundtrip");
        Assert.assertTrue(unitedAirlinesHomePage.roundTripButton.isEnabled() && unitedAirlinesHomePage.roundTripButton.isSelected());
        Assert.assertTrue(unitedAirlinesHomePage.oneWayLabel.isDisplayed());
        Assert.assertEquals(unitedAirlinesHomePage.oneWayLabel.getText(), "One-way");
        Assert.assertTrue(unitedAirlinesHomePage.oneWayButton.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.oneWayButton.isSelected());
        unitedAirlinesHomePage.oneWayButton.click();
        Assert.assertTrue(unitedAirlinesHomePage.oneWayButton.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.roundTripButton.isSelected());

    }

    /*
    Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
Given user is on "https://www.united.com/en/us"
Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
When user clicks both checkboxes
Then validate both checkboxes are selected
When user clicks on both selected checkboxes again
Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = "TC-4: Validate Book with miles and Flexible dates checkboxes")
    public void bookWithMilesAndFlexibleDatesValidation(){
        driver.get("https://www.united.com/en/us");
       Assert.assertEquals(unitedAirlinesHomePage.bookWithMilesLabel.getText(), "Book with miles");
       Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesLabel.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
        Assert.assertEquals(unitedAirlinesHomePage.flexibleDatesLabel.getText(), "Flexible dates");
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesLabel.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());
        unitedAirlinesHomePage.bookWithMilesLabel.click();
        unitedAirlinesHomePage.flexibleDatesLabel.click();
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected() &&
                unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());
        unitedAirlinesHomePage.bookWithMilesLabel.click();
        unitedAirlinesHomePage.flexibleDatesLabel.click();
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected() &&
                unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());

    }

/*
Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
Miami, FL, US (MIA)”
Given user is on "https://www.united.com/en/us"
When user selects "One-way" ticket radio button
And user enters "Chicago, IL, US (ORD)" to from input box
And user enters "Miami, FL, US (MIA)" to input box
And user selects "Jan 30" to the dates input box
And user selects "2 Adults" from travelers selector
And user selects "Business or First" from cabin dropdown
And user clicks on "Find Flights" button
Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
 */

    @Test(priority = 5, description = "TC-5: Validate one-way ticket search from Chicago(ORD) to Miami(MIA)")
    public void oneWayTicketSearchTest(){
        driver.get("https://www.united.com/en/us");
        unitedAirlinesHomePage.oneWayButton.click();
        unitedAirlinesHomePage.fromFlightInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedAirlinesHomePage.toFlightInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesHomePage.oneWayDateInputBox.click();
        Waiter.pause(2);
        int click = 0;
        do {
            unitedAirlinesHomePage.dateSelectorTableButton.click();
            click++;
        } while (click < 5);

        unitedAirlinesHomePage.jan30.click();
        unitedAirlinesPassengerSelectorPage.numberOfTravelerSelectorButton.click();
        for(int i = 0; i < 16; i++){
            unitedAirlinesPassengerSelectorPage.addingAndSubtractingTravelerButtons.get(1).click();
            break;
        }

        unitedAirlinesPassengerSelectorPage.closePanel.click();
        unitedAirlinesHomePage.cabinTypeButton.click();

        unitedAirlinesHomePage.cabinTypes.get(2).click();
        unitedAirlinesHomePage.findFlightsButton.click();
        //Assert.assertEquals(unitedAirlinesTripShoppingResultsPage.tripSelectionResultsHeader.getText(), "Chicago, IL, US to Miami, FL, US");

    }

}




