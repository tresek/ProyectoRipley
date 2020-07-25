package com.automatizacion.ripley;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.CommonObjects;
import pages.WD;
import utils.Endpoints;

public class FlujoRipleySteps {

	private static final Logger LOG = Logger.getLogger(FlujoRipleySteps.class);

	static WebDriver driver;
	static FlujoRipleyObjects inicioPage;
	static CommonObjects commonPage;
	static WebDriverWait wait;
	String name = "freddy";
	String segName = "alexis";
	String apellido = "escobar";
	String id;

	public FlujoRipleySteps() throws Throwable {
		if (driver == null) {
			driver = WD.setupDriver();
			if (WD.BROWSER != "chrome") {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
			inicioPage = new FlujoRipleyObjects(driver);
			commonPage = new CommonObjects(driver);
			driver.get(Endpoints.RIPLEY);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 2);

		}
	}

	@Given("Se ingresa a sitio Orange HRM$")
	public void se_ingresa_a_sitio_orange_hrm() throws Throwable {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonLogin()));
			inicioPage.clickButtonLogin();
			waitSeconds(driver, 4);

		} catch (Exception e) {
			LOG.warn("No se encuenta la opcion", e);
		}
	}

	@And("Click menu pim$")
	public void click_menu_pim() throws Throwable {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonPim()));
			inicioPage.clickButtonPim();
			waitSeconds(driver, 4);

		} catch (Exception e) {
			LOG.warn("No se encuenta la opcion", e);
		}
	}

	@And("Click add employee$")
	public void click_add_employee() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getListaEmpleado()));
		inicioPage.clickListaEmpleado();
		waitSeconds(driver, 4);
		String expectResult = "1002";
		String resultado = null;
		waitSeconds(driver, 4);

		for (int i = 0; i < inicioPage.sizeListaIdCliente(); i++) {
			resultado = inicioPage.getIdCliente(i).getText();
			System.out.println(inicioPage.getIdCliente(i).getText());

			if (inicioPage.getIdCliente(i).getText().equals(expectResult)) {
				Assert.assertEquals(resultado, expectResult, "El dato se encuentra");
				break;
			}

		}

		Assert.assertEquals(resultado, expectResult, "EL dato NO se encuentra");

		
		
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonAddEmployee()));
//			inicioPage.clickButtonAddEmployee();
//			waitSeconds(driver, 4);
//
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}

	}

	// *********Creacion de Usuario ***************
//	@And("Click crear employee$")
//	public void click_crear_employee() throws Throwable {
//		driver.switchTo().parentFrame();
//		// driver.switchTo().defaultContent();
//
//		
//		try {
//			waitSeconds(driver, 2);
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputFirstName()));
//			inicioPage.getInputFirstName().sendKeys(name);
//			waitSeconds(driver, 4);
//
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputMiddleName()));
//			inicioPage.getInputMiddleName().sendKeys(segName);
//			waitSeconds(driver, 4);
//
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getlastName()));
//			inicioPage.getlastName().sendKeys(apellido);
//			waitSeconds(driver, 4);
//
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//		
//		id = inicioPage.getemployeeId().getAttribute("value");
//		System.out.println("Id del cliente--->" + id);
//
//		try {
//
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputLocation()));
//			inicioPage.getInputLocation().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonNext()));
//			inicioPage.clickButtonNext();
//			waitSeconds(driver, 6);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputBloodGroup()));
//			inicioPage.getInputBloodGroup().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputHobbies()));
//			inicioPage.getInputHobbies().sendKeys("musica");
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonNextDetail()));
//			inicioPage.clickButtonNextDetail();
//			waitSeconds(driver, 8);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputRegion()));
//			inicioPage.getInputRegion().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitSeconds(driver, 2);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputFte()));
//			inicioPage.getInputFte().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitSeconds(driver, 2);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputTemDepart()));
//			inicioPage.getInputTemDepart().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitSeconds(driver, 2);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonSave()));
//			inicioPage.clickButtonSave();
//			waitSeconds(driver, 6);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//	}
//
//	@And("Click menu employee list$")
//	public void click_menu_employee_list() throws Throwable {
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getButtonEmpList()));
//			inicioPage.clickButtonEmpList();
//			driver.navigate().refresh();
//			waitSeconds(driver, 8);
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//	}
//
//	@Then("busca y valida user$")
//	public void busca_y_valida_user() throws Throwable {
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputSearch()));
//			inicioPage.getInputSearch().sendKeys(id);
//			waitSeconds(driver, 8);
//			String idEsperado = inicioPage.getIdEsperado().getAttribute("value");
//			System.out.println("Id del cliente--->" + idEsperado);
//			Assert.assertEquals(id, idEsperado);
//			waitSeconds(driver, 8);
//			driver.quit();
//		} catch (Exception e) {
//			LOG.warn("No se encuenta la opcion", e);
//		}
//
//	}
//
	public void waitSeconds(WebDriver driver, int seconds) {
		synchronized (driver) {
			try {
				driver.wait(seconds * 2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
