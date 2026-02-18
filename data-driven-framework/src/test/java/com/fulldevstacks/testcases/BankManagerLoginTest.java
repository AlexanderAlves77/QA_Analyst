package com.fulldevstacks.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.fulldevstacks.base.TestBase;

public class BankManagerLoginTest extends TestBase
{
	@Test
	public void loginAsBankManager() throws InterruptedException 
	{
		log.info("========== INÍCIO DO TESTE ==========");
        
        Assert.assertNotNull(driver, "Driver não foi inicializado!");
        Assert.assertNotNull(OR, "OR Properties não foi carregado!");
        
        // Aguardar Angular carregar
        waitForAngular();
        
        // Login como Bank Manager
        String bankmanagerbtn = OR.getProperty("bankmanagerbtn");
        log.info("Clicando no botão Bank Manager Login: " + bankmanagerbtn);
        
        // Aguardar elemento estar clicável
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bankmanagerbtn)));
        driver.findElement(By.cssSelector(bankmanagerbtn)).click();
        
        // Aguardar navegação do Angular
        Thread.sleep(3000);
        waitForAngular();
        
        // Verificar se o botão Add Customer aparece
        String addCustLocator = OR.getProperty("addcustbtn");
        log.info("Verificando botão Add Customer: " + addCustLocator);
        
        // Aguardar elemento aparecer
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(addCustLocator)));
            log.info("Botão Add Customer encontrado!");
        } catch (Exception e) {
            log.error("Botão Add Customer NÃO encontrado!");
            
            // Debug - listar todos os botões
            log.info("===== TODOS OS BOTÕES NA PÁGINA =====");
            driver.findElements(By.cssSelector("button")).forEach(btn -> {
                log.info("Botão: " + btn.getText() + 
                        " - Visível: " + btn.isDisplayed() +
                        " - Class: " + btn.getAttribute("class") +
                        " - ng-click: " + btn.getAttribute("ng-click"));
            });
            
            // Debug - HTML da página
            String pageSource = driver.getPageSource();
            log.debug("Page source snippet: " + pageSource.substring(0, 500));
        }
        
        boolean isAddCustPresent = isElementPresent(By.cssSelector(addCustLocator));
        Assert.assertTrue(isAddCustPresent, "Login não foi bem-sucedido - Botão Add Customer não encontrado!");
        
        log.info("Login realizado com sucesso!");
        Reporter.log("Login realizado com sucesso!");
        log.info("========== FIM DO TESTE ==========");
	}	
}
