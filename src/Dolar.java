public class Dolar implements Cambio{

    private static float dolar;

    @Override
    public float getCotacao() {
        return dolar;
    }

    @Override
    public void setCotacao(float cotacao) {
        Dolar.dolar = cotacao;
    }

    @Override
    public float converteCotacao(Cambio moeda1, Cambio moeda2, float valor) {
        return (moeda2.getCotacao()/moeda1.getCotacao()) * valor;
    }
}
