package br.udesc.ppr.haruichiban.control.command;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.SelectionIndicator;

public class MoveCardsUpCommand extends BoardCommand {

    private int lastRowSelected;

    public MoveCardsUpCommand(int row, int column, int lastRowSelected, Card[][] cards) {
        super(row, column, cards);
        this.lastRowSelected = lastRowSelected;
    }

    @Override
    public void execute() {
        for (int i = lastRowSelected; i > row; i--) {
            for (int j = lastRowSelected; j > row; j--) {
                if (cards[j - 1][column].getClass().equals(SelectionIndicator.class)) {
                    cards[j - 1][column] = cards[j][column];
                    cards[j][column] = new SelectionIndicator();
                }
            }
        }
    }
}
