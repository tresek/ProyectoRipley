package pages;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import utils.Excel;

public class WD {

	protected static final String CUR_DIR = System.getProperty("user.dir");
	
	public final static String BROWSER = System.getProperty("BROWSER", "chrome");
	
	public static WebDriver driver;
	
	public static WebDriver setupDriver() {
		try {
			if (BROWSER.equals("chrome")) {
		        driver = null;
		        ChromeOptions options = new ChromeOptions();
		        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		        DesiredCapabilities cap = DesiredCapabilities.chrome();
		        String path2 = CUR_DIR + "\\Drivers\\Chrome\\chromedriver.exe";
		        String downloadDefaultDirectory = CUR_DIR + "\\Datapool\\";
		        System.setProperty("webdriver.chrome.driver", path2);
		        chromePrefs.put("download.default_directory", downloadDefaultDirectory);
		        options.setExperimentalOption("prefs", chromePrefs);
		        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		        cap.setCapability(ChromeOptions.CAPABILITY, options);
		        driver = new ChromeDriver(cap);
		        return driver;
	        } else {
	        	System.out.println("Tipo de Browser No Soportado");
	        }
	    } catch (Exception ex) {
	      System.out.println("Error al ejecutar el Driver: " + ex.toString());
	    }
	    return null;
	}
	
	public static void takeScreenShotTest(WebDriver driver, String imageName) {
		String curDir = System.getProperty("user.dir");
	    File directory = new File(curDir + "/imagenes/" + BROWSER);
	    try {
	    	if (directory.isDirectory()) {
		        // Toma la captura de imagen
		        File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        // Mueve el archivo a la carga especificada con el respectivo
		        // nombre
		        FileUtils.copyFile(imagen,
	            new File(directory.getAbsolutePath() + "\\" + imageName + ".png"));
		    } else {
		        // Se lanza la excepcion cuando no encuentre el directorio
		        throw new IOException("ERROR : La ruta especificada no es un directorio!");
	        }
	    } catch (IOException e) {
	    	// Impresion de Excepciones
	    	e.printStackTrace();
	    }
	}
	
	

	
	public static void closeDriver() {
		driver.close();
	}
}
