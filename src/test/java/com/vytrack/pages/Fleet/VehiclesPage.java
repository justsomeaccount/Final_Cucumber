package com.vytrack.pages.Fleet;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VehiclesPage {
    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(css = "[title='Create Car']")
    public WebElement createCarButton;

    @FindBy(css = ".btn.filter-criteria-selector.oro-drop-opener.oro-dropdown-toggle.filter-default-value")
    public WebElement modelNameFilter;



    @FindBy(css = ".fa-filter.hide-text")
    public WebElement filter;


    @FindBy(css = "[name='value']")
    public WebElement modelNameContains;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> selectVehicleModels;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public WebElement selectFirstVehicleModel;

    @FindBy(xpath = "//*[.='Select']/button")
    public WebElement selectButton;

    @FindBy(xpath = "//*[contains(@name,'custom_entity_type_Vehicle_Model')]")
    public WebElement modelRadioButton;

    @FindBy(xpath = "//*[contains(@name,'custom_entity_type_Vehicle_Make')]")
    public WebElement makeRadioButton;


    @FindBy(css = ".btn.btn-primary.filter-update")
    public WebElement modelNameContainsUpdateButton;

    @FindBy(css = "[type=submit]")
    public WebElement saveAndCloseButton;

    @FindBy(css = ".add-filter-button")
    public WebElement manageFilters;







    public void enterDataFor(String item,String data){
        String css="[id^=custom_entity_type_"+item.replaceAll(" ","")+"]";
        Driver.getDriver().findElement(By.cssSelector(css)).clear();
        Driver.getDriver().findElement(By.cssSelector(css)).sendKeys(data);
    }

    public void enterModelMake(String model,String make){
        String xpathModel="(//*[@class='btn btn-medium add-btn'])[1]";
        String xpathMake="(//*[@class='btn btn-medium add-btn'])[2]";
    Driver.getDriver().findElement(By.xpath(xpathModel)).click();
    filter.click();
    modelNameFilter.click();
    modelNameContains.sendKeys(model);
    modelNameContainsUpdateButton.click();
    if(!selectVehicleModels.isEmpty()){
        BrowserUtils.waitPlease(1);
        selectFirstVehicleModel.click();
        BrowserUtils.waitPlease(1);

        selectButton.click();
        modelRadioButton.click();
    }

        Driver.getDriver().findElement(By.xpath(xpathMake)).click();

        //filter.click();

        modelNameFilter.click();
        modelNameContains.sendKeys(make);
        modelNameContainsUpdateButton.click();
        if(!selectVehicleModels.isEmpty()){

            BrowserUtils.waitPlease(1);

            selectFirstVehicleModel.click();
            BrowserUtils.waitPlease(1);

            selectButton.click();
            makeRadioButton.click();
        }

        saveAndCloseButton.click();


    }


    public void setManageFilters(String filter,String data){
        Select select=new Select(Driver.getDriver().findElement(By.cssSelector("[data-action=add-filter-select]")));
        select.selectByVisibleText(filter);
        modelNameFilter.click();
        modelNameContains.sendKeys(data);
        modelNameContainsUpdateButton.click();




    }







}
