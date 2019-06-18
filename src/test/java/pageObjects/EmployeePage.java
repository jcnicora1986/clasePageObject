package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "name")
    WebElement inputName;

    @FindBy(how = How.ID, using = "address")
    WebElement inputAddress;

    @FindBy(how = How.CSS, using = "[placeholder='City']")
    WebElement inputCity;

    @FindBy(how = How.ID, using = "state")
    WebElement inputState;

    @FindBy(how = How.ID, using = "postcode")
    WebElement inputPostCode;

    @FindBy(how = How.ID, using = "email")
    WebElement inputEmail;

    @FindBy(how = How.ID, using = "phoneNumber")
    WebElement inputPhoneNumber;

    @FindBy(how = How.ID, using = "addButton")
    WebElement clickAdd;

    @FindBy(how = How.TAG_NAME, using = "h4")
    WebElement textoPagina;

    public EmployeePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmployed(String name, String address, String city, String state, String postcode, String email, String phoneNumber){

        inputName.sendKeys(name);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
        inputState.sendKeys(state);
        inputPostCode.sendKeys(postcode);
        inputEmail.sendKeys(email);
        inputPhoneNumber.sendKeys(phoneNumber);


        clickAdd.click();


    }

    public boolean textoPaginaIsDisplayed(){
        return textoPagina.isDisplayed();
    }

    public boolean textoPaginaContainsText(String text){
        return textoPagina.getText().contains(text);
    }
}
