package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testAdicionarUmaInformacaoAdicionalDoUsuario.csv")

public class InformcaoUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createbrowserstack();
    }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name = "login")String login,
            @Param(name = "senha")String senha,
            @Param(name = "tipo")String tipo,
            @Param(name = "contato")String contato,
            @Param(name = "mensagem")String mensagemEsperada
    ){
        String textoToast = new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin(login,senha)
                .clicarEmMe()
                .clicarNaAbaMoreDataAboutYou()
                .clicarNaAbaMoreDataAboutYou()
                .clicarBotaoAddMoreData()
                .adicionarContato(tipo,contato)
                .capturarTextoToast();

        assertEquals(mensagemEsperada,textoToast);
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
