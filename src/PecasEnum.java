/*-----------------MC322---------------*/
/* Projeto: eComputerStore             */
/* Grupo: Angelo H Barbosa      166527 */
/*        Francisco G Pena      234589 */
/*        Guilherme H Pascon    235980 */
/*        Luís Felipe L B Silva 156441 */
/*                                     */
/* Data: dez 2020                      */
/*-------------------------------------*/

public enum PecasEnum {
    intelI7 ("Processador", "4.4Ghz"),
    intelI5 ("Processador", "3.6Ghz"),
    GTX1050 ("Placa de Video", "4G"),
    RTX2080 ("Placa de Video", "8G"),
    SSDKingston ("Armazenamento", "240G"),
    CoolerASUS ("Cooler", "120mm");

    private String tipo;
    private String spec;

    PecasEnum(String tipo, String spec) {
        this.tipo = tipo;
        this.spec = spec;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSpec() {
        return spec;
    }
}
