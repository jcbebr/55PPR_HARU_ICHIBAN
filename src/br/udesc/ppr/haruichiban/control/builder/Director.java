package br.udesc.ppr.haruichiban.control.builder;

/**
 *
 * @author 10480989907
 */
public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construir() {
        builder.reset();

        builder.buildWater();
        builder.buildBrightNenuphar();
        builder.buildDarkNenuphar();
        builder.buildRedFrog();
        builder.buildYellowFrog();
    }

}
