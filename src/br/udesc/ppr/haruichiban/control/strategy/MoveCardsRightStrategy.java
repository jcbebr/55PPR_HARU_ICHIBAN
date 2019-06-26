/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ppr.haruichiban.control.strategy;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.SelectionIndicator;

/**
 *
 * @author 10480989907
 */
public class MoveCardsRightStrategy implements MoveCardsStrategy{

    @Override
    public void move(int row, int column, int lastSelected, Card[][] cards) {
        for (int i = lastSelected; i < column; i++) {
            for (int j = lastSelected; j < column; j++) {
                if (cards[row][j + 1].getClass().equals(SelectionIndicator.class)) {
                    cards[row][j + 1] = cards[row][j];
                    cards[row][j] = new SelectionIndicator();
                }
            }
        }
    }
    
}
