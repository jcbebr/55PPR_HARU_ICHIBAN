package br.udesc.ppr.haruichiban.model.card.flower;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 13/05/2019
 */
public class RedFlower02 extends Card implements RedFlower {

    public RedFlower02() {
        super("RedFlower02", RedFlower.class);
    }

    @Override
    public int getId() {
        return 2;
    }

}
