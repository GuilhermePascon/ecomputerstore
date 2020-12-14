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

    private static int quantEstoque = 0;
    
    private int id;
    private ArrayList<Integer> quantProdutos;
    private ArrayList<Produto> produtos;

    /* Construtor */
    public Estoque(int id) {
        quantEstoque++;
        
        this.id = id;
        this.quantProdutos = new ArrayList<Integer>();
        this.produtos = new ArrayList<Produto>();
    }
    
    /* Metodos */
    public int addProdutoEstoque(Produto produto) { // retorna o ID do produto nesse Estoque
        boolean status;
        
        if (!(this.getProdutos().contains(produto))) {
            this.getProdutos().add(produto);
            this.getQuantProdutos().add(0);
            for (Produto p : this.getProdutos()){
                if (p == produto) {
                    return p.getId();
                }
            }
        } else {
            status = this.addQuantEstoque(1, produto);
            for(Produto p : this.getProdutos()){
                if(p == produto)
                    return p.getId();
            }
        }

        // nao deve nunca chegar a esse ponto
        return -1;
    }
    
    public boolean addQuantEstoque(int quant, Produto produto){
        if (this.produtos.contains(produto)){
            this.quantProdutos.set(produto.getId(), quant + this.quantProdutos.get(produto.getId()));
            return true;
         } else {
            return false;
        }
    }

    public boolean removeQuantEstoque(int quant, Produto produto){
        if (this.produtos.contains(produto)) {
            if (this.getQuantProdutos().get(produto.getId()) >= quant) {
                this.quantProdutos.set(produto.getId(), quant - this.quantProdutos.get(produto.getId()));
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    /* Getters e Setters */
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    private void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public static int getQuantEstoque() {
        return quantEstoque;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getQuantProdutos() {
        return quantProdutos;
    }

    private void setQuantProdutos(int idProduto, int qnt) {
        this.quantProdutos.set(idProduto, qnt);
    }

    @Override
    public String toString() {
        return "Estoque: " + id +
                "Quantidade de Produtos=" + quantProdutos +
                "Produtos=" + produtos;
    }
}
