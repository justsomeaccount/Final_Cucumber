package com.vytrack.step_definitions.oracleDB;

import com.vytrack.utilities.DBUtility;
import cucumber.api.java.en.*;
import org.junit.Assert;

import java.util.*;

public class OracleDB_StepDefs {
List<Map<String,Object>>data;



    @Given("User gets connection to {string} database")
    public void user_gets_connection_to_database(String DBType) {

        DBUtility.establishConnection(DBType);


            }

    @When("User runs the SQL query {string}")
    public void user_runs_the_SQL_query(String query) {
        data=DBUtility.runSQLQuery(query);
    }




    @Then("Verify if {string} has {string} value on DB")
    public void verifyIfHasValueOnDB(String columnName, String value) {

        boolean isVerified=false;
        for(Map<String,Object>rowMap:data){


                    if(rowMap.get(columnName).equals(value)) {isVerified=true;break;};


        }
        Assert.assertTrue(isVerified);

    }

    @And("Close DB connections")
    public void closeDBConnections() {
        DBUtility.closeConnections();
    }
}
