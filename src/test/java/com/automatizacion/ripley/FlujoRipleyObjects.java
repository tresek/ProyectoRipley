package com.automatizacion.ripley;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlujoRipleyObjects {

	WebDriver driver;
	int index = 0;

	public FlujoRipleyObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	// Page factory locators
	@FindBy(how = How.XPATH, using = "//*[@id='btnLogin']")
	private WebElement buttonLogin;

	public WebElement getButtonLogin() {
		return buttonLogin;
	}

	public void clickButtonLogin() {
		this.buttonLogin.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu_pim_viewPimModule']/a/span[2]")
	private WebElement buttonPim;

	public WebElement getButtonPim() {
		return buttonPim;
	}

	public void clickButtonPim() {
		this.buttonPim.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu_pim_addEmployee']/span[2]")
	private WebElement buttonAddEmployee;

	public WebElement getButtonAddEmployee() {
		return buttonAddEmployee;
	}

	public void clickButtonAddEmployee() {
		this.buttonAddEmployee.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='firstName']")
	private WebElement inputFirstName;

	public WebElement getInputFirstName() {
		return inputFirstName;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='middleName']")
	private WebElement inputMiddleName;

	public WebElement getInputMiddleName() {
		return inputMiddleName;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='employeeId']")
	private WebElement employeeId;

	public WebElement getemployeeId() {
		return employeeId;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='lastName']")
	private WebElement lastName;

	public WebElement getlastName() {
		return lastName;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='location_inputfileddiv']/div/input")
	private WebElement inputLocation;

	public WebElement getInputLocation() {
		return inputLocation;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='systemUserSaveBtn']")
	private WebElement buttonNext;

	public WebElement getButtonNext() {
		return buttonNext;
	}

	public void clickButtonNext() {
		this.buttonNext.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='1_inputfileddiv']/div/input")
	private WebElement inputBloodGroup;

	public WebElement getInputBloodGroup() {
		return inputBloodGroup;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='5']")
	private WebElement inputHobbies;

	public WebElement getInputHobbies() {
		return inputHobbies;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='wizard-nav-button-section']/button[2]")
	private WebElement buttonNextDetail;

	public WebElement getButtonNextDetail() {
		return buttonNextDetail;
	}

	public void clickButtonNextDetail() {
		this.buttonNextDetail.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='9_inputfileddiv']/div/input")
	private WebElement inputRegion;

	public WebElement getInputRegion() {
		return inputRegion;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='10_inputfileddiv']/div/input")
	private WebElement inputFte;

	public WebElement getInputFte() {
		return inputFte;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='11_inputfileddiv']/div/input")
	private WebElement inputTemDepart;

	public WebElement getInputTemDepart() {
		return inputTemDepart;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='wizard-nav-button-section']/button[3]")
	private WebElement buttonSave;

	public WebElement getButtonSave() {
		return buttonSave;
	}

	public void clickButtonSave() {
		this.buttonSave.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu_pim_viewEmployeeList']")
	private WebElement buttonEmpList;

	public WebElement getButtonEmpList() {
		return buttonEmpList;
	}

	public void clickButtonEmpList() {
		this.buttonEmpList.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='employee_name_quick_filter_employee_list_value']")
	// *[@id="employee_name_quick_filter_employee_list_value"]
	private WebElement inputSearch;

	public WebElement getInputSearch() {
		return inputSearch;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='employeeListTable']/tbody/tr/td[2]")
	private WebElement idEsperado;

	public WebElement getIdEsperado() {
		return idEsperado;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu_pim_viewEmployeeList']/span[2]")
	private WebElement listaEmpleado;

	public WebElement getListaEmpleado() {
		return listaEmpleado;
	}

	public void clickListaEmpleado() {
		this.listaEmpleado.click();
	}

	//**
	// Forma para recorrer una gilla
	// aqui se recorre una fila TR y no se deben colocar las posiciones, la idea es que a 
	//cada enter se debe cambiar la posicion
	//**
	
	@FindBy(how = How.XPATH, using = "//*[@id='employeeListTable']/tbody/tr/td[2]")
	private List<WebElement> listaIdCliente;

	//Metodo para tomar el contenido en la posicion i
	public WebElement getIdCliente(int index) {
		return listaIdCliente.get(index);
	}
	//Merodo para saber el largo de la columna
	public int sizeListaIdCliente() {
		return listaIdCliente.size();
	}
	//metodo en el caso que se le quiera hacer click
	public void clickListaIdCliente(int index) {
		this.listaIdCliente.get(index).click();
	}

}
