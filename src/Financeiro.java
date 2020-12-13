/*-----------------MC322---------------*/
/* Projeto: eComputerStore             */
/* Grupo: Angelo H Barbosa      166527 */
/*        Franscisco G Pena     234589 */
/*        Guilherme H Pascon    235980 */
/*        Luís Felipe L B Silva 156441 */
/*                                     */
/* Data: dez 2020                      */
/*-------------------------------------*/

public class Financeiro {
    private static float caixaTotal;

    public static float getCaixaTotal() {
        return caixaTotal;
    }

    public static void setCaixaTotal(float caixaTotal) {
        Financeiro.caixaTotal = caixaTotal;
    }
}
