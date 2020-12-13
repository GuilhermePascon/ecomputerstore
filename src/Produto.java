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

    /*Contrutor Produto Avulso*/
    public Produto(String descricao, String dimensao, float custo, float margemLucro) {

        quantTotalProduto++;
        
        this.id = -1;
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.custo = custo;
        this.margemLucro = margemLucro;
    }
    /*Contrutor Novo Cadastro de Produto*/
    public Produto(Estoque estoque, int quant, String descricao, String dimensao, float custo, float margemLucro) {
       
        int flag = 0;
        boolean status;
        
        for(int i : estoque.getProdutos()){
            if(descricao == estoque.getProdutos.get(i).getDescricao()){
                flag++;
            }
        }
        
        if(flag == 0){
            quantTotalProduto++;
            
            this.descricao = descricao;
            this.dimensao = dimensao;
            this.custo = custo;
            this.margemLucro = margemLucro;
            
            this.id = estoque.addProdutoEstoque(this);
            status = estoque.addQuantEstoque(quant, this);
        }
        else{
            quantTotalProduto++;
            
            this.descricao = descricao;
            this.dimensao = dimensao;
            this.custo = custo;
            this.margemLucro = margemLucro;
            this.id = -1;
        }
    }
    
    /* Metodos */
    public float getPreco() {
        return custo * margemLucro;
    }

    /* Getters e Setters*/
    public float getCusto() {
        return custo;
    }

    private void setCusto(float custo) {
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    private void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public String getDimensao() {
        return dimensao;
    }

    private void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }
}
