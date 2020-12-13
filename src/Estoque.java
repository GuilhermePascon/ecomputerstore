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
    private ArrayList<Integer> estoqueProdutos;
    private ArrayList<Produto> produtos;

    /* Construtor */
    public Estoque(int id){
        this.id = id;
        this.estoqueProdutos = new ArrayList<Integer>;
        this.produtos = new ArrayList<Produto>; 
    }
    
    /* Metodos */
    public boolean addProdutoEstoque(Produto produto, Estoque estoque){
        if(!(estoque.getProdutos().contains(produto))){
            estoque.getProdutos().add(produto);
            return true;
        }
        else
            return false;
    }
    public boolean removeProdutoEstoque(Produto produto, Estoque estoque){
        if(estoque.getProdutos().contains(produto)){
            estoque.getProdutos().remove(produto);
            return true;
        }
        else
            return false;
    }
    
    
    public boolean addQuantEstoque(int quant, Produto produto, Estoque estoque){
        if(estoque.getProdutos.contains(produto)){
            estoque.getEstoqueProdutos().get(produto.getId()) += quant;
            return true;
         }
         else
            return false;
    }
    public boolean removeQuantEstoque(int quant, Produto produto, Estoque estoque){
        if(estoque.getProdutos.contains(produto)){
            if(estoque.getEstoqueProdutos().get(produto.getId()) >= quant){
                estoque.getEstoqueProdutos().get(produto.getId()) -= quant;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    /* Getters e Setters */
    public ArrayList<Integer> getEstoqueProdutos() {
        return estoqueProdutos;
    }
    public void setEstoqueProdutos(ArrayList<Integer> estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    private void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
