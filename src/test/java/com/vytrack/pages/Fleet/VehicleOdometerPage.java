package com.vytrack.pages.Fleet;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleOdometerPage {

    public VehicleOdometerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[contains(text(),'Create Vehicle Odometer')])[3]")
    public WebElement createVehicleOdometerButton;


    @FindBy(css = "[id^='custom_entity_type_OdometerValue']")
    public WebElement odometerValueTextBox;

    @FindBy(css = "[id^='custom_entity_type_Driver']")
    public WebElement driverTextBox;

    @FindBy(css = "[type='submit']")
    public WebElement saveAndCloseButton;


}
