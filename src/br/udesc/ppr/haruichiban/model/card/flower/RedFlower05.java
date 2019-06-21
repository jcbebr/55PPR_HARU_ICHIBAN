package br.udesc.ppr.haruichiban.model.card.flower;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 15/05/2019
 */
public class RedFlower05 extends Card implements RedFlower {

    public RedFlower05() {
        super("RedFlower05", RedFlower.class);
    }

    @Override
    public int getId() {
        return 5;
    }

}
