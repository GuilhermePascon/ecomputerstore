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

public class Notebook extends Produto{

    private ArrayList<PecasEnum> listaPecas;

    public Notebook(String descricao, String dimensao, float custo, float margemLucro) {
        super(descricao, dimensao, custo, margemLucro);
    }
    
    public Notebook(ArrayList<PecasEnum> listaPecas, String descricao, String dimensao, float custo, float margemLucro) {
        super(descricao, dimensao, custo, margemLucro);
        this.listaPecas = listaPecas;
    }

    public Notebook(Estoque estoque, int quant, String descricao, String dimensao, float custo, float margemLucro) {
        super(estoque, quant, descricao, dimensao, custo, margemLucro);
    }

    public ArrayList<PecasEnum> getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(ArrayList<PecasEnum> listaPecas) {
        this.listaPecas = listaPecas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Notebook{" +
                "listaPecas=" + listaPecas +
                '}';
    }
}
