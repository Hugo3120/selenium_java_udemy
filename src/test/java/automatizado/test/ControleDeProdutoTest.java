package automatizado.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{
    
    private static LoginPO loginPage;
    private  static ControleDeProdutoPO controlleProdutoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controlleProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controlleProdutoPage.obterTituloPagina(),"Controle de Produtos");

    }
    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controlleProdutoPage.buttonAdicionar.click();
        //TODO: Remover esse clique assim que o sistema for corrigido.
        controlleProdutoPage.buttonAdicionar.click();
        String titulo = controlleProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();
    }

  //  @Test
  //  public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
   //     controlleProdutoPage.buttonAdicionar.click();

    //    controlleProdutoPage.cadastrarProduto("00001","Martelo", 10, 59.9, "");
        
    // Aqui vamos capturar a mensagem de erro.
   //     String mensagem = controlleProdutoPage.spanMensagem.getText();
   //     assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
   // }

    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controlleProdutoPage.buttonAdicionar.click();
    
      
        //Aqui cria o objeto para adcionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);
        
        // Aqui estamos testando se o produto e adicionado sem codigo
        produtoBuilder 
        .adcionarCodigo("")
        .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
        
        // Aqui estamos testando se o produto e adicionado sem quantidade
        produtoBuilder
        .adcionarCodigo("00005")
        .adcionarQuantidade(null)
        .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

       // Aqui estamos testando se o produto e adicionado sem nome
        produtoBuilder
        .adcionarNome("")
        .adcionarQuantidade(15)
        .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto e adicionado sem valor
        produtoBuilder
        .adcionarNome("Cimento")
        .adcionarValor(null)
        .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

         // Aqui estamos testando se o produto e adicionado sem data
         produtoBuilder
         .adcionarValor(50.0)
         .adcionarData("")
         .builder();
         assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

         controlleProdutoPage.buttonSair.click();
        

        
    }

    
}
