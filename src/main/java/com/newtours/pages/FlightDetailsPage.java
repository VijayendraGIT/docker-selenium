package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passangers;

    @FindBy(name = "findFlights")
    private WebElement submitButton;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassangers(String noOfPassangers){
        this.wait.until(ExpectedConditions.elementToBeClickable(passangers));
        System.out.println("Passangers = "+ noOfPassangers);
        Select select = new Select(passangers);
        select.selectByValue(noOfPassangers);

    }

    public void goToFindFlightsPage(){
        this.submitButton.click();
    }


}
