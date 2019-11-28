package com.vytrack.step_definitions;

import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.*;

public class HomePageStepDefs {

    Pages pages=new Pages();

    @Then("user navigates to {string} module {string}")
    public void user_navigates_to_module(String tab, String module) {
        pages.homePage().navigateToModule(tab,module);
    }



}
