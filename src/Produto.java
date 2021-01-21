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


/*----- Classe Produto -----*/
/* Objetivo: */
/*--------------------------*/
abstract class Produto {

    private static int quantTotalProduto = 0;

    private int id;
    private String descricao;
    private String dimensao; // no formato "AxBxCcm"
    protected float custo;
    protected float margemLucro;

    /*Contrutor Produto Avulso*/
    public Produto(String descricao, String dimensao, float custo, float margemLucro) {
        quantTotalProduto++;

        this.id = quantTotalProduto;
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.custo = custo;
        this.margemLucro = margemLucro;
    }

    /*Contrutor Novo Cadastro de Produto*/
    public Produto(Estoque estoque, int quant, String descricao, String dimensao, float custo, float margemLucro) {
        int flag = 0;
        boolean status;

        for (Produto p : estoque.getProdutos()) { // Checo se ja tem algum produto com a mesma descricao no estoque indicado
            if (descricao == p.getDescricao()) {
                flag++;
            }
        }

        if (flag == 0){ // se nao houver, adiciono o novo item no estoque indicado
            quantTotalProduto++;

            this.descricao = descricao;
            this.dimensao = dimensao;
            this.custo = custo;
            this.margemLucro = margemLucro;

            this.id = estoque.addProdutoEstoque(this);
            status = estoque.addQuantEstoque(quant, this);
        }
        else { // se ja houver, crio o produto mas nao destino ele a algum estoque, portanto nao tem id
            quantTotalProduto++;

            this.descricao = descricao;
            this.dimensao = dimensao;
            this.custo = custo;
            this.margemLucro = margemLucro;
            this.id = -1;
        }
    }

    /* Metodos */
    public float getPreco() {
        return custo * margemLucro;
    }

    /* Getters e Setters*/
    public float getCusto() {
        return custo;
    }

    private void setCusto(float custo) {
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    private void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public String getDimensao() {
        return dimensao;
    }

    private void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static int getQuantTotalProduto() {
        return quantTotalProduto;
    }

    @Override
    public String toString() {
        return "Produto: " +
                id +
                ", descricao='" + descricao + '\'' +
                ", dimensao='" + dimensao + '\'' +
                ", custo=" + custo +
                ", margemLucro=" + margemLucro;
    }
}