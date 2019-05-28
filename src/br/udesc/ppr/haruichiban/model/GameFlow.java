package br.udesc.ppr.haruichiban.model;

/**
 *
 * @author José Carlos Bernardes Brümmer
 */
public enum GameFlow {

    STAGE01("Etapa 01 - Definição de jardineiros", "Jogador amarelo, escolha a carta"),
    STAGE02("Etapa 01 - Definição de jardineiros", "Jogador vermelho, escolha a carta"),
    STAGE03("Etapa 02 - Jogada do jardineiro júnior","Posicione sua peça"),
    STAGE04("Etapa 03 - Jogada do jardineiro sênior","Posicione sua peça"),
    STAGE05("Etapa 03 - Jogada do jardineiro sênior","Posicione a peça retirada anteriormente"),
    STAGE06("Etapa 04 - Haru Ichiban","Jardineiro junior indica o Nenúfar a ser movido"),
    STAGE07("Etapa 04 - Haru Ichiban","Jardineiro junior indica a direção"),
    STAGE08("Etapa 05 - Escolha do nenúfar escuro","Jardineiro sênior"),
    STAGE09("Etapa 05 - Escolha do nenúfar escuro","Posicione a peça retirada anteriormente");

    private final String name;
    private final String info;

    private GameFlow(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

}
