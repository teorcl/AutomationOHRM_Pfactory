package co.com.sofka.page.orangerecruitmentvacancies;

import co.com.sofka.model.orangerecruitmentvacancies.OrangeRecruitmentVacanciesModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.List;


public class OrangeRecruitmentVacancies extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(OrangeRecruitmentVacancies.class);
    private OrangeRecruitmentVacanciesModel orangeRecruitmentVacanciesModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //Datos no necesarios
    @FindBy(id= "menu_recruitment_viewRecruitmentModule")
    @CacheLookup
    private WebElement recruitmentMenu;

    @FindBy(id = "menu_recruitment_viewJobVacancy")
    @CacheLookup
    private WebElement jobVacancy;

    @FindBy(id = "btnAdd")
    @CacheLookup
    private WebElement btnAdd;


    //Aqui el de la lista desplegable
    @FindBy(id = "addJobVacancy_jobTitle")
    @CacheLookup
    private WebElement jobTitle;

    @FindBy(id = "addJobVacancy_name")
    @CacheLookup
    private WebElement vacancyName;

    @FindBy(id = "addJobVacancy_hiringManager")
    @CacheLookup
    private WebElement hiringManager;

    @FindBy(id = "addJobVacancy_noOfPositions")
    @CacheLookup
    private WebElement numbersOfPositions;

    @FindBy(id = "addJobVacancy_description")
    @CacheLookup
    private WebElement description;


    @FindBy(id = "btnSave")
    @CacheLookup
    private WebElement btnSave;

    @FindBy(id = "btnAddAttachment")
    @CacheLookup
    private WebElement btnAddAttachment;

    @FindBy(id = "recruitmentAttachment_ufile")
    @CacheLookup
    private WebElement btnUploadFile;

    @FindBy(id = "recruitmentAttachment_comment")
    @CacheLookup
    private WebElement comment;


    @FindBy(id = "btnSaveAttachment")
    @CacheLookup
    private WebElement btnSaveAttachment;

    //For Assertions test case.
    @FindBy(xpath = "//*[@id=\"tblAttachments\"]/tbody/tr/td[2]/a")
    @CacheLookup
    private WebElement fileName;

   /* public boolean isAddDone(String file){
        List<WebElement> listaFilas = getResultTable("tblAttachments");
        return validateFileFiltered(listaFilas,file);
    }*/

    public OrangeRecruitmentVacancies(WebDriver driver, OrangeRecruitmentVacanciesModel orangeRecruitmentVacanciesModel) {
        super(driver);
        pageFactoryInitElement(driver,this);
        this.orangeRecruitmentVacanciesModel = orangeRecruitmentVacanciesModel;
    }
    public OrangeRecruitmentVacancies(WebDriver driver, OrangeRecruitmentVacanciesModel orangeRecruitmentVacanciesModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver,this);
        if(orangeRecruitmentVacanciesModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.orangeRecruitmentVacanciesModel = orangeRecruitmentVacanciesModel;
    }


    public void fillFieldsVacancy()throws IOException{
        try{

            withExplicitWaitClickOn(recruitmentMenu);
            withExplicitWaitClickOn(jobVacancy);
            withExplicitWaitClickOn(btnAdd);

            selectDropdownListSeleccionCriteria(jobTitle,"Customer Success Manager");

            scrollTo(vacancyName);
            withExplicitWaitClear(vacancyName);
            withExplicitWaitTypeInto(vacancyName, orangeRecruitmentVacanciesModel.getNombreVacante());
            withExplicitWaitTypeInto(vacancyName, Keys.TAB);

            scrollTo(hiringManager);
            withExplicitWaitClear(hiringManager);
            withExplicitWaitTypeInto(hiringManager, orangeRecruitmentVacanciesModel.getGerenteDeContratacion());
            withExplicitWaitTypeInto(vacancyName, Keys.TAB);

            scrollTo(numbersOfPositions);
            withExplicitWaitClear(numbersOfPositions);
            withExplicitWaitTypeInto(numbersOfPositions, orangeRecruitmentVacanciesModel.getNumeroVacantes());
            withExplicitWaitTypeInto(numbersOfPositions, Keys.TAB);

            scrollTo(description);
            withExplicitWaitClear(description);
            withExplicitWaitTypeInto(description, orangeRecruitmentVacanciesModel.getDescripcion());
            withExplicitWaitTypeInto(description, Keys.TAB);

            withExplicitWaitClickOn(btnSave);

            withExplicitWaitClickOn(btnAddAttachment);

            withExplicitWaitClickOnSendPath(btnUploadFile);

            scrollTo(comment);
            withExplicitWaitClear(comment);
            withExplicitWaitTypeInto(comment, orangeRecruitmentVacanciesModel.getComentario());
            withExplicitWaitTypeInto(comment, Keys.TAB);

            withExplicitWaitClickOn(btnSaveAttachment);

            wait(2000);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public void selectDropdownListSeleccionCriteria(WebElement seleccion, String option) {
        List<WebElement> options =  seleccion.findElements(By.tagName("option"));
        for (int i=0; i<options.size();i++){
            if(getText(options.get(i)).equals(option)) {
                withExplicitWaitClickOn(options.get(i));
            }
        }
    }

    public String isDisplayTableReport() {
        String value = "";
        scrollTo(this.fileName);
        value=getText(this.fileName);
        return value;
    }

   /* public List<WebElement> getResultTable(String idLista){
        WebElement table = findElement(By.id(idLista));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        return allRows;
    }*/

   /* public boolean validateFileFiltered(List<WebElement> allRows, String file){
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if(i==1 && cell.getText().equalsIgnoreCase(file)){
                    return true;
                }
                i++;
            }
        }
        return false;
    }*/

}
