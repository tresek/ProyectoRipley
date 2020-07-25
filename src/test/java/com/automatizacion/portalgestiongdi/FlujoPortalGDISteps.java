package com.automatizacion.portalgestiongdi;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.CommonObjects;
import pages.WD;
import utils.Endpoints;

import utils.UtilTest;

public class FlujoPortalGDISteps {

	private static final Logger LOG = Logger.getLogger(FlujoPortalGDISteps.class);

	static WebDriver driver;
	static FlujoPortalGDIObjects inicioPage;
	static CommonObjects commonPage;

	private UtilTest utilTest;
	static List<List<String>> excelUser;
	static WebDriverWait wait;

	static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	Date date = new Date();
	String date1 = dateFormat.format(date);
	static String nuevoNombre = new String("");
	static String folioPr = new String("");

	public FlujoPortalGDISteps() throws Throwable {
		utilTest = new UtilTest();
	
		if (driver == null) {
			driver = WD.setupDriver();
			if (WD.BROWSER != "chrome") {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
			inicioPage = new FlujoPortalGDIObjects(driver);
			commonPage = new CommonObjects(driver);
			
			//HOME es la URL a testear y se cambia en la clase Endpoints
		
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 2);
			//este metodo solo se ocupa en el caso de testear o iniar sesion en un sitio
			inicioSesion();

		}
	}
	
	
	//siempre los metodos deben ser iguales a los escenarios que estan en la clase .feature
	
	@Given("^Se ingresa a sitio gdi$")
    public void se_ingresa_a_sitio_gdi() throws Throwable {
		System.out.println("Ingreso OK");
		waitSeconds(driver,2 );        	
		//WD.closeDriver();
         
    }

	 @And("^Se ingresa rut usuario$")
	    public void se_ingresa_rut_usuario() throws Throwable {
	       
	    }

	    @And("^Se ingresa clave$")
	    public void se_ingresa_clave() throws Throwable {
	       
	    }

	    @And("^se hace click en boton Ingresar$")
	    public void se_click_en_boton_ingresar() throws Throwable {
	        
	    } 
	    
	    
	    
	    @And("^se hace click en menú Gestion Operativa$")
	    public void se_hace_click_en_men_gestion_operativa() throws Throwable {	    	
	    	try {
	    		driver.switchTo().frame(1);
				wait.until(ExpectedConditions.visibilityOf(inicioPage.getGestiónOperativa()));
				inicioPage.clickGestiónOperativa();
			} catch (Exception e) {
			    LOG.warn("No se encuentra opción", e);				
			    waitSeconds(driver,2);
			}
		} 
	    	
	    @And("^se hace click en submenú Historico transacciones$")
	    public void se_hace_click_en_submen_historico_transacciones() throws Throwable {
	    	waitSeconds(driver,2);
	    	wait.until(ExpectedConditions.visibilityOf(inicioPage.getHistóricodeTransacciones()));
			inicioPage.clickHistóricodeTransacciones();
			waitSeconds(driver,3);
	    }

	    @And("^se hace click en Combobox Recaudador$")
	    public void se_hace_click_en_combobox_recaudador() throws Throwable {
	    	
	    	try {

	    	wait.until(ExpectedConditions.elementToBeClickable(inicioPage.getInputLocation()));
	    	inicioPage.getInputLocation().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

	    	} catch (Exception e) {
	    	LOG.warn("No se encuenta la opcion", e);
	    		
	    		
	    	}	

    		waitSeconds(driver,5);
	    }
	    
	    

	    
	
		
	
		public void waitSeconds(WebDriver driver, int seconds) {
		synchronized (driver) {
			try {
				driver.wait(seconds * 2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void inicioSesion() {
		//driver.switchTo().frame("bpm");
		//para utilizar este metodo se deben hacer los cambios en la clase CommonObjetcts
		wait.until(ExpectedConditions.visibilityOf(commonPage.getInputUserName()));
		commonPage.getInputUserName().sendKeys(excelUser.get(utilTest.getIdExcel("ActiveDirectory", excelUser)).get(0));
		commonPage.getInputPassword().sendKeys(excelUser.get(utilTest.getIdExcel("ActiveDirectory", excelUser)).get(1));
		commonPage.clickButtonLogin();
	}
	
	
	
}
