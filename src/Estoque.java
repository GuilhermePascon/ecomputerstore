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

/*----- Classe Estoque -----*/
/* Objetivo: */
/*--------------------------*/
public class Estoque {
    
    private static quantEstoque = 0;
    
    private int idEstoque;
    private ArrayList<Integer> quantProdutos;
    private ArrayList<Produto> produtos;

    /* Construtor */
    public Estoque(int id){
        quantEstoque++;
        
        this.id = id;
        this.quantProdutos = new ArrayList<Integer>;
        this.produtos = new ArrayList<Produto>; 
    }
    
    /* Metodos */
    public int addProdutoEstoque(Produto produto){ // retorna o ID do produto nesse Estoque
        boolean status;
        
        if(!(this.getProdutos().contains(produto))){
            this.getProdutos().add(produto);
            for(int i : this.getProdutos()){
                if(this.getProdutos().get(i) == produto)
                    return i;
            }
        }
        else{
            status = this.addQuantEstoque(1, produto);
            for(int j : this.getProdutos()){
                if(this.getProdutos().get(j) == produto)
                    return j;
            }
        }
    }
    public boolean removeProdutoEstoque(Produto produto){
        if(this.estoque.getProdutos().contains(produto)){
            this.getQuantProdutos().get(produto.getId()) = 0;
            this.getProdutos().remove(produto);
            return true;
        }
        else
            return false;
    }
    
    public boolean addQuantEstoque(int quant, Produto produto){
        if(this.getProdutos.contains(produto)){
            this.getQuantProdutos().get(produto.getId()) += quant;
            return true;
         }
         else
            return false;
    }
    public boolean removeQuantEstoque(int quant, Produto produto){
        if(this.getProdutos.contains(produto)){
            if(this.getQuantProdutos().get(produto.getId()) >= quant){
                this.getQuantProdutos().get(produto.getId()) -= quant;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    /* Getters e Setters */
    public ArrayList<Integer> getQuantProdutos() {
        return estoqueProdutos;
    }
    private void setQuantProdutos(ArrayList<Integer> estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    private void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
