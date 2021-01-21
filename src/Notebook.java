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
    private float valorfrete;

    public Notebook(ArrayList<PecasEnum> listaPecas, String descricao, String dimensao, float custo, float margemLucro,float valorfrete) {
        super(descricao, dimensao, custo, margemLucro);
        this.listaPecas = listaPecas;
        this.valorfrete = valorfrete;

    }

    public Notebook(Estoque estoque, int quant, String descricao, String dimensao, float custo, float margemLucro) {
        super(estoque, quant, descricao, dimensao, custo, margemLucro);
    }

    public ArrayList<PecasEnum> getListaPecas() {
        return listaPecas;
    }
    public float getValorfrete(){ return  valorfrete;}

    public void setListaPecas(ArrayList<PecasEnum> listaPecas) {
        this.listaPecas = listaPecas;
    }
    public void setValorfrete(float valorfrete){this.valorfrete= valorfrete;}

    public float valorcomfrete(){                                               // Se o custo do produto for menor que 2000 o valor com frete fica mais auto
        if (custo < 2000) {
            return (float) (((custo * margemLucro) + valorfrete) * 1.2);
        } else
            return (custo*margemLucro)+valorfrete;

    }


    @Override
    public String toString() {
        return super.toString() +
                "Notebook{" +
                "listaPecas=" + listaPecas +
                "valorfrete=" + valorfrete +
                '}';
    }
}