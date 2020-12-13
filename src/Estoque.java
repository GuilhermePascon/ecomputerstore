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
    private static ArrayList<Integer> estoqueProdutos;


    public static ArrayList<Integer> getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public static void setEstoqueProdutos(ArrayList<Integer> estoqueProdutos) {
        Estoque.estoqueProdutos = estoqueProdutos;
    }
}
