package com.vytrack.step_definitions.oracleDB;

import com.vytrack.utilities.ConfigurationReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OracleAPI_StepDefs {

    RequestSpecification request;
    Response response;
    Map responseMap;
    Map reqEmployee;
    Map<String,Object>reqJob;


    @Given("Content type and Accept type is JSON")
    public void contentTypeAndAcceptTypeIsJSON() {



        request=given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON);

    }

    @When("I post a new employee with <{double}> id")
    public void iPostANewEmployeeWithId(double id) {
        reqEmployee = new HashMap();

        reqEmployee.put("employee_id", id);
        reqEmployee.put("first_name", "Mehmet");
        reqEmployee.put("last_name", "D");
        reqEmployee.put("email", "MD"+id);
        reqEmployee.put("phone_number", "515.123.4567");
        reqEmployee.put("hire_date", "2019-08-20T04:00:00Z");
        reqEmployee.put("job_id", "IT_PROG");
        reqEmployee.put("salary", 100000.0);
        reqEmployee.put("commission_pct", null);
        reqEmployee.put("manager_id", null);
        reqEmployee.put("department_id", 90.0);

        response = request.given().body(reqEmployee)
                        .and().post(ConfigurationReader.getProperty("hrapp_baseresturl") + "employees/");

    }

    @Then("Status code is <{int}>")
    public void statusCodeIs(int code) {
        Assert.assertEquals(response.statusCode(), code);

    }

    @And("Response JSON should contain employee info")
    public void responseJSONShouldContainEmployeeInfo() {
        responseMap = response.body().as(Map.class);
        for (Object key : reqEmployee.keySet()) {
            Assert.assertEquals(reqEmployee.get(key), responseMap.get(key));
        }
    }

    @When("I send a GET request with <{double}> id")
    public void iSendAGETRequestWithId(double employee_Id) {
        response = given().accept(ContentType.JSON)
                .and().get(ConfigurationReader.getProperty("hrapp_baseresturl") + "employees/"+employee_Id);


    }

    @And("employee JSON response Data should match the posted JSON data")
    public void employeeJSONResponseDataShouldMatchThePostedJSONData() {
        responseMap = response.body().as(Map.class);
        for (Object key : reqEmployee.keySet()) {
            Assert.assertEquals(reqEmployee.get(key), responseMap.get(key));
        }
    }



    @And("Response JSON should contain department info")
    public void responseJSONShouldContainDepartmentInfo() {
        responseMap=response.body().as(Map.class);
        for(Object key:reqEmployee.keySet()){
            Assert.assertEquals(reqEmployee.get(key),responseMap.get(key));

        }


    }

    @When("I send a get request with <{int}> department id")
    public void iSendAGetRequestWithDepartmentId(int id) {
        response=given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hrapp_baseresturl") + "departments/"+id);
    }

    @And("Department JSON response Data should match the posted JSON data")
    public void departmentJSONResponseDataShouldMatchThePostedJSONData() {
        responseMap=response.body().as(Map.class);
        for(Object key:reqEmployee.keySet()){
            Assert.assertEquals(reqEmployee.get(key),responseMap.get(key));

        }

    }

    @When("I post a new department with id <{int}>")
    public void iPostANewDepartmentWithId(int id) {
        reqEmployee = new HashMap();
        reqEmployee.put("department_id", id);
        reqEmployee.put("department_name", "Group28");
        reqEmployee.put("manager_id", 1111.0);
        reqEmployee.put("location_id", 2000.0);

        response=request.given().body(reqEmployee)
                .and().post(ConfigurationReader.getProperty("hrapp_baseresturl") + "departments/");

    }

    @When("I post a new job with id {string}")
    public void iPostANewJobWithId(String id) {

        /*
        "job_id": "HR_REP",
            "job_title": "Human Resources Representative",
            "min_salary": 4000,
            "max_salary": 9000,
        */
        reqJob=new HashMap<>();
        reqJob.put("job_id",id);
        reqJob.put("job_title","Software Engineer in Test");
        reqJob.put("min_salary",6000.0);
        reqJob.put("max_salary",9000.0);




        response=request.and().body(reqJob).post(ConfigurationReader.getProperty("hrapp_baseresturl")+"jobs/");


    }

    @And("Response JSON should contain job info")
    public void responseJSONShouldContainJobInfo() {
        responseMap=response.body().as(Map.class);
        for (Object key:reqJob.keySet())
            Assert.assertEquals(reqJob.get(key),responseMap.get(key));


    }

    @When("I send a GET request with {string} id")
    public void iSendAGETRequestWithId(String id) {
        response=given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hrapp_baseresturl")+"jobs/"+id);

    }

    @And("Job JSON response Data should match the posted JSON data")
    public void jobJSONResponseDataShouldMatchThePostedJSONData() {
        responseMap=response.body().as(Map.class);
        for(Object key:reqJob.keySet())
            Assert.assertEquals(reqJob.get(key),responseMap.get(key));


    }

    @When("I post a new department with name {string}")
    public void iPostANewDepartmentWithName(String name) {
        reqEmployee = new HashMap();
        reqEmployee.put("department_id", 4);
        reqEmployee.put("department_name",name );
        reqEmployee.put("manager_id", 100.0);
        reqEmployee.put("location_id", 1800.0);

        response=request.given().body(reqEmployee)
                .and().post(ConfigurationReader.getProperty("hrapp_baseresturl") + "departments/");



    }

    @When("I post a new job with following information")
    public void i_post_a_new_job_with_following_information(Map<String,Object> map) {




        System.out.println(map);

        response=request.when().body(map).post(ConfigurationReader.getProperty("hrapp_baseresturl")+"jobs/");



    }


}
