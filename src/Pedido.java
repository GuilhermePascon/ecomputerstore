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

/*----- Classe Pedido -----*/
/* Objetivo: */
/*--------------------------*/
public class Pedido {
    private static int quantPedido;

    private int id;
    private Cliente cliente;
    private ArrayList<Produto> carrinho;
    private float custoTotal;

    /* Construtor */
    public Pedido(Cliente cliente, ArrayList<Produto> carrinho) {
        quantPedido++;
        this.id = getQuantPedido();
        
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.custoTotal = this.getCustoTotal();
    }

    /* Metodos Estaticos */
    public static int getQuantPedido() {
        return quantPedido;
    }
    private static void setQuantPedido(int quantPedido) {
        this.quantPedido = quantPedido;
    }
    
    /* Metodos */
    public float getCustoTotal(){
        float soma = 0;
        
        for(int i : this.getCarrinho()){
            soma += this.getCarrinho().get(i).getPreco();
        }
        
        return soma;
    }

    /* Getters e Setters */
    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }
    private void setCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public float getCustoTotal() {
        return custoTotal;
    }
    private void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }
}
