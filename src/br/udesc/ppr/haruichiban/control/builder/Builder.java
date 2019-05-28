package br.udesc.ppr.haruichiban.control.builder;

/**
 *
 * @author 10480989907
 */
public abstract class Builder {

    protected Board board;

    public void reset() {
        this.board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public abstract void buildWater();

    public abstract void buildBrightNenuphar();

    public abstract void buildDarkNenuphar();

    public abstract void buildRedFrog();

    public abstract void buildYellowFrog();

}
