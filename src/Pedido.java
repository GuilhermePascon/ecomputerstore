/*-----------------MC322---------------*/
/* Projeto: eComputerStore             */
/* Grupo: Angelo H Barbosa      166527 */
/*        Francisco G Pena      234589 */
/*        Guilherme H Pascon    235980 */
/*        Luís Felipe L B Silva 156441 */
/*                                     */
/* Data: dez 2020                      */
/*-------------------------------------*/

import java.util.ArrayList;

/*----- Classe Pedido -----*/

public class Pedido {
    private static int quantPedidos;

    private int id;
    private Cliente cliente;
    private ArrayList<Produto> carrinho;
    private float custoTotal;
    private boolean pedidoFinalizado;

    /* Construtor */
    public Pedido(Cliente cliente, ArrayList<Produto> carrinho) {
        quantPedidos++;
        this.id = getQuantPedido();
        
        this.pedidoFinalizado = false;
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.custoTotal = this.setCustoTotal();
    }

    /* Metodos Estaticos */
    public static int getQuantPedido() {
        return quantPedidos;
    }
    
    /* Metodos */
    public float setCustoTotal() {
        float soma = 0;
        
        for(Produto p : this.getCarrinho()){
            soma += p.getPreco();
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
    private void setCustoT(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public static void aumentaQuantPedidos() {
        quantPedidos++;
    }
    
    public boolean getPedidoFinalizado() {
        return pedidoFinalizado;
    }
    public void setPedidoFinalizado(boolean status) {
        this.pedidoFinalizado = status;
    }
}
