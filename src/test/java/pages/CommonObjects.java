package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonObjects {

WebDriver driver;

public CommonObjects(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

public WebDriver getDriver() {
   return driver;
   
//es una clase donde se almacenan los xpath de login    
}

@FindBy(how = How.XPATH, using = "//*[@id=\"docUsuariotmp\"]")
private WebElement inputUserName;

public WebElement getInputUserName() {
return inputUserName;
}

@FindBy(how = How.XPATH, using = "//*[@id=\"password1\"]")
private WebElement inputPassword;

public WebElement getInputPassword() {
return inputPassword;
}


@FindBy(how = How.XPATH, using = "//*[@id=\"formulario\"]/table/tbody/tr/td/input[3]")
private WebElement buttonLoging;

public void clickButtonLogin() {
this.buttonLoging.click();
}


}