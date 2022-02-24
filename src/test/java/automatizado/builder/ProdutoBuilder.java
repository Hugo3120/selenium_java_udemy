package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {
    
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "23/02/2022";

    private ControleDeProdutoPO controleDeProdutoPO;

    //**Construtor do ProdutoBuilder que recebe a pagina de controle de produtos */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }
    /**
     * Metodo que sabe adicionar um codigo ao builder.
     * @param codigo Código que será adicionado.
     * @return Retorna  própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adcionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
     /**
     * Metodo que sabe adicionar um nome ao builder.
     * @param nome Nome que será adicionado.
     * @return Retorna  própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adcionarNome(String nome){
        this.nome = nome;
        return this;
    }
     /**
     * Metodo que sabe adicionar uma quantidade ao builder.
     * @param quantidade Quantidade que será adicionado.
     * @return Retorna  própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adcionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
     /**
     * Metodo que sabe adicionar um valor ao builder.
     * @param valor Valor que será adicionado.
     * @return Retorna  própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adcionarValor(Double valor){
        this.valor = valor;
        return this;
    }
     /**
     * Metodo que sabe adicionar uma Data ao builder.
     * @param data Código que será adicionado.
     * @return Retorna  própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adcionarData(String data){
        this.data = data;
        return this;
    }
    /**
     * Metodo que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto.
     */
    public void builder(){

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
        controleDeProdutoPO.buttonSalvar.click();

    }
    
}
