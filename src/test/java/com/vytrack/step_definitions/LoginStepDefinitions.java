package com.vytrack.step_definitions;

import com.github.javafaker.App;
import com.vytrack.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    Pages pages=new Pages();


    @Given("Open	Vytrack	login	page")
    public void open_Vytrack_login_page() {

    pages.login().open();
    }


    @When("Enter	valid	username	and	invalid	password	information and click login")
    public void enter_valid_username_and_invalid_password_information_and_click_login() {
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),
                "invalid"          );

    }

    @Then("Message	Invalid user name or password.should	be	displayed")
    public void message_Invalid_user_name_or_password_should_be_displayed() {
        Assert.assertTrue(pages.login().errorMessage.isDisplayed());
    }

    @Then("Page	title	and	url	should")
    public void page_title_and_url_should() {
        Assert.assertEquals(ApplicationConstants.LOGIN_PAGE_TITLE, Driver.getDriver().getTitle());
        Assert.assertEquals(ConfigurationReader.getProperty("url"),Driver.getDriver().getCurrentUrl());
    }



    @Then("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),
                            ConfigurationReader.getProperty("password"));

    }

    @Then("user verifies that Dashboards page name is displayed")
    public void user_verifies_that_Dashboards_page_name_is_displayed() {
        Assert.assertEquals(ApplicationConstants.DASHBOARD_PAGE_NAME,pages.homePage().pageName.getText());
    }

    @Then("user verifies that {string} page name is displayed")
    public void user_verifies_that_page_name_is_displayed(String pageName) {
        Assert.assertEquals(pageName,pages.homePage().pageName.getText());
    }


    @When("user logs in as {string}")
    public void userLogsInAs(String userType) {
        ExcelUtil excelUtil =new ExcelUtil("/Users/mehmet_durkan/IdeaProjects/VyTrackCucumber/src/test/resources/externalFiles/Users.xlsx",
                                            "Credentials");
        List<Map<String,String>>dataList= excelUtil.getDataList();
        for(Map<String,String>rowMap:dataList){
            if(userType.equalsIgnoreCase(rowMap.get("User"))) {
                String username = rowMap.get("Username");
                String password = rowMap.get("Password");
                pages.login().login(username,password);
            }
        }



    }
}
