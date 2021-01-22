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

/*----- Classe Cliente -----*/
public class Cliente {
    private static int quantCliente = 0;
    
    private float saldo;
    private ArrayList<Produto> carrinho;
    private int id;
    private String nome;
    private ArrayList<Pedido> pedidos;

    /* Construtor */
    public Cliente(float saldo, ArrayList<Produto> carrinho, String nome, ArrayList<Pedido> pedidos) {
        quantCliente++;
        this.id = getQuantCliente();
        
        this.saldo = saldo;
        this.carrinho = carrinho;
        this.nome = nome;
        this.pedidos = pedidos;
    }

    /* Metodos Estaticos */
    public static int getQuantCliente() {
        return quantCliente;
    }
    public static void setQuantClient(int quantCliente) {
        Cliente.quantCliente = quantCliente;
    }
    
    
    /* Getters e Setters */
    public float getSaldo() {
        return saldo;
    }
    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String especificarProduto(Produto produto) { // retorna as especificacoes de um produto
        return produto.toString();
    }

    // adiciona ao carrinho do cliente a quantidade passada do produto passado
    public void adicionarAoCarrinho(Produto produto, int qnt) {
        for (int i = 0; i < qnt; i++) {
            this.carrinho.add(produto);
        }
    }

    // remove do carrinho qnt vezes e imprime quantas vezes foi removido, retorna false se nenum foi removido e true se um ou mais foram removidos
    public boolean removerDoCarrinho(Produto produto, int qnt) {
        int qntRemovida = 0;
        for (int i = 0; i < qnt; i++) {
            int index = this.carrinho.indexOf(produto);
            if (index != -1) {
                this.carrinho.remove(produto);
                qntRemovida++;
            }
        }
        if (qntRemovida == 0) {
            System.out.println("O carrinho nao tinha nenhum produto desse tipo para se remover");
            return false;
        } else if (qntRemovida == 1){
            System.out.println("Foi removido um produto desse tipo do carrinho");
            return true;
        } else {
            System.out.println("Foram removidos " + qntRemovida + "  produtos desse tipo do carrinho");
            return true;
        }
    }

    // imprime todos os produtos do carrinho do cliente
    public void verCarrinho() {
        System.out.println("Esses sao os produtos do carrinho de " + this.nome);
        this.carrinho.forEach((p) -> System.out.println(p));
        System.out.println("\n");
    }

    public void esvaziarCarrinho() {
        this.carrinho.clear();
    }

    public void adicionarSaldo(Float valor) { // adiciona um valor ao saldo do cliente
        this.saldo += valor;
    }

    public boolean removerSaldo(Float valor) {
        if (this.saldo - valor < 0) {
            System.out.println("Voce nao tem saldo suficiente para remover o valor de " + valor);
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    // adiciona um pedido a lista de pedidos do cliente
    public void adicionaPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    // remove um pedido a lista de pedidos do cliente e retorna true se conseguir e false se nao
    public boolean removePedido(Pedido pedido) {
        int index = this.pedidos.indexOf(pedido);

        if (index != -1) {
            this.pedidos.remove(pedido);
            return true;
        }

        return false;
    }

    // finaliza o pedido do cliente
    public boolean finalizarCompra(Pedido novoPedido) {
        float precoTotalDoCarrinho = novoPedido.getCustoTotal();
        System.out.println(precoTotalDoCarrinho);

        // checa se a pessoa tem saldo suficiente para finalizar o pedido
        if (this.saldo - precoTotalDoCarrinho < 0) {
            System.out.println("Cliente nao tem saldo suficiente para finalizar esse pedido");
            return false;
        } else {
            // remove o valor total do carrinho do saldo da pessoa
            this.removerSaldo(precoTotalDoCarrinho);

            // adiciona o pedido a lista de pedidos geral
            Comercial.getListaPedidos().add(novoPedido);

            // esvazia o carrinho
            this.esvaziarCarrinho();

            System.out.println("Pedido realizado");
            return true;
        }
    }

    @Override
    public String toString() {
        String out =  "Cliente: " + nome + " " +
                "  Saldo: " + saldo +
                "  Id: " + id + "\n";

        out += "Produtos: \n";

        for(Produto p: this.carrinho) {
            out += p.getDescricao() + "\n";
        }

        out += "Pedidos: \n";

        for(Pedido p: this.pedidos) {
            out += "Pedido de Codigo Numero: " + p.getId() + "\n";
        }

        return out;
    }
}
