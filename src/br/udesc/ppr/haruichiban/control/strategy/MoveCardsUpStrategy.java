package br.udesc.ppr.haruichiban.control.strategy;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.SelectionIndicator;

/**
 *
 * @author 10480989907
 */
public class MoveCardsUpStrategy implements MoveCardsStrategy{

    @Override
    public void move(int row, int column, int lastSelected, Card[][] cards) {
        for (int i = lastSelected; i > row; i--) {
            for (int j = lastSelected; j > row; j--) {
                if (cards[j - 1][column].getClass().equals(SelectionIndicator.class)) {
                    cards[j - 1][column] = cards[j][column];
                    cards[j][column] = new SelectionIndicator();
                }
            }
        }
    }
    
}

