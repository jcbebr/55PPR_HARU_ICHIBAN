package br.udesc.ppr.haruichiban.control.command;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.SelectionIndicator;
import br.udesc.ppr.haruichiban.model.card.Water;

public class SearchWaterDownCommand extends BoardCommand {

    public SearchWaterDownCommand(int row, int column, Card[][] cards) {
        super(row, column, cards);
    }

    @Override
    public void execute() {
        if (row + 1 <= 4) {
            if (cards[row + 1][column].getClass().equals(Water.class)) {
                cards[row + 1][column] = new SelectionIndicator();
            } else {
                row = row + 1;
                execute();
            }
        }
    }
}
