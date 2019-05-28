package br.udesc.ppr.haruichiban.control.command;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.SelectionIndicator;

public class MoveCardsRightCommand extends BoardCommand {

    private int lastColumnSelected;

    public MoveCardsRightCommand(int row, int column, int lastRowSelected, Card[][] cards) {
        super(row, column, cards);
        this.lastColumnSelected = lastRowSelected;
    }

    @Override
    public void execute() {
        for (int i = lastColumnSelected; i < column; i++) {
            for (int j = lastColumnSelected; j < column; j++) {
                if (cards[row][j + 1].getClass().equals(SelectionIndicator.class)) {
                    cards[row][j + 1] = cards[row][j];
                    cards[row][j] = new SelectionIndicator();
                }
            }
        }
    }
}
