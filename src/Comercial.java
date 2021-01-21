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

public class Comercial {
    private static ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();


    public static ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
    
    public void finalizarPedido(Pedido p){
        if(!p.getPedidoFinalizado())
            p.setPedidoFinalizado(true);
    }

}
