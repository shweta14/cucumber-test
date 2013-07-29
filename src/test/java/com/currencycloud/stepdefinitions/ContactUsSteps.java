package com.currencycloud.stepdefinitions;

import com.currencycloud.uk.page.HtmlElement;
import com.currencycloud.uk.page.Page;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static com.currencycloud.uk.page.HtmlElement.getElementByName;
import static com.currencycloud.uk.page.Page.getPageByName;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;

/**
 * Created with IntelliJ IDEA.
 * User: Shweta
 * Date: 28/07/13
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
public class ContactUsSteps {
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String FIELD_NAME = "fieldName";
    public static final String TITLE = "title";
    private static WebDriver webDriver;

    @Before
    public void setup() throws Exception {
        webDriver = new ChromeDriver();
    }

    @Given("^I (?:visit|go to) (.*) (?:website|page)$")
    public void I_go_to_page(String pageName) {
        Page page = getPageByName(pageName);
        webDriver.get(page.getPageUrl());
        WebElement title = webDriver.findElement(tagName(TITLE));
        System.out.println(title.getText());
//        assertEquals(page.getPageTitle(), title.getText());
    }


    @When("^I click on (.*) (?:button|element|link)$")
    public void I_click_on_element(String elementName) {
        HtmlElement htmlElement = getElementByName(elementName);
        webDriver.findElement(id(htmlElement.getId())).click();
    }

    @Then("^I see the global error message '(.*)'$")
    public void I_see_the_global_error_message(String message) {
        WebElement validationErrorElement = webDriver.findElement(className("validation_error"));
        Assert.assertEquals(message, validationErrorElement.getText());
    }

    @And("^I see the following field error messages :$")
    public void I_see_the_following_field_error_messages(List<Map<String, String>> fieldMessages) {
        String errorMessage;
        String fieldName;
        for (Map<String, String> fieldMap : fieldMessages) {
            errorMessage = fieldMap.get(ERROR_MESSAGE);
            fieldName = fieldMap.get(FIELD_NAME);
            HtmlElement htmlElement = HtmlElement.getElementByName(fieldName);
            WebElement element = webDriver.findElement(id(htmlElement.getParentId()));
            assertTrue(element.getText().contains(errorMessage));
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}