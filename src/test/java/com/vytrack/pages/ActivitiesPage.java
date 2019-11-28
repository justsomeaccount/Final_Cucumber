package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivitiesPage {

    public ActivitiesPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(xpath = "(//*[contains(text(),'Create Calendar event')])[3]")
    public WebElement createCalendarEventButton;

    @FindBy(xpath = "//input[contains(@id,'recurrence-repeat-view')]")
    public WebElement createFormRepeatCheckbox;

    @FindBy(xpath = "//*[@class='loader-mask shown']")
    public WebElement loaderMaskShown;

    @FindBy(xpath = "//select[contains(@id,'recurrence-repeats-view')]")
    public WebElement createFormRepeatsSelectbox;



    @FindBy(xpath = "//*[contains(text(),'The value have not to')]")
    public WebElement repeatDayNumberErrorMessage;

    @FindBy(xpath = "//*[contains(text(),'The value have not to')]")
    public List<WebElement> repeatDayNumberErrorMessages;

    @FindBy(xpath = "//*[contains(text(),'This value should not be blank.')]")
    public WebElement repeatDayNumberBlankErrorMessage;

    @FindBy(xpath = "//*[contains(text(),'This value should not be blank.')]")
    public List<WebElement> repeatDayNumberBlankErrorMessages;


    @FindBy(css = ".recurrence-subview-control__item>label>input")
    public WebElement createFormRepeatEveryDaysRadioButton;

    @FindBy(css = ".recurrence-subview-control__item:nth-of-type(2)>label>input")
    public WebElement createFormRepeatEveryWeekDayRadioButton;

    @FindBy(css = ".fields-row>input:nth-of-type(3)")
    public WebElement createFormRepeatEveryDaysInputBox;

    @FindBy(xpath = "//*[@data-related-field='occurrences']")
    public WebElement createFormAfterOccurencesInputBox;

    @FindBy(css = ".control-group.recurrence-summary.alert-info>div:nth-of-type(2)>div>span")
    public WebElement createFormSummary;
/////////////Date Picking/////////////////////////////


    @FindBy(css = "[id^=date_selector_oro_calendar_event_form_start]")
    public WebElement getStartDateInputBox;

    @FindBy(css = "[id^=time_selector_oro_calendar_event_form_start]")
    public WebElement getStartTimeInputBox;


    @FindBy(css = "[id^=date_selector_oro_calendar_event_form_end]")
    public WebElement getEndDateInputBox;

    @FindBy(css = "[id^=time_selector_oro_calendar_event_form_end]")
    public WebElement getEndTimeInputBox;



    @FindBy(xpath = "//*[@class='ui-state-default']")
    public WebElement startDateEachDaySelection;

    @FindBy(xpath = "//*[contains(text(),'Next')]")
    public WebElement startDateNextMonthSelection;

    @FindBy(xpath = "//*[contains(text(),'Today')]")
    public WebElement startDateTodaySelection;





}
