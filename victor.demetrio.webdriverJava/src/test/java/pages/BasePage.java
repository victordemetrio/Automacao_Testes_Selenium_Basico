package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarTextoToast(){
        //WebElement mensagemPopValidacao = navegador.findElement(By.id("toast-container"));
        //String mensagemPop = mensagemPopValidacao.getText();
        return navegador.findElement(By.id("toast-container")).getText();
    }
}
