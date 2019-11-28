package com.vytrack.step_definitions.Fleet;

import com.vytrack.utilities.DBType;
import com.vytrack.utilities.DBUtility;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.Map;

public class VehiclesStepDefs {

    Pages pages=new Pages();


    @Then("user creates a car using info:")
    public void user_creates_a_car_using_info(Map<String,String> data) {
/*
      | License Plate | xxxxxx |
      | Driver        | Mehmet |
      | Color         | White  |
      | Vehicle Model | BMW    |
      | Vehicle Make  | 520    |


*/
     pages.vehiclesPage().createCarButton.click();
     pages.vehiclesPage().enterDataFor("License Plate",data.get("License Plate"));
     pages.vehiclesPage().enterDataFor("Driver",data.get("Driver"));
     pages.vehiclesPage().enterDataFor("Color",data.get("Color"));

     pages.vehiclesPage().enterModelMake(data.get("Vehicle Model"),data.get("Vehicle Make"));
        System.out.println();







    }

    @Then("user can verify that new car added to inventory by UI")
    public void user_can_verify_that_new_car_added_to_inventory_by_UI() {

    }

    @Then("user can verify that new car added to DB")
    public void user_can_verify_that_new_car_added_to_DB() {
        //DBUtility.establishConnection(DBType.vytrack);
        //DBUtility.runSQLQuery()


            }


    @And("user can verify that new car added to inventory by {string} {string}")
    public void userCanVerifyThatNewCarAddedToInventoryBy(String filter, String data) {
        pages.homePage().navigateToModule("Fleet","Vehicles");
        pages.vehiclesPage().setManageFilters(filter,data);
        System.out.println();
    }
}
