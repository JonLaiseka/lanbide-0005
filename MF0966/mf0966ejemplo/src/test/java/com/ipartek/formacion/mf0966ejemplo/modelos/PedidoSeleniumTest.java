package com.ipartek.formacion.mf0966ejemplo.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class PedidoSeleniumTest {
	@Test
	void guardar() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
        driver.get("http://localhost:8080/mf0966ejemplo/");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement botonCarrito = driver.findElement(By.cssSelector("form[action=carrito]>button"));

        botonCarrito.click();

        List<WebElement> filas = driver.findElements(By.cssSelector("tbody>tr"));
        
        assertEquals(1, filas.size());
        
        WebElement td = filas.get(0).findElement(By.cssSelector(".dataTables_empty"));
        
        String mensaje = td.getText();
        assertEquals("Ningún dato disponible en esta tabla", mensaje);

        driver.quit();
    }

}
