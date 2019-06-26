package br.udesc.ppr.haruichiban.control.strategy;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author 10480989907
 */
public interface MoveCardsStrategy {
    
    void move(int row, int column, int lastSelected, Card[][] cards);
    
}
