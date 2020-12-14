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

public class Estatistica {
    private static float dolar;

    /* Métodos */
    public static ArrayList<Integer> maisVendido(ArrayList<Integer> produtos) {
        int maisVendidos = -1;
        int pos_mais = - 1;
        ArrayList<Integer> mais_vendidos = new ArrayList<>();
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i) > maisVendidos){
                pos_mais = i;
                maisVendidos = produtos.get(i);
            }
        }
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).equals(produtos.get(pos_mais)))
                mais_vendidos.add(i);
        }
        return mais_vendidos;
    }

    public float media(ArrayList<Float> margens){
        float soma = 0;
        int qnt = 0;
        for (int i = 0; i < margens.size(); i++){
            soma = soma + margens.get(i);
            qnt = qnt + 1;
        }
            return soma/qnt;
    }
    /* Getters e Setters */
    public static float getDolar() {
        return dolar;
    }

    public static void setDolar(float dolar) {
        Estatistica.dolar = dolar;
    }
    
    
}
