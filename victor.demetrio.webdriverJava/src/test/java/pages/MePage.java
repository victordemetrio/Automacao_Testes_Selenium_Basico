package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage{


    public MePage(WebDriver navegador) {
        super(navegador);
    }
    public MePage clicarNaAbaMoreDataAboutYou(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }
    public AddContactPage clicarBotaoAddMoreData(){
        navegador.findElement(By.xpath("//button[@class='waves-effect waves-light red darken-2 btn modal-trigger']")).click();
        return new AddContactPage(navegador);
    }
}
