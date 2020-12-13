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

public class Notebook {
    private ArrayList<Produto> listaPecas;

    public Notebook(ArrayList<Produto> listaPecas) {
        this.listaPecas = listaPecas;
    }

    public ArrayList<Produto> getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(ArrayList<Produto> listaPecas) {
        this.listaPecas = listaPecas;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "listaPecas=" + listaPecas +
                '}';
    }
}
