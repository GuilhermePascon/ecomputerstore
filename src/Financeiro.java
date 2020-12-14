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
import java.util.Collection;
import java.util.Collections;

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

    public ArrayList<Integer> maisVendido(){
        Estatistica st = new Estatistica();
        ArrayList<Pedido> pedidos = Comercial.getListaPedidos();
        ArrayList<Integer> qnt_ped = new ArrayList<Integer>(Collections.nCopies(Produto.getQuantTotalProduto(), 0));
        for (int i = 0; i < pedidos.size(); i++){
            ArrayList<Produto> prod = pedidos.get(i).getCarrinho();
            for (int j = 0; j < prod.size(); j++){
                int aux = prod.get(j).getId();
                qnt_ped.add(aux, qnt_ped.get(aux) + 1); // Adiciona 1 a posição id de qnt_ped
            }
        }
        return st.maisVendido(qnt_ped); // Retorna id do produto mais vendido
    }

    /* Getter e Setter */
    public static float getCaixaTotal() {
        return caixaTotal;
    }

    public static void setCaixaTotal(float caixaTotal) {
        Financeiro.caixaTotal = caixaTotal;
    }
}
