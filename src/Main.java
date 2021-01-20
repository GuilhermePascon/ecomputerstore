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
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Criando Produtos *****************************************************************\n");

        Produto placaDeVideo = new Peca("Placa de Video", "15x10x3cm", 1230.99f, 30.0f);
        Produto processador = new Peca("Processador", "5x5x0.3cm", 999.99f, 40.0f);
        Produto cooler = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler1 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler2 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler3 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler4 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler5 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler6 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler7 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler8 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);
        Produto cooler9 = new Peca("Cooler", "15x15x5cm", 150.99f, 20.0f);


        System.out.println("Imprimindo Produtos: *****************************************************************\n");

        System.out.println(placaDeVideo);
        System.out.println(processador);
        System.out.println(cooler);

        System.out.println("Criando Clientes*****************************************************************\n");


        Cliente jose = new Cliente(0f, new ArrayList<Produto>(), "Jose Pereira", new ArrayList<Pedido>());

        ArrayList<Produto> listaDeMaria = new ArrayList<Produto>();
        listaDeMaria.add(placaDeVideo);
        listaDeMaria.add(processador);

        Cliente maria = new Cliente(500f, listaDeMaria, "Maria Joaquina", new ArrayList<Pedido>());

        ArrayList<Produto> listaDeJose = new ArrayList<Produto>();
        listaDeJose.add(placaDeVideo);
        listaDeJose.add(processador);

        Cliente carlos = new Cliente(1000f, listaDeJose, "Carlos Almeida", new ArrayList<Pedido>());

        System.out.println("Imprimindo Clientes: *****************************************************************\n");

        System.out.println(jose);
        System.out.println(maria);
        System.out.println(carlos);

        System.out.println("Adicionando Saldo aos Clientes: *****************************************************************\n");

        jose.adicionarSaldo(50000f);
        maria.adicionarSaldo(100000f);
        carlos.adicionarSaldo(25000f);

        System.out.println("Imprimindo Novos Saldos: *****************************************************************\n");

        System.out.println(jose);
        System.out.println(maria);
        System.out.println(carlos);


        System.out.println("Removendo Saldo dos Clientes: *****************************************************************\n");

        jose.removerSaldo(1234f);
        maria.removerSaldo(4321f);
        carlos.removerSaldo(1111f);

        System.out.println("Imprimindo Novos Saldos: *****************************************************************\n");

        System.out.println(jose);
        System.out.println(maria);
        System.out.println(carlos);

        System.out.println("Adicionando Produtos aos Carrinhos dos Clientes: *****************************************************************\n");

        jose.adicionarAoCarrinho(processador, 1);
        maria.adicionarAoCarrinho(cooler, 2);
        carlos.adicionarAoCarrinho(cooler, 3);
        carlos.adicionarAoCarrinho(placaDeVideo, 1);

        System.out.println("Imprimindo somente o Carrinho dos Clientes: *****************************************************************\n");

        jose.verCarrinho();
        maria.verCarrinho();
        carlos.verCarrinho();

        System.out.println("Removendo todos os Coolers do Carrinho de Carlos: *****************************************************************\n");

        carlos.removerDoCarrinho(cooler, 3);
        carlos.verCarrinho();

        System.out.println("Finalizando a compra de Maria: *****************************************************************\n");
        System.out.println("Sera removido o saldo equivalente ao valor da compra, criado um pedido e esvaziado seu carrinho: *****************************************************************\n");

//        maria.finalizarCompra();
        System.out.println(maria);


        System.out.println("Finalizando a compra de Jose: *****************************************************************\n");

//        jose.finalizarCompra();
        System.out.println(jose);

        Estoque estoque = new Estoque(1);
        estoque.addProdutoEstoque(placaDeVideo);
        estoque.addProdutoEstoque(processador);
        estoque.addProdutoEstoque(cooler);
        estoque.addProdutoEstoque(cooler2);
        estoque.addProdutoEstoque(cooler3);



        new JanelaCadastro(estoque);
    }
}
