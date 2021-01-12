public class Real implements Cambio {

    private static float real;

    @Override
    public float getCotacao() {
        return real;
    }

    @Override
    public void setCotacao(float cotacao) {
        Real.real = cotacao;
    }

    @Override
    public float converteCotacao(Cambio moeda1, Cambio moeda2, float valor) {
        return (moeda2.getCotacao()/moeda1.getCotacao()) * valor;
    }
}
