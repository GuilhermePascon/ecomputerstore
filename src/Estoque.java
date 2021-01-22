/*-----------------MC322---------------*/
/* Projeto: eComputerStore             */
/* Grupo: Angelo H Barbosa      166527 */
/*        Francisco G Pena      234589 */
/*        Guilherme H Pascon    235980 */
/*        Luís Felipe L B Silva 156441 */
/*                                     */
/* Data: dez 2020                      */
/*-------------------------------------*/

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*----- Classe Estoque -----*/

public class Estoque {

    private static int quantEstoque = 0;
    
    private int id;
    private ArrayList<Integer> quantProdutos;
    private ArrayList<Produto> produtos;
    
    private GregorianCalendar relatCreateDate;

    /* Construtor */
    public Estoque(int id) {
        quantEstoque++;
        
        this.id = id;
        this.quantProdutos = new ArrayList<Integer>();
        this.produtos = new ArrayList<Produto>();
        relatCreateDate = new GregorianCalendar();
    }
    
    /* Metodos */
    public int addProdutoEstoque(Produto produto) { // retorna o ID do produto nesse Estoque
        boolean status;
        
        if (!(this.getProdutos().contains(produto))) {
            this.getProdutos().add(produto);
            this.getQuantProdutos().add(0);
            for (Produto p : this.getProdutos()){
                if (p == produto) {
                    return p.getId();
                }
            }
        }
        else {
            status = this.addQuantEstoque(1, produto);
            for(Produto p : this.getProdutos()){
                if(p == produto)
                    return p.getId();
            }
        }
        return -1; // Não acontece
    }
    
    public boolean addQuantEstoque(int quant, Produto produto){
        if (this.produtos.contains(produto)){
            this.quantProdutos.set(produto.getId(), quant + this.quantProdutos.get(produto.getId()));
            return true;
         } else {
            return false;
        }
    }

    public boolean removeQuantEstoque(int quant, Produto produto){
        if (this.produtos.contains(produto)) {
            if (this.getQuantProdutos().get(produto.getId()) >= quant) {
                this.quantProdutos.set(produto.getId(), quant - this.quantProdutos.get(produto.getId()));
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    public void relatorioEstoque(String filename) {
        int i;
        try {
            SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Formatter outEstoque = new Formatter(filename);
            outEstoque.format("Data do Relatório: %s\n", formattedDate.format(relatCreateDate.getTime()));

            for (i=0; i < this.getProdutos().size(); i++) { // Produto p : this.getProdutos()1
//                outEstoque.format("%d %s %d\n", getProdutos().get(i).getId(), getProdutos().get(i).getDescricao(), getQuantProdutos().get(getProdutos().get(i).getId()));
                outEstoque.format("%d %s\n", getProdutos().get(i).getId(), getProdutos().get(i).getDescricao());
            }

            outEstoque.flush();

        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void carregarEstoque(String filename){
        
        try{
            Scanner input = new Scanner(new File(filename));
            System.out.println("Lendo Arquivo de Estoque\n");

            while(input.hasNext()){
                this.addProdutoEstoque(new Peca(input.next(), input.next(), input.nextFloat(), input.nextFloat()));
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    /* Getters e Setters */
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    private void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public static int getQuantEstoque() {
        return quantEstoque;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getQuantProdutos() {
        return quantProdutos;
    }

    private void setQuantProdutos(int idProduto, int qnt) {
        this.quantProdutos.set(idProduto, qnt);
    }

    @Override
    public String toString() {
        return "Estoque: " + id +
                "Quantidade de Produtos=" + quantProdutos +
                "Produtos=" + produtos;
    }
}
