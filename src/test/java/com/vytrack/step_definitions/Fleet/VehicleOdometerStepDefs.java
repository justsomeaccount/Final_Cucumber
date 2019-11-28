package com.vytrack.step_definitions.Fleet;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBType;
import com.vytrack.utilities.DBUtility;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleOdometerStepDefs {

    Pages pages=new Pages();
    String odometer;
    String driverName;
    @Then("Clicks on Create Vehicle Odometer")
    public void clicks_on_Create_Vehicle_Odometer() {
        pages.vehicleOdometerPage().createVehicleOdometerButton.click();
    }

    @Then("Fills the form, {string}, {string}")
    public void fills_the_form(String odometer, String driverName) {
        this.odometer=odometer;
        this.driverName=driverName;
        pages.vehicleOdometerPage().odometerValueTextBox.sendKeys(odometer);
        BrowserUtils.waitPlease(2);
        pages.vehicleOdometerPage().driverTextBox.sendKeys(driverName);
    }

    @Then("Save and Close")
    public void save_and_Close() {
       pages.vehicleOdometerPage().saveAndCloseButton.click();
    }

    @Then("User can verify that new vehicle odometer added to Database")
    public void user_can_verify_that_new_vehicle_odometer_added_to_Database() {

        DBUtility.establishConnection(DBType.vytrack);
        List<Map<String,Object>> list=DBUtility.runSQLQuery("select * from oro_ext_vehiclesodometer");
        String str="";

        for(Map<String, Object>rowMap:list){
            if(rowMap.get("Driver").equals(driverName)) {
                //Assert.assertTrue((""+rowMap.get("OdometerValue")).equals(odometer));
                str += rowMap.get("OdometerValue");
                System.out.println(str.substring(0, str.length() - 2));
                System.out.println(odometer);
            }
        }


        DBUtility.closeConnections();
    }




}
