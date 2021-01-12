public interface Cambio {

    float getCotacao();

    void setCotacao(float dolar);

    float converteCotacao(Cambio moeda1, Cambio moeda2, float valor); // Converte cotacao de moeda1 para moeda2
}
