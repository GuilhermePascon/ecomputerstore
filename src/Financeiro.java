/*-----------------MC322---------------*/
/* Projeto: eComputerStore             */
/* Grupo: Angelo H Barbosa      166527 */
/*        Franscisco G Pena     234589 */
/*        Guilherme H Pascon    235980 */
/*        Luís Felipe L B Silva 156441 */
/*                                     */
/* Data: dez 2020                      */
/*-------------------------------------*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Financeiro {
    private static float caixaTotal;


    /* Métodos */
    public float mediaMargem(Estoque estoque){
        Estatistica st = new Estatistica();
        ArrayList<Float> margens = new ArrayList<Float>();
        ArrayList<Produto> p = new ArrayList<Produto>();
        p = estoque.getProdutos();
        for (int i = 0; i < p.size(); i++){
            margens.add(p.get(i).getMargemLucro());
        }
        return st.media(margens);
    }

    /* Getter e Setter */
    public static float getCaixaTotal() {
        return caixaTotal;
    }

    public static void setCaixaTotal(float caixaTotal) {
        Financeiro.caixaTotal = caixaTotal;
    }
}
