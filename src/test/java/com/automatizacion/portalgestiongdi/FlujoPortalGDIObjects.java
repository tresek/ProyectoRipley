package com.automatizacion.portalgestiongdi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlujoPortalGDIObjects {

	WebDriver driver;

	public FlujoPortalGDIObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}
		
	//estructura Page factory locators
		
	//declarar atributo de webelement
	@FindBy(how = How.XPATH, using = "//a[contains(text(),\'Gestión Operativa HR\')]")
	private WebElement GestiónOperativa;
	

	//creancion de metodo getter
	public WebElement getGestiónOperativa() {
		return GestiónOperativa;
	}

	//creacion de metodo setter
	public void clickGestiónOperativa() {
		this.GestiónOperativa.click();
		
	}
	
	@FindBy(how = How.XPATH, using = " /html/body/ul/ul[4]/li[1]/a")
	private WebElement  HistóricodeTransacciones;
	
	//creancion de metodo getter
	public WebElement getHistóricodeTransacciones() {
		return HistóricodeTransacciones;
		}

	//creacion de metodo setter
	public void clickHistóricodeTransacciones() {
		this.HistóricodeTransacciones.click();
	
		}
	
	@FindBy(how = How.XPATH, using = "//*[@id='idRec']")
	private WebElement inputLocation;

	public WebElement getInputLocation() {
	return inputLocation;
	

  }
	
	
	
	
	
	
}