/*-----------------MC322---------------*/
/* Projeto: eComputerStore             */
/* Grupo: Angelo H Barbosa      166527 */
/*        Franscisco G Pena     234589 */
/*        Guilherme H Pascon    235980 */
/*        Luís Felipe L B Silva 156441 */
/*                                     */
/* Data: dez 2020                      */
/*-------------------------------------*/

import java.util.ArrayList;


/*----- Classe Produto -----*/
/* Objetivo: */
/*--------------------------*/
public class Produto {
    
    private static int quantTotalProduto = 0;
    //private static ArrayList<int> QuantProdutos; // o index no ArrayList corresponde ao ID do Produto, e o valor eh a quantidade
    
    private int id;
    private String descricao;
    private String dimensao; // no formato "AxBxCcm"
    private float custo;
    private float margemLucro;

    /*Contrutor Produto ja Cadastrado*/
    public Produto(int id, String descricao, String dimensao, float custo, float margemLucro) {
        
        quantTotalProduto++;
        
        this.id = id;
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.custo = custo;
        this.margemLucro = margemLucro;
        
        Estoque.getProdutos.get(this.id)++; // Incremento a quant do produto na pos do ID
        
    }
    /*Contrutor Novo Cadastro de Produto*/
    public Produto(String descricao, String dimensao, float custo, float margemLucro) {
       
        for(int i : Estoque.getProdutos()){
            if(descricao == Estoque.getProdutos.get(i).getDescricao)){
                // rotina que impede a construcao do objeto e sai do construtor
            }
        }
        
        quantTotalProduto++;
        
        this.id = Estoque.getIDNovoProduto();
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.custo = custo;
        this.margemLucro = margemLucro;       
    }

    public static ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public static void setProdutos(ArrayList<Produto> produtos) {
        Produtos = produtos;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public float getPreco() {
        return custo * margemLucro;
    }
}
