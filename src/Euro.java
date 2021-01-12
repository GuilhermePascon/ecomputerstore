public class Euro implements Cambio {

    private static float euro;

    @Override
    public float getCotacao() {
        return euro;
    }

    @Override
    public void setCotacao(float cotacao) {
        Euro.euro = cotacao;
    }

    @Override
    public float converteCotacao(Cambio moeda1, Cambio moeda2, float valor) {
        return (moeda2.getCotacao()/moeda1.getCotacao()) * valor;
    }
}
