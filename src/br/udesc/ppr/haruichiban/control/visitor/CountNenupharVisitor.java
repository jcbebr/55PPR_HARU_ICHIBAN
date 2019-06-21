package br.udesc.ppr.haruichiban.control.visitor;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.nenuphar.BrightNenuphar;
import br.udesc.ppr.haruichiban.model.card.nenuphar.DarkNenuphar;

public class CountNenupharVisitor implements Visitor {

    private int value;

    public CountNenupharVisitor() {
        this.value = 0;
    }

    @Override
    public void visit(Card card) {
        if (card.getClass().equals(BrightNenuphar.class) || card.getClass().equals(DarkNenuphar.class)) {
            value++;
        }
    }

    public int getValue() {
        return value;
    }

}
