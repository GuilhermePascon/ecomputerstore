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
    public int maisVendido(ArrayList<Integer> produtos){
        int qnt_vendas = 0;
        int maisVendidos;
        for (int i = 0; i < produtos.size(); i++);
        // Incompleto (Necessita alinhar com Estoque)
        return 0;
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
