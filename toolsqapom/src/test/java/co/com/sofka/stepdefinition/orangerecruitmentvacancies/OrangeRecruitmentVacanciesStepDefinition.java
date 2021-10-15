package co.com.sofka.stepdefinition.orangerecruitmentvacancies;

import co.com.sofka.model.orangerecruitmentvacancies.LoginModel;
import co.com.sofka.model.orangerecruitmentvacancies.OrangeRecruitmentVacanciesModel;
import co.com.sofka.page.orangerecruitmentvacancies.OrangeRecruitmentVacancies;
import co.com.sofka.page.orangerecruitmentvacancies.Login;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Grade.*;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class OrangeRecruitmentVacanciesStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(OrangeRecruitmentVacanciesStepDefinition.class);

    private LoginModel loginModel;
    private OrangeRecruitmentVacanciesModel orangeRecruitmentVacanciesModel;
    private Login login;
    private OrangeRecruitmentVacancies orangeRecruitmentVacancies;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "No se encontró el archivo";
    private static final String ASSERTION_FILE = "file.txt";

    @Given("el empleado administrativo se encuentra logueado en la web de OrangeHRM")
    public void elEmpleadoAdministrativoSeEncuentraLogueadoEnLaWebDeOrangeHRM() {
        try{
            generalSetUp();
            setAccessData();
            login = new Login(driver, loginModel,TEN_SECONDS.getValue());
            login.fillFieldsLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado quiere crear una nueva vacante")
    public void elEmpleadoQuiereCrearUnaNuevaVacante() {
        try {
            setDataVacancy();
            orangeRecruitmentVacancies = new OrangeRecruitmentVacancies(driver, orangeRecruitmentVacanciesModel,TEN_SECONDS.getValue());
            orangeRecruitmentVacancies.fillFieldsVacancy();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberia mostrar un mensaje Sucessfully saved.")
    public void elSistemaDeberiaMostrarUnMensajeSucessfullySaved() {
        try {
            Assertions.assertEquals(
                    orangeRecruitmentVacancies.isDisplayTableReport(), ASSERTION_FILE,
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }



    private void setAccessData(){
        loginModel = new LoginModel();
        loginModel.setUser("Admin");
        loginModel.setPassword("admin123");

    }

    private void setDataVacancy(){
        orangeRecruitmentVacanciesModel = new OrangeRecruitmentVacanciesModel();
        orangeRecruitmentVacanciesModel.setNombreVacante("---XX--COACH--XX---");
        orangeRecruitmentVacanciesModel.setGerenteDeContratacion("Nina Patel");
        orangeRecruitmentVacanciesModel.setNumeroVacantes("2");
        orangeRecruitmentVacanciesModel.setDescripcion("Ayudar en todas las labores del presidente");
        orangeRecruitmentVacanciesModel.setComentario("Se adjunta archivo .txt");

    }

}
