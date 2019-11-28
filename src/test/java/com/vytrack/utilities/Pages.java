package com.vytrack.utilities;

import com.vytrack.pages.ActivitiesPage;
import com.vytrack.pages.Fleet.VehicleOdometerPage;
import com.vytrack.pages.Fleet.VehiclesPage;
import com.vytrack.pages.HomePage;
import com.vytrack.pages.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private HomePage homePage;
    private ActivitiesPage activitiesPage;
    private VehicleOdometerPage vehicleOdometerPage;
    private VehiclesPage vehiclesPage;


    public LoginPage login(){
        if(loginPage==null){

            loginPage=new LoginPage();
        }

        return loginPage;

    }

    public HomePage homePage(){
        if(homePage==null){

            homePage=new HomePage();
        }

        return homePage;

    }

    public ActivitiesPage activitiesPage(){
        if(activitiesPage==null){

            activitiesPage=new ActivitiesPage();
        }

        return activitiesPage;

    }

    public VehicleOdometerPage vehicleOdometerPage(){
        if(vehicleOdometerPage==null){

            vehicleOdometerPage=new VehicleOdometerPage();
        }

        return vehicleOdometerPage;

    }

    public VehiclesPage vehiclesPage(){
        if(vehiclesPage==null){

            vehiclesPage=new VehiclesPage();
        }

        return vehiclesPage;

    }



}
