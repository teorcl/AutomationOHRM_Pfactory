package co.com.sofka.page.orangerecruitmentvacancies;
import co.com.sofka.model.orangerecruitmentvacancies.LoginModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Login extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(Login.class);
    private LoginModel loginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    @FindBy(id = "txtUsername")
    @CacheLookup
    private WebElement user;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement btnLogin;

    public Login(WebDriver driver, LoginModel loginModel) {
        super(driver);
        pageFactoryInitElement(driver,this);
        this.loginModel = loginModel;
    }

    public Login(WebDriver driver, LoginModel loginModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver,this);
        if(loginModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.loginModel = loginModel;
    }

    public void fillFieldsLogin() throws IOException {
        try{

            scrollTo(user);
            withExplicitWaitClear(user);
            withExplicitWaitTypeInto(user, loginModel.getUser());

            scrollTo(password);
            withExplicitWaitClear(password);
            withExplicitWaitTypeInto(password, loginModel.getPassword());

            scrollTo(btnLogin);
            clickOn(btnLogin);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

}