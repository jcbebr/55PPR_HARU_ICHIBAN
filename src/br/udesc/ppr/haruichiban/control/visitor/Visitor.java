package br.udesc.ppr.haruichiban.control.visitor;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 */
public interface Visitor {
    
    void visit(Card card);
    
}
