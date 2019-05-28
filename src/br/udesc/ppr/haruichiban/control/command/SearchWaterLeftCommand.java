package br.udesc.ppr.haruichiban.control.command;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.SelectionIndicator;
import br.udesc.ppr.haruichiban.model.card.Water;

public class SearchWaterLeftCommand extends BoardCommand {

    public SearchWaterLeftCommand(int row, int column, Card[][] cards) {
        super(row, column, cards);
    }

    @Override
    public void execute() {
        if (column - 1 >= 0) {
            if (cards[row][column - 1].getClass().equals(Water.class)) {
                cards[row][column - 1] = new SelectionIndicator();
            } else {
                column--;
                execute();
            }
        }
    }

}
