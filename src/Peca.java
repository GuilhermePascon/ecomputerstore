import java.util.ArrayList;

public class Peca extends Produto {

    public Peca(String descricao, String dimensao, float custo, float margemLucro) {
        super(descricao, dimensao, custo, margemLucro);
    }

    public Peca(Estoque estoque, int quant, String descricao, String dimensao, float custo, float margemLucro) {
        super(estoque, quant, descricao, dimensao, custo, margemLucro);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
