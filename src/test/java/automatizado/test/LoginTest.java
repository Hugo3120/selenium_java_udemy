package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    // private void executarAcaoDeLogar(String email, String senha){

    //    loginPage.escrever(loginPage.inputEmail, email);
    //    loginPage.escrever(loginPage.inputSenha,  senha);
        
    //     loginPage.buttonEntrar.click();
   // }

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);

    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {

       loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoSenhaVazia() {

        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {

       loginPage.executarAcaoDeLogar("", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }  

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta() {

       loginPage.executarAcaoDeLogar("Aadmin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }  
    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta() {

       loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }  
    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta() {

       loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }  
    @Test
    public void TC007_DeveLogarNoSistemaComEmailESenhaCorretos() {

       loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }  




}
