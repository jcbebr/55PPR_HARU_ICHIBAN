package br.udesc.ppr.haruichiban.control.command;

import br.udesc.ppr.haruichiban.model.card.Card;

public abstract class BoardCommand {

    protected int row;
    protected int column;
    protected Card[][] cards;

    public BoardCommand(int row, int column, Card[][] cards) {
        this.row = row;
        this.column = column;
        this.cards = cards;
    }

    public abstract void execute();

}
