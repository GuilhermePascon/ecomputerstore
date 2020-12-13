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

public class Estoque {
    
    private static quantEstoque = 0;
    
    private ArrayList<Integer> estoqueProdutos;
    private ArrayList<Produto> produtos;

    public Estoque(){
        this.estoqueProdutos = new ArrayList<Integer>;
        this.produtos = new ArrayList<Produto>; 
    }
    
    public static ArrayList<Integer> getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public static void setEstoqueProdutos(ArrayList<Integer> estoqueProdutos) {
        Estoque.estoqueProdutos = estoqueProdutos;
    }
}
